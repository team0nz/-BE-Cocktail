package com.application.domain.cocktail.repository;

import com.application.domain.cocktail.entity.cocktail.TasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TasteCategoryRepository extends JpaRepository<TasteCategory, Long> {
    public Optional<TasteCategory> findById(Long id);
}
