package com.application.web.controiler.cocktail;

import com.application.domain.cocktail.entity.cocktail.TasteCategory;
import com.application.domain.cocktail.entity.cocktail.TasteDetail;
import com.application.web.services.cocktail.CocktailSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/cocktail")
public class CocktailSaveController {
    private final CocktailSaveService cocktailSaveService;

    @GetMapping("/all")
    public String getCocktailAll(Model model){
        List<HashMap<String,Object>> maps = cocktailSaveService.getCocktailInfo();
        model.addAttribute("result",maps);

        return "cocktails";
    }

    @GetMapping("/info")
    public String updatePage(Model model){
        HashMap<TasteCategory, List<TasteDetail>> map = new HashMap<>();
        List<TasteCategory> tasteCategories = cocktailSaveService.getTasteCategoryAll();
        for (TasteCategory tasteCategory : tasteCategories) {
            map.put(tasteCategory, cocktailSaveService.getTasteDetailAll(tasteCategory.getId()));
        }

        model.addAttribute("taste", map);

        model.addAttribute("locations", cocktailSaveService.getLocationAll());
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

    @PostMapping("/location/update")
    public String updateLocation(@RequestParam(value = "id", required = false) Long id,
                                 @RequestParam("location") String location) {
        cocktailSaveService.setLocation(id, location);
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

    //맵핑하는 Controller 생성

}
