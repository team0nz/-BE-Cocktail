package com.application.domain.cocktail.entity.cocktail.recommand;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Mood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String mood;

    public Mood(){}

    @Builder
    public Mood(String mood){
        this.mood = mood;
    }
}
