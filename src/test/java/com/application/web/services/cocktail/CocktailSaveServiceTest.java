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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CocktailSaveServiceTest {
    @Mock
    private MappingIngredientRepository mappingIngredientRepository;
    @Mock
    private CocktailRepository cocktailRepository;
    @InjectMocks
    private CocktailSaveService cocktailSaveService;

    @Mock
    private LocationRepository locationRepository;
    @Mock
    private MoodRepository moodRepository;
    @Mock
    private SeasonRepository seasonRepository;
    @Mock
    private MappingRecommendRepository mappingRecommendRepository;

    @Mock
    private MappingTasteRepository mappingTasteRepository;
    @Mock
    private IngredientRepository ingredientRepository;
    @Mock
    private TasteDetailRepository tasteDetailRepository;
    @Mock
    private TasteCategoryRepository tasteCategoryRepository;

    //################ 조회 #######################

    //칵테일 정보 조회
    @Test
    public void testGetCocktailInfo(){

        //given
        Cocktail cocktail = new Cocktail("test", 250, "test cocktail",30, 20);
        List<Cocktail> cocktails = List.of(cocktail);
        when(cocktailRepository.findAll()).thenReturn(cocktails);

        List<MappingIngredient> ingredientList = new ArrayList<>();
        List<MappingTaste> tasteList = new ArrayList<>();
        List<MappingRecommend> recommendList = new ArrayList<>();
        when(mappingIngredientRepository.findByCocktail(cocktail)).thenReturn(ingredientList);
        when(mappingTasteRepository.findByCocktail(cocktail)).thenReturn(tasteList);
        when(mappingRecommendRepository.findByCocktail(cocktail)).thenReturn(recommendList);

        //when
        List<HashMap<String, Object>> result = cocktailSaveService.getCocktailInfo();

        //then
        assertNotNull(result, "Result should not be null");
        assertEquals(1, result.size(), "Should be exactly one map in the result");
        HashMap<String, Object> map = result.get(0);
        assertEquals(cocktail, map.get("cocktail"), "Cocktail object should match");
        assertEquals(tasteList, map.get("taste"), "Taste list should match");
        assertEquals(recommendList, map.get("recommand"), "Recommend list should match");

        // 각 리포지토리 메서드 호출이 1회씩 이뤄졌는지 검증
        verify(cocktailRepository, times(1)).findAll();
        verify(mappingIngredientRepository, times(1)).findByCocktail(cocktail);
        verify(mappingTasteRepository, times(1)).findByCocktail(cocktail);
        verify(mappingRecommendRepository, times(1)).findByCocktail(cocktail);

    }

    @Test
    //맛(대분류) 조회
    public void testGetTasteCategoryAll(){
        //given
        TasteDetail tasteDetail = new TasteDetail("taste detail", null);
        List<TasteDetail> tasteDetails = List.of(tasteDetail);
        TasteCategory tasteCategory = new TasteCategory(1L,"tasteCategory",tasteDetails);
        when(tasteCategoryRepository.findAll()).thenReturn(List.of(tasteCategory));

        //when
        List<TasteCategory> results = cocktailSaveService.getTasteCategoryAll();

        //then
        Assertions.assertEquals(results.get(0), tasteCategory);
    }

    @Test
    //맛(소분류) 조회
    public void testGetTasteDetailAll(Long tasteCategoryid){
        //given

        //when

        //then
//        return tasteDetailRepository.findByTasteCategory(tasteCategoryid);
    }

    @Test
    // 칵테일 추천장소 조회
    public void testGetLocationAll(){
        //given

        //when

        //then
//        return locationRepository.findAll();
    }

    @Test
    // 칵테일 추천분위기 조회
    public void testGetMoodAll(){
        //given

        //when

        //then
//        return moodRepository.findAll();
    }

    @Test
    // 칵테일 추천계절 조회
    public void testGetSeasonAll(){
        //given

        //when

        //then
//        return seasonRepository.findAll();
    }

    @Test
    // 칵테일 재료 조회
    public void testGetIngredientAll(){
        //given

        //when

        //then
//        return ingredientRepository.findAll();
    }


    //################### 생성 및 업데이트 #########################

    @Test
    public void testSetCocktail_CreateNew() {
        // id가 null인 경우, 새 칵테일 생성 경로 테스트
        Long cocktailId = null;
        String cocktailName = "Mojito";
        Integer cocktailSize = 300;
        String introduce = "Refreshing mint cocktail";
        Integer maxAlchol = 40;
        Integer minAlchol = 20;

        //DB 체크는 못함
        // cocktailRepository.save() 호출 시 입력받은 객체를 그대로 반환하도록 설정
        when(cocktailRepository.save(any(Cocktail.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // When
        cocktailSaveService.setCocktail(cocktailId, cocktailName, cocktailSize, introduce, maxAlchol, minAlchol);

        // Then: 새로운 칵테일 객체가 저장되었음을 검증
        verify(cocktailRepository, times(1)).save(any(Cocktail.class));
    }


    @Test
    public void testSetCocktailAddRecommand() {
        // 칵테일 + 추천(분위기, 장소, 계절) 매핑 테스트
        Long cocktailId = 1L;
        List<Long> moodIds = List.of(10L);
        List<Long> locationIds = List.of(20L);
        List<Long> seasonIds = List.of(30L);

        Cocktail cocktail = new Cocktail("Test Cocktail", 250, "Test Description", 40, 20);
        when(cocktailRepository.findById(cocktailId)).thenReturn(Optional.of(cocktail));

        Location location = new Location("Bar");
        Mood mood = new Mood("Cozy");
        Season season = new Season("Summer");
        when(locationRepository.findById(20L)).thenReturn(Optional.of(location));
        when(moodRepository.findById(10L)).thenReturn(Optional.of(mood));
        when(seasonRepository.findById(30L)).thenReturn(Optional.of(season));

        // When
        cocktailSaveService.setCocktailAddRecommand(cocktailId, moodIds, locationIds, seasonIds);

        // Then: 1 x 1 x 1 = 1 조합이므로 매핑 저장 메서드가 한 번 호출되어야 함.
        verify(mappingRecommendRepository, times(1)).save(any(MappingRecommend.class));
    }



}