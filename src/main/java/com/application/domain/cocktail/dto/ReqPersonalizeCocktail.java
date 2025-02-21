package com.application.domain.cocktail.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqPersonalizeCocktail {
    private Long tasteDetailid;
    private Long tasteCategoryId;
    private Integer alcholType;
}
