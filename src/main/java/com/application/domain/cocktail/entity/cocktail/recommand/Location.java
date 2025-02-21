package com.application.domain.cocktail.entity.cocktail.recommand;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String location;

    @Builder
    public Location(String location){
        this.location = location;
    }
}
