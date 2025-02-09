package com.application.domain.cocktail.repository.Mapping;

import com.application.domain.cocktail.entity.cocktail.Mapping.MappingIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingIngredientRepository extends JpaRepository<MappingIngredient, Long> {
}
