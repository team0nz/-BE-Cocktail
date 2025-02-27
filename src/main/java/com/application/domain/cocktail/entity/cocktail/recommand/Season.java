package com.application.domain.cocktail.entity.cocktail.recommand;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String season;

    public Season(){}

    @Builder
    public Season(String season){
        this.season = season;
    }
}
