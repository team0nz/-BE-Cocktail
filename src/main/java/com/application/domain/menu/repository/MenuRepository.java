package com.application.domain.menu.repository;

import com.application.domain.bar.entity.Bar;
import com.application.domain.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findAllByBar(Bar bar);
    List<Menu> findTop5ByBar(Bar bar);
}
