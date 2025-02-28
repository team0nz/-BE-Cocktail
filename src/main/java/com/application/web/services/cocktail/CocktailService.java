package com.application.web.services.cocktail;

import com.application.common.Constant;
import com.application.common.exception.custom.CustomApiException;
import com.application.domain.cocktail.dto.CocktailInfoDto;
import com.application.domain.cocktail.dto.ReqPersonalizeCocktailDto;
import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingIngredient;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingRecommend;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingTaste;
import com.application.domain.cocktail.entity.cocktail.TasteCategory;
import com.application.domain.cocktail.entity.cocktail.TasteDetail;
import com.application.domain.cocktail.repository.CocktailRepository;
import com.application.domain.cocktail.repository.Mapping.MappingIngredientRepository;
import com.application.domain.cocktail.repository.Mapping.MappingRecommendRepository;
import com.application.domain.cocktail.repository.Mapping.MappingTasteRepository;
import com.application.domain.cocktail.repository.TasteCategoryRepository;
import com.application.domain.cocktail.repository.TasteDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
@RequiredArgsConstructor
public class CocktailService {
    private final TasteCategoryRepository tasteCategoryRepository;
    private final TasteDetailRepository tasteDetailRepository;
    private final MappingTasteRepository mappingTasteRepository;
    private final MappingIngredientRepository mappingIngredientRepository;
    private final MappingRecommendRepository mappingRecommendRepository;
    private final CocktailRepository cocktailRepository;
    

    public List<CocktailInfoDto> getCocktailFindAll(){
        List<CocktailInfoDto> dtos = new ArrayList<>();

        List<Cocktail> cocktails = cocktailRepository.findAll();

        for (Cocktail cocktail : cocktails) {
            CocktailInfoDto dto = getCocktailInfo(cocktail.getId());
            dtos.add(dto);
        }
        return dtos;
    }

    public CocktailInfoDto getCocktailInfo(Long id){
        HashMap<String, Object> map = new HashMap<>();
        Cocktail cocktail = cocktailRepository.findById(id).orElseThrow(
                () -> new CustomApiException("칵테일이 존재하지 않습니다.")
        );

        List<MappingTaste> tastes = mappingTasteRepository.findByCocktail(cocktail);
        List<MappingIngredient> ingredients = mappingIngredientRepository.findByCocktail(cocktail);
        List<MappingRecommend> recommends = mappingRecommendRepository.findByCocktail(cocktail);

        return CocktailInfoDto.builder()
                        .cocktail(cocktail)
                        .mappingTaste(tastes)
                        .mappingIngredient(ingredients)
                        .mappingRecommend(recommends)
                        .build();
    }

    public List<TasteCategory> getTasteCategory(){
        return tasteCategoryRepository.findAll();
    }
    public List<TasteDetail> getTasteDetail(Long tasteCategoryId) {return tasteDetailRepository.findByTasteCategory(tasteCategoryId); }

    public CocktailInfoDto getPersonalizeCocktail(ReqPersonalizeCocktailDto personalizeCocktail){
        List<MappingTaste> filteredList = getFilteredCocktail(personalizeCocktail);
        return randomCocktail(filteredList);
    }

    private List<MappingTaste> getFilteredCocktail(ReqPersonalizeCocktailDto dto){
        return getAlcholType(getTaste(dto), dto.getAlcholType());
    }

    private List<MappingTaste> getTaste(ReqPersonalizeCocktailDto personalizeCocktail){
        return mappingTasteRepository.findPersonalizeCocktailAll(personalizeCocktail.getTasteCategoryId(),
                                                                 personalizeCocktail.getTasteDetailid());
    }

    private List<MappingTaste> getAlcholType(List<MappingTaste> mappingTastes, Integer alcholType){

        List<MappingTaste> filteredList;

        switch (alcholType){
            case 1:
                filteredList = mappingTastes.stream()
                        .filter(entry -> entry.getCocktail().getMinAlchol() >= Constant.LITTLE_ALCHOL_MIN &&
                                entry.getCocktail().getMaxAlchol() <= Constant.LITTLE_ALCHOL_MAX)
                        .toList();
                break;
            case 2:
                filteredList = mappingTastes.stream()
                        .filter(entry -> entry.getCocktail().getMinAlchol() >= Constant.MIDDLE_ALCHOL_MIN &&
                                entry.getCocktail().getMaxAlchol() <= Constant.MIDDLE_ALCHOL_MAX)
                        .toList();
                break;
            case 3:
                filteredList = mappingTastes.stream()
                        .filter(entry -> entry.getCocktail().getMinAlchol() >= Constant.STRONG_ALCHOL_MIN &&
                                entry.getCocktail().getMaxAlchol() <= Constant.STRONG_ALCHOL_MAX)
                        .toList();
                break;
            default :
                filteredList = mappingTastes;
        }

        return filteredList;
    }

    private CocktailInfoDto randomCocktail(List<MappingTaste> filteredList){
        if (filteredList.isEmpty()) {
            throw new CustomApiException("No cocktail found");
        }
        int randomIndex = ThreadLocalRandom.current().nextInt(filteredList.size());
        return getCocktailInfo(filteredList.get(randomIndex).getCocktail().getId());
    }

}
