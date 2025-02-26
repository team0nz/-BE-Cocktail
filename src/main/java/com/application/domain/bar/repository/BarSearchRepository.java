package com.application.domain.bar.repository;

import com.application.domain.bar.entity.Bar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BarSearchRepository {

    Page<Bar> findBarsByName(String barName, Pageable pageable);
    Page<Bar> findBarsByMenu(String menuName, Pageable pageable);
    Page<Bar> findByCurrentCoordinates(double currentX, double currentY, double radius, Pageable pageable);

}
