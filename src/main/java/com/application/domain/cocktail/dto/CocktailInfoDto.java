package com.application.domain.cocktail.dto;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingIngredient;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingRecommend;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingTaste;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CocktailInfoDto {
    private Cocktail cocktail;
    private List<MappingTaste> mappingTaste;
    private List<MappingRecommend> mappingRecommend;
    private List<MappingIngredient> mappingIngredient;

    @Builder
    public CocktailInfoDto(Cocktail cocktail, List<MappingTaste> mappingTaste, List<MappingRecommend> mappingRecommend, List<MappingIngredient> mappingIngredient){
        this.cocktail =cocktail;
        this.mappingTaste = mappingTaste;
        this.mappingRecommend = mappingRecommend;
        this.mappingIngredient = mappingIngredient;
    }
}
