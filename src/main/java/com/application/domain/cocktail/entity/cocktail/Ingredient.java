package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String material;

    public Ingredient(){}
    @Builder
    public Ingredient(String material){
        this.material = material;
    }
}
