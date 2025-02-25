package com.application.web.services.cocktail;

import com.application.common.Constant;
import com.application.common.exception.custom.CustomApiException;
import com.application.domain.cocktail.dto.ReqPersonalizeCocktail;
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
    
    //칵테일 전체 조회
    public List<HashMap<String, Object>> getCocktailFindAll(){
        List<HashMap<String, Object>> maps = new ArrayList<>();

        List<Cocktail> cocktails = cocktailRepository.findAll();

        for (Cocktail cocktail : cocktails) {
            HashMap<String, Object> map = getCocktailInfo(cocktail.getId());
            maps.add(map);
        }

        return maps;
    }

    //칵테일 개별 정보 조회
    public HashMap<String, Object> getCocktailInfo(Long id){
        HashMap<String, Object> map = new HashMap<>();
        Cocktail cocktail = cocktailRepository.findById(id).orElseThrow(
                () -> new CustomApiException("칵테일이 존재하지 않습니다.")
        );

        List<MappingTaste> tastes = mappingTasteRepository.findByCocktail(cocktail);
        List<MappingIngredient> ingredients = mappingIngredientRepository.findByCocktail(cocktail);
        List<MappingRecommend> recommends = mappingRecommendRepository.findByCocktail(cocktail);


        map.put("cocktail", cocktail);
        map.put("taste", tastes);
        map.put("ingredient", ingredients);
        map.put("recommand", recommends);

        return map;
    }

    //칵테일 맛 카테고리 전체조회
    public List<TasteCategory> getTasteCategory(){
        return tasteCategoryRepository.findAll();
    }
    
    // 칵테일 디테일 맛 전체조회
    public List<TasteDetail> getTasteDetail(Long tasteCategoryId) {return tasteDetailRepository.findByTasteCategory(tasteCategoryId); }

    public HashMap<String, Object> getPersonalizeCocktail(ReqPersonalizeCocktail personalizeCocktail){
        
        //맛
        List<MappingTaste> mappingTastes = mappingTasteRepository.findPersonalizeCocktailAll(personalizeCocktail.getTasteCategoryId(), personalizeCocktail.getTasteDetailid());

        Integer alcholType =personalizeCocktail.getAlcholType();
        List<MappingTaste> filteredList = mappingTastes;
            
        //도수
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

        //랜덤도출
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int randomIndex = rand.nextInt(filteredList.size());

        return getCocktailInfo(filteredList.get(randomIndex).getCocktail().getId());
    }


}
