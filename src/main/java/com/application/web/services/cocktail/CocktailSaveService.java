package com.application.web.services.cocktail;

import com.application.common.exception.custom.CustomApiException;
import com.application.domain.cocktail.dto.CocktailInfoDto;
import com.application.domain.cocktail.dto.IngredientSaveDto;
import com.application.domain.cocktail.dto.MappingRecommendDto;
import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.Ingredient;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingIngredient;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingRecommend;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingTaste;
import com.application.domain.cocktail.entity.cocktail.TasteCategory;
import com.application.domain.cocktail.entity.cocktail.TasteDetail;
import com.application.domain.cocktail.entity.cocktail.recommand.Situation;
import com.application.domain.cocktail.entity.cocktail.recommand.Mood;
import com.application.domain.cocktail.entity.cocktail.recommand.Season;
import com.application.domain.cocktail.repository.CocktailRepository;
import com.application.domain.cocktail.repository.IngredientRepository;
import com.application.domain.cocktail.repository.Mapping.MappingIngredientRepository;
import com.application.domain.cocktail.repository.Mapping.MappingRecommendRepository;
import com.application.domain.cocktail.repository.Mapping.MappingTasteRepository;
import com.application.domain.cocktail.repository.TasteCategoryRepository;
import com.application.domain.cocktail.repository.TasteDetailRepository;
import com.application.domain.cocktail.repository.recommand.SituationRepository;
import com.application.domain.cocktail.repository.recommand.MoodRepository;
import com.application.domain.cocktail.repository.recommand.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CocktailSaveService {
    private final MappingIngredientRepository mappingIngredientRepository;
    private final MappingRecommendRepository mappingRecommendRepository;
    private final MappingTasteRepository mappingTasteRepository;
    private final CocktailRepository cocktailRepository;

    private final TasteCategoryRepository tasteCategoryRepository;
    private final TasteDetailRepository tasteDetailRepository;

    private final SituationRepository situationRepository;
    private final MoodRepository moodRepository;
    private final SeasonRepository seasonRepository;

    private final IngredientRepository ingredientRepository;


    public List<CocktailInfoDto> getCocktailsInfo(){
        return cocktailRepository.findAll().stream()
                .map(cocktail -> {
                    List<MappingIngredient> ingredients = mappingIngredientRepository.findByCocktail(cocktail);
                    List<MappingTaste> tastes = mappingTasteRepository.findByCocktail(cocktail);
                    List<MappingRecommend> recommends = mappingRecommendRepository.findByCocktail(cocktail);
                    return CocktailInfoDto.builder()
                            .cocktail(cocktail)
                            .mappingIngredient(ingredients)
                            .mappingTaste(tastes)
                            .mappingRecommend(recommends)
                            .build();
                })
                .collect(Collectors.toList());
    }

    public List<Cocktail> getNoMappingCocktail(){
        //맵핑 되어있는 칵테일 id 찾고 리스트 정렬
        mappingIngredientRepository.findAll();
        mappingRecommendRepository.findAll();
        mappingTasteRepository.findAll();

        // 리스트 제외한 칵테일 id 리스트 정렬 리턴;
        return null;
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
    public List<Situation> getSituationAll(){
        return situationRepository.findAll();
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
    public void setSituation(Long id, String situation){
        Situation newSituation = new Situation(id, situation);
        if(newSituation.isNew()){
            situationRepository.save(newSituation);
        }else{
            Situation oldSituation = situationRepository.findById(id).orElseThrow(() -> new CustomApiException("no exist situation"));
            oldSituation.update(newSituation);
            situationRepository.save(oldSituation);
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
    public void setCocktailAddIngredient(Long mappingIngredientId, Long cocktailid, List<IngredientSaveDto> dtos) {
        Cocktail cocktail = cocktailRepository.findById(cocktailid)
                .orElseThrow(() -> new CustomApiException("no exist cocktail"));

        for (IngredientSaveDto dto : dtos) {
            Ingredient ingredient = ingredientRepository.findById(dto.getIngredientId()).orElseThrow( ()-> new CustomApiException("no exist ingredient"));
            if(mappingIngredientId == null){
                MappingIngredient mappingIngredient = saveMappingIngredient(cocktail, ingredient, dto.getQuantity(), dto.getUnit());
                mappingIngredientRepository.save(mappingIngredient);
            }else{
                MappingIngredient mappingIngredient = updateMappingIngredient(mappingIngredientId, cocktail, ingredient, dto.getQuantity(), dto.getUnit());
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

    @Transactional
    public void setCocktailAddTaste(Long mappingtasteId,Long cocktailId, Long tasteCategoryId,
                                    List<Long> tasteDetailIds){
        Cocktail cocktail = cocktailRepository.findById(cocktailId)
                .orElseThrow(() -> new CustomApiException("no exist cocktail"));
        TasteCategory tasteCategory = tasteCategoryRepository.findById(tasteCategoryId)
                .orElseThrow(() -> new CustomApiException("no exist tasteCategory"));

        if(mappingtasteId == null){
            saveMappingTaste(cocktail, tasteCategory, tasteDetailIds);
        }else{
            updateMappingTaste(mappingtasteId, cocktail, tasteCategory, tasteDetailIds);
        }
    }

    private void saveMappingTaste(Cocktail cocktail, TasteCategory tasteCategory, List<Long> tasteDetailIds){
        for (Long tasteDetailId : tasteDetailIds) {
            TasteDetail tasteDetail = tasteDetailRepository.findById(tasteDetailId).orElseThrow(() -> new CustomApiException("no exist tasteDetail"));
            mappingTasteRepository.save(MappingTaste.builder()
                    .tasteCategory(tasteCategory)
                    .tasteDetail(tasteDetail)
                    .cocktail(cocktail)
                    .build());
        }
    }

    private void updateMappingTaste(Long mappingTasteId, Cocktail cocktail, TasteCategory tasteCategory, List<Long> tasteDetailIds){

        MappingTaste mappingTaste = mappingTasteRepository.findById(mappingTasteId).orElseThrow(() -> new CustomApiException("no exist mapping taste"));

        for (Long tasteDetailId : tasteDetailIds) {
            TasteDetail tasteDetail = tasteDetailRepository.findById(tasteDetailId).orElseThrow(() -> new CustomApiException("no exist tasteDetail"));

            mappingTaste.update(cocktail, tasteCategory, tasteDetail);
        }
    }


    @Transactional
    public void setCocktailAddRecommand(Long mappingRecommendId, Long cocktailId, List<Long> moodIds, List<Long> situationIds, List<Long> seasonIds){
        Cocktail cocktail = cocktailRepository.findById(cocktailId).orElseThrow(() -> new CustomApiException("no exist cocktail"));

        situationIds.stream()
                .map(situationId -> situationRepository.findById(situationId)
                        .orElseThrow(() -> new CustomApiException("no exist situation")))
                .flatMap(situation -> moodIds.stream()
                        .map(moodId -> moodRepository.findById(moodId)
                                .orElseThrow(() -> new CustomApiException("no exist mood")))
                        .flatMap(mood -> seasonIds.stream()
                                .map(seasonId -> seasonRepository.findById(seasonId)
                                        .orElseThrow(() -> new CustomApiException("no exist season")))
                                .map(season -> MappingRecommendDto.builder()
                                        .mappingRecommendId(mappingRecommendId)
                                        .cocktail(cocktail)
                                        .situation(situation)
                                        .mood(mood)
                                        .season(season)
                                        .build())
                        )
                )
                .forEach(dto -> {
                    if (dto.getMappingRecommendId() == null) {
                        saveMappingRecommend(dto.getCocktail(), dto.getSituation(), dto.getMood(), dto.getSeason());
                    } else {
                        updateMappingRecommend(dto.getMappingRecommendId(), dto.getCocktail(), dto.getSituation(), dto.getMood(), dto.getSeason());
                    }
                });
    }

    private void saveMappingRecommend(Cocktail cocktail, Situation situation, Mood mood, Season season){
        mappingRecommendRepository.save(MappingRecommend.builder()
                .situation(situation)
                .season(season)
                .mood(mood)
                .cocktail(cocktail)
                .build());
    }

    private void updateMappingRecommend(Long mappingRecommendId, Cocktail cocktail, Situation situation, Mood mood, Season season){
        MappingRecommend mappingRecommend = mappingRecommendRepository.findById(mappingRecommendId).orElseThrow(() -> new CustomApiException("no exist reocmmend mapping"));

        mappingRecommend.update(cocktail, situation, mood, season);
    }

}
