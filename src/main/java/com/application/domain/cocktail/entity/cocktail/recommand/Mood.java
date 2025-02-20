package com.application.domain.cocktail.entity.cocktail.recommand;

import jakarta.persistence.*;

@Entity
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String mood;
}
