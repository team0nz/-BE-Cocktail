package com.application.web.services.cocktail;

import com.application.domain.cocktail.entity.cocktail.TasteCategory;
import com.application.domain.cocktail.repository.TasteCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CocktailService {
    private final TasteCategoryRepository tasteCategoryRepository;

    //칵테일 맛 카테고리 전체조회
    public List<TasteCategory> getTasteCategory(){
        return tasteCategoryRepository.findAll();
    }

    //칵테일 맞춤 정보 조회 (맛, 도수)
    // 맛을 선택 + 도수 선택
    // 맛 -> 필터링된 칵테일들
    // 도수 check
    // 마지막으로 필터링된 칵테일들 -> 랜덤 도출



    //칵테일 도수 평균값 조회


    //맞춤 조회 리스트 랜덤 선택

}
