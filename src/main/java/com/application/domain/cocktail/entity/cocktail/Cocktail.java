package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;


@Entity(name = "cocktail")
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer size;
    @Column
    private String recipe;
    @Column(nullable = false)
    private Integer alchol;
}
