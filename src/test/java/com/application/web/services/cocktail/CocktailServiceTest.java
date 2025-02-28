package com.application.web.services.cocktail;

import com.application.domain.cocktail.dto.CocktailInfoDto;
import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingIngredient;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingRecommend;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingTaste;
import com.application.domain.cocktail.repository.CocktailRepository;
import com.application.domain.cocktail.repository.Mapping.MappingIngredientRepository;
import com.application.domain.cocktail.repository.Mapping.MappingRecommendRepository;
import com.application.domain.cocktail.repository.Mapping.MappingTasteRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CocktailServiceTest {

    @InjectMocks
    private CocktailService cocktailService;
    @Mock
    private CocktailRepository cocktailRepository;

    @Mock
    private MappingRecommendRepository mappingRecommendRepository;

    @Mock
    private MappingTasteRepository mappingTasteRepository;
    @Mock
    private MappingIngredientRepository mappingIngredientRepository;

    @Test
    void getCocktailFindAll() {
        //given
        Cocktail cocktail = new Cocktail(1L,"test", 300, "cocktail", 32, 30);
        List<Cocktail> cocktails = List.of(cocktail);
        when(cocktailRepository.findAll()).thenReturn(cocktails);
        when(cocktailRepository.findById(1L)).thenReturn(Optional.of(cocktail));

        List<MappingIngredient> ingredientList = new ArrayList<>();
        List<MappingTaste> tasteList = new ArrayList<>();
        List<MappingRecommend> recommendList = new ArrayList<>();
        when(mappingIngredientRepository.findByCocktail(cocktail)).thenReturn(ingredientList);
        when(mappingTasteRepository.findByCocktail(cocktail)).thenReturn(tasteList);
        when(mappingRecommendRepository.findByCocktail(cocktail)).thenReturn(recommendList);


        //when
        List<CocktailInfoDto> result = cocktailService.getCocktailFindAll();

        //then
        Assertions.assertEquals(result.get(0).getCocktail(), cocktail);


    }

    @Test
    void getCocktailInfo() {
    }

    @Test
    void getTasteCategory() {
    }

    @Test
    void getTasteDetail() {
    }

    @Test
    void getPersonalizeCocktail() {
    }
}