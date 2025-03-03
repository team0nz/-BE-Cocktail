package com.application.domain.cocktail.dto.cocktailDataPageDto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UpdateCocktailDto {
    private Long cocktailId;
    private List<IngredientMappingDto> ingredientMappingDtos = new ArrayList<>();

    // 맛 매핑은 여러 행을 개별 DTO로 받음
    private List<TasteMappingDto> tasteMappingDtos = new ArrayList<>();

    // 추천 매핑도 여러 행을 개별 DTO로 받음
    private List<RecommendMappingDto> recommendMappingDtos = new ArrayList<>();
}
