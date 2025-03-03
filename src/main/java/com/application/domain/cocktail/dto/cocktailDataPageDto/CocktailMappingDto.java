package com.application.domain.cocktail.dto.cocktailDataPageDto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CocktailMappingDto {
    private Long cocktailId;
    private List<IngredientSaveDto> ingredientDtos;
    private Long tasteCategoryId;
    private List<Long> tasteDetailIds;
    private List<Long> moodIds;
    private List<Long> situationIds;
    private List<Long> seasonIds;
}
