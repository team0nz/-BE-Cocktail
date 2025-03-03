package com.application.domain.cocktail.dto.cocktailDataPageDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendMappingDto {
    private Long mappingRecommendId;
    private Long moodId;
    private Long situationId;
    private Long seasonId;
}
