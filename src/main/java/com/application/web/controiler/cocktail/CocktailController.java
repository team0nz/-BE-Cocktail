package com.application.web.controiler.cocktail;

import com.application.common.response.ResponseDto;
import com.application.domain.cocktail.dto.ReqPersonalizeCocktail;
import com.application.web.services.cocktail.CocktailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class CocktailController {

    private final CocktailService cocktailService;

    @GetMapping("/cocktails")
    public ResponseEntity<?> getCocktails(){
        return new ResponseEntity<>(new ResponseDto<>(1, "cocktails info", cocktailService.getCocktailFindAll()), HttpStatus.OK);
    }

    @GetMapping("/cocktail/taste/category")
    public ResponseEntity<?> getTasteCategory(){
        return new ResponseEntity<>(new ResponseDto<>(1, "cocktail taste category", cocktailService.getTasteCategory()),HttpStatus.OK);
    }

    @GetMapping("/cocktail/taste/detail")
    public ResponseEntity<?> getTasteDetail(@RequestBody Long tasteCategoryId){
        return new ResponseEntity<>(new ResponseDto<>(1, "cocktail taste detail", cocktailService.getTasteDetail(tasteCategoryId)),HttpStatus.OK);
    }

    @GetMapping("/cocktail/personalize")
    public ResponseEntity<?> getPersonalize(@RequestBody ReqPersonalizeCocktail reqPersonalizeCocktail){
        return new ResponseEntity<>(new ResponseDto<>(1, "personalize cocktail", cocktailService.getPersonalizeCocktail(reqPersonalizeCocktail)),HttpStatus.OK);
    }

}
