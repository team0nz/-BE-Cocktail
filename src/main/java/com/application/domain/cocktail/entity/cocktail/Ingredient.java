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
    @Column(unique = true)
    private String material;

    public Ingredient(){}

    @Builder
    public Ingredient(Long id, String material){
        this.id = id;
        this.material = material;
    }

    public boolean isNew(){
        return (this.id == null);
    }

    public void update(Ingredient ingredient){
        this.material = ingredient.getMaterial();
    }
}
