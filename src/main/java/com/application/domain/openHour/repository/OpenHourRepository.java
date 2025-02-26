package com.application.domain.openHour.repository;

import com.application.domain.bar.entity.Bar;
import com.application.domain.openHour.entity.OpenHour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpenHourRepository extends JpaRepository<OpenHour, Long> {

    List<OpenHour> findAllByBar(Bar bar);
}
