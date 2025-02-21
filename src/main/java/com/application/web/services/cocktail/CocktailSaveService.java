package com.application.web.services.cocktail;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.Ingredient;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingIngredient;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingRecommend;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingTaste;
import com.application.domain.cocktail.entity.cocktail.TasteCategory;
import com.application.domain.cocktail.entity.cocktail.TasteDetail;
import com.application.domain.cocktail.entity.cocktail.recommand.Location;
import com.application.domain.cocktail.entity.cocktail.recommand.Mood;
import com.application.domain.cocktail.entity.cocktail.recommand.Season;
import com.application.domain.cocktail.repository.CocktailRepository;
import com.application.domain.cocktail.repository.IngredientRepository;
import com.application.domain.cocktail.repository.Mapping.MappingIngredientRepository;
import com.application.domain.cocktail.repository.Mapping.MappingRecommendRepository;
import com.application.domain.cocktail.repository.Mapping.MappingTasteRepository;
import com.application.domain.cocktail.repository.TasteCategoryRepository;
import com.application.domain.cocktail.repository.TasteDetailRepository;
import com.application.domain.cocktail.repository.recommand.LocationRepository;
import com.application.domain.cocktail.repository.recommand.MoodRepository;
import com.application.domain.cocktail.repository.recommand.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.MappingStartEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CocktailSaveService {
    private final MappingIngredientRepository mappingIngredientRepository;
    private final MappingRecommendRepository mappingRecommendRepository;
    private final MappingTasteRepository mappingTasteRepository;
    private final CocktailRepository cocktailRepository;

    private final TasteCategoryRepository tasteCategoryRepository;
    private final TasteDetailRepository tasteDetailRepository;

    private final LocationRepository locationRepository;
    private final MoodRepository moodRepository;
    private final SeasonRepository seasonRepository;

    private final IngredientRepository ingredientRepository;

    //칵테일 정보 조회
    public List<HashMap<String, Object>> getCocktailInfo(){
        List<HashMap<String, Object>> maps = new ArrayList<>();
        List<Cocktail> cocktails = cocktailRepository.findAll();
        for (Cocktail cocktail : cocktails) {
            HashMap<String,Object> map = new HashMap<>();
            List<MappingIngredient>ingredients =  mappingIngredientRepository.findByCocktail(cocktail);
            List<MappingTaste>tastes = mappingTasteRepository.findByCocktail(cocktail);
            List<MappingRecommend> recommends = mappingRecommendRepository.findByCocktail(cocktail);

            map.put("cocktail", cocktail);
            map.put("taste", tastes);
            map.put("recommand", recommends);

            maps.add(map);
        }

        return maps;
    }

    //맛(대분류) 조회
    public List<TasteCategory> getTasteCategoryAll(){
        return tasteCategoryRepository.findAll();
    }
    //맛(소분류) 조회
    public List<TasteDetail> getTasteDetailAll(){
        //CHECKME) taste 대분류에 따른 조회
        return tasteDetailRepository.findAll();
    }
    
    // 칵테일 추천장소 조회
    public List<Location> getLocationAll(){
        return locationRepository.findAll();
    }

    // 칵테일 추천분위기 조회
    public List<Mood> getMoodAll(){
        return moodRepository.findAll();
    }
    // 칵테일 추천계절 조회
    public List<Season> getSeasonAll(){
        return seasonRepository.findAll();
    }
    
    // 칵테일 재료 조회
    public List<Ingredient> getIngredientAll(){
        return ingredientRepository.findAll();
    }

    
    // 칵테일 + 맛 + 추천 + 재료 맵핑
    public void setCocktailAddIngredient(String material, List<String> tasteCategorys, List<String> tasteDetails,
                                         List<String> moods, List<String> locations, List<Season> seasons,
                                         String cocktailName, Integer cocktailSize, String introduce,
                                         Integer maxAlchol, Integer minAlchol){

        Cocktail saveCocktail = Cocktail.builder()
                .cocktailName(cocktailName)
                .cocktailSize(cocktailSize)
                .introduce(introduce)
                .maxAlchol(maxAlchol)
                .minAlchol(minAlchol)
                .build();

        List<Mood> saveMoods = new ArrayList<>();
        for (String mood : moods) {
            saveMoods.add(Mood.builder().mood(mood).build());
        }

    }


    //칵테일 정보 추가 및 수정

    //칵테일 맛(대분류) 추가 및 수정
    public void setTasteCategory(String tasteCategory){

    }
    //칵테일 맛(소분류) 추가 및 수정

    // 칵테일 추천장소 추가 및 수정
    // 칵테일 추천분위기 추가 및 수정
    // 칵테일 추천계절 추가 및 수정

    // 칵테일 재료 추가 및 수정
}
