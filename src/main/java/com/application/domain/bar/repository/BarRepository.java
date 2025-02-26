package com.application.domain.bar.repository;

import com.application.domain.bar.entity.Bar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarRepository extends JpaRepository<Bar, Long> {
}
