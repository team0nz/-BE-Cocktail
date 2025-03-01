package com.application.domain.cocktail.entity.cocktail.Mapping;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.Ingredient;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "mapping_ingredient")
@Getter
public class MappingIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="ingredient_id", nullable = false)
    private Ingredient ingredient;

    @ManyToOne
    @JoinColumn(name="cocktail_id", nullable = false)
    private Cocktail cocktail;

    @Column
    private Double quantity;

    @Column
    private String unit;

    protected MappingIngredient() {}

    @Builder
    public MappingIngredient(Ingredient ingredient, Cocktail cocktail,
                             Double quantity, String unit){
        this.cocktail = cocktail;
        this.ingredient =ingredient;
        this.quantity = quantity;
        this.unit = unit;
    }

    public void update(Cocktail cocktail,Ingredient ingredient, Double quantity, String unit){
        this.cocktail = cocktail;
        this.ingredient = ingredient;
        this.quantity = quantity;
        this.unit = unit;
    }
}
