package com.application.domain.bar.repository;

import com.application.domain.bar.entity.Bar;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberTemplate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.application.domain.bar.entity.QBar.bar;
import static com.application.domain.menu.entity.QMenu.menu;

@Repository
@RequiredArgsConstructor
public class BarSearchRepositoryImpl implements BarSearchRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Bar> findBarsByName(String barName, Pageable pageable) {
        List<Bar> bars = queryFactory
                .selectFrom(bar)
                .where(barNameContains(barName))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(bar.count())
                .from(bar)
                .where(barNameContains(barName));

        return PageableExecutionUtils.getPage(bars, pageable,
                () -> Optional.ofNullable(countQuery.fetchOne()).orElse(0L));
    }

    @Override
    public Page<Bar> findBarsByMenu(String menuName, Pageable pageable) {
        List<Bar> bars = queryFactory
                .selectDistinct(bar)
                .from(bar)
                .join(menu).on(menu.bar.eq(bar))
                .where(menuNameContains(menuName))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(bar.id.countDistinct())
                .from(bar)
                .join(menu).on(menu.bar.eq(bar))
                .where(menuNameContains(menuName));

        return PageableExecutionUtils.getPage(bars, pageable,
                () -> Optional.ofNullable(countQuery.fetchOne()).orElse(0L));
    }

    @Override
    public Page<Bar> findByCurrentCoordinates(double currentX, double currentY, double radius, Pageable pageable) {

        double earthRadius = 6371.0;

        List<Bar> bars = queryFactory
                .selectFrom(bar)
                .where(distanceExpression(earthRadius, currentX, currentY).loe(radius))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(bar.count())
                .from(bar)
                .where(distanceExpression(earthRadius, currentX, currentY).loe(radius));

        return PageableExecutionUtils.getPage(bars, pageable,
                () -> Optional.ofNullable(countQuery.fetchOne()).orElse(0L));
    }

    private BooleanExpression barNameContains(String barName) {
        return bar.barName.containsIgnoreCase(barName);
    }

    private BooleanExpression menuNameContains(String menuName) {
        return menu.name.containsIgnoreCase(menuName);
    }

    private NumberTemplate<Double> distanceExpression(double earthRadius, double currentX, double currentY) {
        return Expressions.numberTemplate(Double.class,
                "(?1 * acos(cos(radians(?2)) * cos(radians({0})) * cos(radians({1}) - radians(?3)) + sin(radians(?2)) * sin(radians({0}))))",
                earthRadius, currentY, bar.y, bar.x, currentX);
    }
}
