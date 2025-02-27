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
    public Season(Long id, String season){
        this.id = id;
        this.season = season;
    }

    public boolean isNew(){
        return (this.id == null);
    }

    public void update(Season season){
        this.season = season.getSeason();
    }
}
