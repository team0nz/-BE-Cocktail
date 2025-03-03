package com.application.domain.cocktail.dto.cocktailDataPageDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientMappingDto {
    private Long mappingIngredientId;
    private IngredientSaveDto ingredientSaveDto;
}
