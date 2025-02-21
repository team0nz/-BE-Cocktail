package com.application.domain.cocktail.repository.Mapping;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingIngredient;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingTaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MappingIngredientRepository extends JpaRepository<MappingIngredient, Long> {
    List<MappingIngredient> findByCocktail(Cocktail cocktail);
}
