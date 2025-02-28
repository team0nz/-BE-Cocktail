package com.application.domain.cocktail.entity.cocktail.Mapping;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.TasteCategory;
import com.application.domain.cocktail.entity.cocktail.TasteDetail;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity(name="mapping_taste")
public class MappingTaste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="taste_category_id", nullable = false)
    private TasteCategory tasteCategory;

    @ManyToOne
    @JoinColumn(name="taste_detail_id", nullable = false)
    private TasteDetail tasteDetail;

    @ManyToOne
    @JoinColumn(name="cocktail_id", nullable = false)
    private Cocktail cocktail;

    @Builder
    public MappingTaste(TasteCategory tasteCategory, TasteDetail tasteDetail, Cocktail cocktail){
        this.tasteCategory = tasteCategory;
        this.tasteDetail = tasteDetail;
        this.cocktail = cocktail;
    }

    public void update(Cocktail cocktail, TasteCategory tasteCategory,  TasteDetail tasteDetail){
        this.cocktail = cocktail;
        this.tasteCategory = tasteCategory;
        this.tasteDetail = tasteDetail;
    }
}
