package com.application.domain.cocktail.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqPersonalizeCocktailDto {
    private Long tasteDetailid;
    private Long tasteCategoryId;
    private Integer alcholType;
}
