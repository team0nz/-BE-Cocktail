package com.application.domain.cocktail.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IngredientMappingDto {
    private Long mappingIngredientId;
    private IngredientSaveDto ingredientSaveDto;
}
