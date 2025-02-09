package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;

@Entity(name = "recommend")
public class Recommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String situation;

}
