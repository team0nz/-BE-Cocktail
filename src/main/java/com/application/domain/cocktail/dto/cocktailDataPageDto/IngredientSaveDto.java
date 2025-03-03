package com.application.domain.cocktail.dto.cocktailDataPageDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientSaveDto {
    private Long ingredientId;
    private Double quantity;
    private String unit;
}
