package com.application.domain.cocktail.entity.cocktail.recommand;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Situation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String situation;

    public Situation(){}

    @Builder
    public Situation(Long id, String situation){
        this.id = id;
        this.situation = situation;
    }

    public boolean isNew(){
        return (this.id == null);
    }

    public void update(Situation situation){
        this.situation = situation.getSituation();
    }
}
