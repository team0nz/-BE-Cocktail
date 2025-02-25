package com.application.web.services.cocktail;

import com.application.common.exception.custom.CustomApiException;
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

    //only 칵테일정보
    public List<Cocktail> getCocktailAll(){
        return cocktailRepository.findAll();
    }

    //맛(대분류) 조회
    public List<TasteCategory> getTasteCategoryAll(){
        return tasteCategoryRepository.findAll();
    }
    //맛(소분류) 조회
    public List<TasteDetail> getTasteDetailAll(Long tasteCategoryid){
        return tasteDetailRepository.findByTasteCategory(tasteCategoryid);
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



    //칵테일 정보 추가 및 수정
    public void setCocktail(Long id, String cocktailName, Integer cocktailSize, String introduce,
                            Integer maxAlchol, Integer minAlchol){
        Cocktail cocktail;
        if (id == null){
            cocktail = new Cocktail(cocktailName,cocktailSize,introduce,
                    maxAlchol, minAlchol);
        }else{
            cocktail = cocktailRepository.findById(id).orElseThrow(() -> new CustomApiException("no exist Cocktail"));
        }
        cocktailRepository.save(cocktail);
    }

    //칵테일 맛(대분류) 추가 및 수정
    public void setTasteCategory(Long id, String tasteCategoryValue){
        TasteCategory tasteCategory;
        if(id == null){
            tasteCategory = new TasteCategory(tasteCategoryValue);
        }else{
            tasteCategory = tasteCategoryRepository.findById(id).orElseThrow(()-> new CustomApiException("no exist tasteCategory"));
        }
        tasteCategoryRepository.save(tasteCategory);
    }
    //칵테일 맛(소분류) 추가 및 수정
    public void setTasteDetail(Long id, String tasteDetailValue, Long tasteCategoryId){
        TasteDetail tasteDetail;
        if (id == null){
            TasteCategory findTasteCategory = tasteCategoryRepository.findById(tasteCategoryId).orElseThrow(() -> new CustomApiException("no exits category"));
            tasteDetail = new TasteDetail(tasteDetailValue, findTasteCategory);
        }else{
            tasteDetail = tasteDetailRepository.findById(id).orElseThrow(() -> new CustomApiException("no exist tasteDetail"));
        }

        tasteDetailRepository.save(tasteDetail);
    }

    // 칵테일 추천장소 추가 및 수정
    public void setLocation(Long id, String location){
        Location getLocation;
        if(id == null){
            getLocation = new Location(location);
        }else{
            getLocation = locationRepository.findById(id).orElseThrow(() -> new CustomApiException("no exist location"));
        }
        locationRepository.save(getLocation);
    }

    // 칵테일 추천분위기 추가 및 수정
    public void setMood(Long id, String mood){
        Mood getMood;
        if(id == null){
            getMood = new Mood(mood);
        }else{
            getMood = moodRepository.findById(id).orElseThrow(()->new CustomApiException("no exist mood"));
        }
        moodRepository.save(getMood);
    }
    // 칵테일 추천계절 추가 및 수정
    public void setSeason(Long id, String season){
        Season getSeason;
        if(id == null){
            getSeason = new Season(season);
        }else{
            getSeason = seasonRepository.findById(id).orElseThrow(()->new CustomApiException("no exist season"));
        }

        seasonRepository.save(getSeason);
    }


    // 칵테일 재료 추가 및 수정
    public void setIngredient(Long id, String material){
        Ingredient getIngredient;
        if(id == null){
           getIngredient = new Ingredient(material);
        }else{
            getIngredient = ingredientRepository.findById(id).orElseThrow(()->new CustomApiException("no exist ingredient"));
        }
        ingredientRepository.save(getIngredient);
    }




    // 칵테일 + 재료 맵핑
    public void setCocktailAddIngredient(Long mappingIngredientId, Long cocktailid, List<Long> ingredientIds,
                                         Double quantity, String unit) {

        MappingIngredient mapping;

        Cocktail cocktail = cocktailRepository.findById(cocktailid)
                .orElseThrow(() -> new CustomApiException("no exist cocktail"));

        //CHECKME) ingredient 여러개
        if (mappingIngredientId == null) {
            for (Long ingredientId : ingredientIds) {
                Ingredient ingredient = ingredientRepository.findById(ingredientId)
                        .orElseThrow(() -> new CustomApiException("no exist ingredient"));

                //ingredient
                mapping = MappingIngredient.builder()
                        .ingredient(ingredient)
                        .cocktail(cocktail)
                        .quantity(quantity)
                        .unit(unit)
                        .build();

                mappingIngredientRepository.save(mapping);
            }
        } else {
            for (Long ingredientId : ingredientIds) {
                Ingredient ingredient = ingredientRepository.findById(ingredientId)
                        .orElseThrow(() -> new CustomApiException("no exist ingredient"));

                //ingredient
                mapping = mappingIngredientRepository.findById(mappingIngredientId)
                        .orElseThrow(() -> new CustomApiException("no exist mapping "));

                mapping.setCocktail(cocktail);
                mapping.setIngredient(ingredient);
                mapping.setUnit(unit);
                mapping.setQuantity(quantity);
                mappingIngredientRepository.save(mapping);
            }

        }
    }
    
    // 칵테일 + 맛 맵핑
    //
     /*
     {
           {
                categoryId : 1
                detailid : 1
           },
           {
                categoryId : 1
                detailid : 2
           }
     }
      */
    public void setCocktailAddTaste(Long cocktailId, List<HashMap<String, Long>> maps){
        Cocktail cocktail = cocktailRepository.findById(cocktailId)
                .orElseThrow(() -> new CustomApiException("no exist cocktail"));

        for (HashMap<String, Long> map : maps) {
            Long categoryId = map.get("categoryId");
            Long tasteDetailId = map.get("detailId");
            TasteCategory tasteCategory = tasteCategoryRepository.findById(categoryId)
                    .orElseThrow(() -> new CustomApiException("no exist tasteCategory"));
            TasteDetail tasteDetail = tasteDetailRepository.findById(tasteDetailId)
                    .orElseThrow(()-> new CustomApiException("no exist tasteDetail"));


            mappingTasteRepository.save(MappingTaste.builder()
                            .tasteCategory(tasteCategory)
                            .tasteDetail(tasteDetail)
                            .cocktail(cocktail)
                            .build());
        }
    }
    
    // 칵테일 + 분위기 맵핑
    public void setCocktailAddRecommand(Long cocktailId, List<Long> moodIds, List<Long> locationIds, List<Long> seasonIds){
        Cocktail cocktail = cocktailRepository.findById(cocktailId).orElseThrow(() -> new CustomApiException("no exist cocktail"));

        for (Long  locationId: locationIds) {
            Location location = locationRepository.findById(locationId)
                    .orElseThrow(() -> new CustomApiException("no exist location"));
            for (Long moodId : moodIds) {
                Mood mood = moodRepository.findById(moodId).orElseThrow(() -> new CustomApiException("no exist mood"));
                for (Long seasonId : seasonIds) {
                    Season season = seasonRepository.findById(seasonId).orElseThrow(()-> new CustomApiException("no exist season"));

                    mappingRecommendRepository.save(MappingRecommend.builder()
                                                                .location(location)
                                                                .season(season)
                                                                .mood(mood)
                                                                .cocktail(cocktail)
                                                                .build());
                }
            }
        }
    }

}
