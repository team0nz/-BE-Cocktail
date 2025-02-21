package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;
import lombok.Builder;

@Entity(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String material;

    @Builder
    public Ingredient(String material){
        this.material = material;
    }
}
