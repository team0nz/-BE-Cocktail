package com.application.domain.cocktail.repository;

import com.application.domain.cocktail.entity.cocktail.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
