package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;

@Entity(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String material;
    @Column
    private String size;

}
