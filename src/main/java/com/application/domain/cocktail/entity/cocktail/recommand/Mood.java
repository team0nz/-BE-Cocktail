package com.application.domain.cocktail.entity.cocktail.recommand;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String mood;

    @Builder
    public Mood(String mood){
        this.mood = mood;
    }
}
