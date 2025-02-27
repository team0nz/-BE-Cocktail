package com.application.domain.barImage.repository;

import com.application.domain.bar.entity.Bar;
import com.application.domain.barImage.entity.BarImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarImageRepository extends JpaRepository<BarImage, Long> {

    List<BarImage> findAllByBar(Bar bar);
    BarImage findFirstByBar(Bar bar);
}
