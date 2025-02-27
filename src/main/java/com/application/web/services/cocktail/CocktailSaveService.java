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
import jakarta.transaction.TransactionScoped;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    // CHECKME) DTO 설정 및 리펙토링
    public List<HashMap<String, Object>> getCocktailsInfo(){
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
            map.put("ingredient", ingredients);

            maps.add(map);
        }

        return maps;
    }
    public List<Cocktail> getCocktailAll(){
        return cocktailRepository.findAll();
    }
    public List<TasteCategory> getTasteCategoryAll(){
        return tasteCategoryRepository.findAll();
    }
    public List<TasteDetail> getTasteDetailAll(Long tasteCategoryid){
        return tasteDetailRepository.findByTasteCategory(tasteCategoryid);
    }
    public List<Location> getLocationAll(){
        return locationRepository.findAll();
    }
    public List<Mood> getMoodAll(){
        return moodRepository.findAll();
    }
    public List<Season> getSeasonAll(){
        return seasonRepository.findAll();
    }
    public List<Ingredient> getIngredientAll(){
        return ingredientRepository.findAll();
    }



    @Transactional
    public void setCocktail(Long id, String cocktailName, Integer cocktailSize, String introduce,
                            Integer maxAlchol, Integer minAlchol){
        Cocktail newCocktail = new Cocktail(id, cocktailName,cocktailSize,introduce,maxAlchol, minAlchol);
        if (newCocktail.isNew()){
            cocktailRepository.save(newCocktail);
        }else{
            Cocktail oldCocktail = cocktailRepository.findById(id).orElseThrow(() -> new CustomApiException("no exist Cocktail"));
            oldCocktail.update(newCocktail);
            cocktailRepository.save(oldCocktail);
        }
    }

    @Transactional
    public void setTasteCategory(Long id, String tasteCategoryValue){
        TasteCategory newTasteCategory = new TasteCategory(id, tasteCategoryValue);
        if(newTasteCategory.isNew()){
            tasteCategoryRepository.save(newTasteCategory);
        }else{
            TasteCategory oldTasteCategory = tasteCategoryRepository.findById(id).orElseThrow(()-> new CustomApiException("no exist tasteCategory"));
            oldTasteCategory.update(newTasteCategory);
            tasteCategoryRepository.save(oldTasteCategory);
        }
    }


    @Transactional
    public void setTasteDetail(Long id, String tasteDetailValue, Long tasteCategoryId){
        TasteCategory findTasteCategory = tasteCategoryRepository.findById(tasteCategoryId).orElseThrow(() -> new CustomApiException("no exits category"));
        TasteDetail newTasteDetail = new TasteDetail(id, tasteDetailValue, findTasteCategory);
        if (newTasteDetail.isNew()){
            tasteDetailRepository.save(newTasteDetail);
        }else{
            TasteDetail oldTasteDetail = tasteDetailRepository.findById(id).orElseThrow(() -> new CustomApiException("no exist tasteDetail"));
            oldTasteDetail.update(newTasteDetail);
            tasteDetailRepository.save(oldTasteDetail);
        }
    }

    @Transactional
    public void setLocation(Long id, String location){
        Location newLocation = new Location(id, location);
        if(newLocation.isNew()){
            locationRepository.save(newLocation);
        }else{
            Location oldLocation = locationRepository.findById(id).orElseThrow(() -> new CustomApiException("no exist location"));
            oldLocation.update(newLocation);
            locationRepository.save(oldLocation);
        }
    }

    @Transactional
    public void setMood(Long id, String mood){
        Mood newMood = new Mood(id, mood);
        if(newMood.isNew()){
            moodRepository.save(newMood);
        }else{
            Mood oldMood = moodRepository.findById(id).orElseThrow(()->new CustomApiException("no exist mood"));
            oldMood.update(newMood);
            moodRepository.save(oldMood);
        }
    }

    @Transactional
    public void setSeason(Long id, String season){
        Season newSeason = new Season(id, season);
        if(newSeason.isNew()){
            seasonRepository.save(newSeason);
        }else{
            Season oldSeason = seasonRepository.findById(id).orElseThrow(()->new CustomApiException("no exist season"));
            oldSeason.update(newSeason);
            seasonRepository.save(oldSeason);
        }
    }


    @Transactional
    public void setIngredient(Long id, String material){
        Ingredient newIngredient = new Ingredient(id, material);
        if(newIngredient.isNew()){
            ingredientRepository.save(newIngredient);
        }else{
            Ingredient oldIngredient = ingredientRepository.findById(id).orElseThrow(()->new CustomApiException("no exist ingredient"));
            oldIngredient.update(newIngredient);
            ingredientRepository.save(oldIngredient);
        }
    }


    @Transactional
    public void setCocktailAddIngredient(Long mappingIngredientId, Long cocktailid, List<Long> ingredientIds,
                                         Double quantity, String unit) {

        Cocktail cocktail = cocktailRepository.findById(cocktailid)
                .orElseThrow(() -> new CustomApiException("no exist cocktail"));
        List<Ingredient> ingredients = ingredientRepository.findAll();

        for (Ingredient ingredient : ingredients) {
            if(mappingIngredientId == null){
                MappingIngredient mappingIngredient = saveMappingIngredient(cocktail, ingredient,quantity, unit );
                mappingIngredientRepository.save(mappingIngredient);
            }else{
                MappingIngredient mappingIngredient = updateMappingIngredient(mappingIngredientId, cocktail, ingredient, quantity, unit);
                mappingIngredientRepository.save(mappingIngredient);
            }
        }
    }

    private MappingIngredient saveMappingIngredient(Cocktail cocktail, Ingredient ingredient,
                                       Double quantity, String unit){
        return MappingIngredient.builder()
                .ingredient(ingredient)
                .cocktail(cocktail)
                .quantity(quantity)
                .unit(unit)
                .build();

    }

    private MappingIngredient updateMappingIngredient(Long id, Cocktail cocktail, Ingredient ingredient,
                                         Double quantity, String unit){
        MappingIngredient mapping = mappingIngredientRepository.findById(id)
                .orElseThrow(() -> new CustomApiException("no exist mapping "));

        mapping.update(cocktail, ingredient, quantity, unit);
        return mapping;
    }

    
    // 칵테일 + 맛 맵핑
    //CHECKME) 리펙토링
    @Transactional
    public void setCocktailAddTaste(Long cocktailId, Long tasteCategoryId, List<Long> tasteDetailIds){
        Cocktail cocktail = cocktailRepository.findById(cocktailId)
                .orElseThrow(() -> new CustomApiException("no exist cocktail"));

        TasteCategory tasteCategory = tasteCategoryRepository.findById(tasteCategoryId)
                .orElseThrow(() -> new CustomApiException("no exist tasteCategory"));

        for (Long tasteDetailId : tasteDetailIds) {
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
    //CHECKME) 리펙토링
    @Transactional
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
