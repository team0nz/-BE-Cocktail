package com.application.domain.cocktail.repository;

import com.application.domain.cocktail.entity.cocktail.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendRepository extends JpaRepository<Recommend, Long> {
}
