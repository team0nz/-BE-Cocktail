package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;


@Entity(name = "cocktail")
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cocktailName;
    @Column
    private Integer cocktailSize;
    @Column
    private String introduce;
    @Column(nullable = false)
    private Integer maxAlchol;
    @Column(nullable = false)
    private Integer minAlchol;
}
