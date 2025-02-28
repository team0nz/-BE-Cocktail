package com.application.domain.cocktail.dto;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.recommand.Situation;
import com.application.domain.cocktail.entity.cocktail.recommand.Mood;
import com.application.domain.cocktail.entity.cocktail.recommand.Season;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MappingRecommendDto {
    private Long mappingRecommendId;
    private Cocktail cocktail;
    private Situation situation;
    private Mood mood;
    private Season season;

    @Builder
    public MappingRecommendDto(Long mappingRecommendId, Cocktail cocktail, Situation situation, Mood mood, Season season){
        this.mappingRecommendId = mappingRecommendId;
        this.cocktail = cocktail;
        this.situation = situation;
        this.mood = mood;
        this.season = season;
    }
}
