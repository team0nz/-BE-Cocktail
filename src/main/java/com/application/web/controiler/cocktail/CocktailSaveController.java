package com.application.web.controiler.cocktail;

import com.application.domain.cocktail.dto.cocktailDataPageDto.*;
import com.application.domain.cocktail.entity.cocktail.TasteCategory;
import com.application.domain.cocktail.entity.cocktail.TasteDetail;
import com.application.web.services.cocktail.CocktailSaveService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/cocktail")
@Slf4j
public class CocktailSaveController {
    private final CocktailSaveService cocktailSaveService;

    @GetMapping("/info")
    public String updatePage(Model model){
        HashMap<TasteCategory, List<TasteDetail>> map = new HashMap<>();
        List<TasteCategory> tasteCategories = cocktailSaveService.getTasteCategoryAll();
        for (TasteCategory tasteCategory : tasteCategories) {
            map.put(tasteCategory, cocktailSaveService.getTasteDetailAll(tasteCategory.getId()));
        }

        model.addAttribute("taste", map);

        model.addAttribute("situations", cocktailSaveService.getSituationAll());
        model.addAttribute("moods", cocktailSaveService.getMoodAll());
        model.addAttribute("seasons", cocktailSaveService.getSeasonAll());
        model.addAttribute("ingredients", cocktailSaveService.getIngredientAll());
        model.addAttribute("cocktails", cocktailSaveService.getCocktailAll());

        return "info";
    }

    @PostMapping("/taste/category/update")
    public String updateTasteCategory(@RequestParam(value = "id", required = false) Long id, @RequestParam("tasteCategoryValue") String tasteCategoryValue, Model model){
        cocktailSaveService.setTasteCategory(id, tasteCategoryValue);
        return "redirect:/admin/cocktail/info";
    }

    @PostMapping("/taste/detail/update")
    public String updateTasteDetail(@RequestParam(value = "id", required = false) Long id, @RequestParam("tasteDetailValue") String tasteDetailValue,
                                    @RequestParam("tasteCategoryId") Long tasteCategoryId){
        cocktailSaveService.setTasteDetail(id, tasteDetailValue, tasteCategoryId);
        return "redirect:/admin/cocktail/info";
    }

    @PostMapping("/situation/update")
    public String updateSituation(@RequestParam(value = "id", required = false) Long id,
                                 @RequestParam("situation") String situation) {
        cocktailSaveService.setSituation(id, situation);
        return "redirect:/admin/cocktail/info";
    }

    @PostMapping("/mood/update")
    public String updateMood(@RequestParam(value = "id", required = false) Long id,
                             @RequestParam("mood") String mood) {
        cocktailSaveService.setMood(id, mood);
        return "redirect:/admin/cocktail/info";
    }

    @PostMapping("/season/update")
    public String updateSeason(@RequestParam(value = "id", required = false) Long id,
                               @RequestParam("season") String season) {
        cocktailSaveService.setSeason(id, season);
        return "redirect:/admin/cocktail/info";
    }

    @PostMapping("/ingredient/update")
    public String updateIngredient(@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam("material") String material) {
        cocktailSaveService.setIngredient(id, material);
        return "redirect:/admin/cocktail/info";
    }

    @PostMapping("/update")
    public String updateCocktail(@RequestParam(value= "id", required = false) Long id,
                                 @RequestParam("cocktailName") String cocktailName,
                                 @RequestParam("cocktailSize") Integer cocktailSize,
                                 @RequestParam("introduce") String introduce,
                                 @RequestParam("maxAlchol") Integer maxAlchol,
                                 @RequestParam("minAlchol") Integer minAlchol){
        cocktailSaveService.setCocktail(id, cocktailName, cocktailSize,introduce, maxAlchol, minAlchol);
        return "redirect:/admin/cocktail/info";
    }


    @GetMapping("/mapping/update")
    public String getCocktails(Model model){
        HashMap<TasteCategory, List<TasteDetail>> map = new HashMap<>();
        List<TasteCategory> tasteCategories = cocktailSaveService.getTasteCategoryAll();
        for (TasteCategory tasteCategory : tasteCategories) {
            map.put(tasteCategory, cocktailSaveService.getTasteDetailAll(tasteCategory.getId()));
        }

        model.addAttribute("taste", map);
        model.addAttribute("situationInfos", cocktailSaveService.getSituationAll());
        model.addAttribute("moodInfos", cocktailSaveService.getMoodAll());
        model.addAttribute("seasonInfos", cocktailSaveService.getSeasonAll());
        model.addAttribute("ingredientInfos", cocktailSaveService.getIngredientAll());
        model.addAttribute("mappingCocktails", cocktailSaveService.getCocktailsInfo());

        return "mappingUpdate";
    }

    @PostMapping("/mapping/update")
    public String setMappingCocktail(@ModelAttribute UpdateCocktailDto mappingDto) {
        for (IngredientMappingDto dto : mappingDto.getIngredientMappingDtos()) {
            cocktailSaveService.setCocktailAddIngredient(
                    dto.getMappingIngredientId(), mappingDto.getCocktailId(), List.of(dto.getIngredientSaveDto()));
        }

        for (TasteMappingDto dto : mappingDto.getTasteMappingDtos()) {
            log.info("{}", dto);
            cocktailSaveService.setCocktailAddTaste(
                    dto.getMappingTasteId(), mappingDto.getCocktailId(), dto.getTasteCategoryId(), List.of(dto.getTasteDetailId()));
        }

        for (RecommendMappingDto dto : mappingDto.getRecommendMappingDtos()) {
            cocktailSaveService.setCocktailAddRecommand(
                    dto.getMappingRecommendId(), mappingDto.getCocktailId(), List.of(dto.getMoodId()), List.of(dto.getSituationId()), List.of(dto.getSeasonId()));
        }
        return "redirect:/admin/cocktail/mapping/update";
    }


    @GetMapping("/mapping/create")
    public String getMappingCocktail(Model model){
        HashMap<TasteCategory, List<TasteDetail>> map = new HashMap<>();
        List<TasteCategory> tasteCategories = cocktailSaveService.getTasteCategoryAll();
        for (TasteCategory tasteCategory : tasteCategories) {
            map.put(tasteCategory, cocktailSaveService.getTasteDetailAll(tasteCategory.getId()));
        }

        model.addAttribute("cocktails",cocktailSaveService.getCocktailAll());
        model.addAttribute("taste", map);
        model.addAttribute("situationInfos", cocktailSaveService.getSituationAll());
        model.addAttribute("moodInfos", cocktailSaveService.getMoodAll());
        model.addAttribute("seasonInfos", cocktailSaveService.getSeasonAll());
        model.addAttribute("ingredientInfos", cocktailSaveService.getIngredientAll());
        return "createMapping";
    }

    @PostMapping("/mapping/create")
    public String setMappingCocktail(@ModelAttribute CocktailMappingDto mappingDto) {
        cocktailSaveService.setCocktailAddIngredient(null, mappingDto.getCocktailId(), mappingDto.getIngredientDtos());
        cocktailSaveService.setCocktailAddTaste(null, mappingDto.getCocktailId(), mappingDto.getTasteCategoryId(), mappingDto.getTasteDetailIds());
        cocktailSaveService.setCocktailAddRecommand(null, mappingDto.getCocktailId(), mappingDto.getMoodIds(), mappingDto.getSituationIds(), mappingDto.getSeasonIds());
        return "redirect:/admin/cocktail/mapping/update";
    }
}
