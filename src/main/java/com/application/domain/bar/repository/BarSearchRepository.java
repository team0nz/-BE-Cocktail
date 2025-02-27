package com.application.domain.bar.repository;

import com.application.domain.bar.entity.Bar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BarSearchRepository {

    Page<Bar> findBarsByNameOrMenuName(String keyword, Pageable pageable);
    Page<Bar> findByCurrentCoordinates(double currentX, double currentY, double radius, Pageable pageable);

}
