package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
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

    @Builder
    public Cocktail(String cocktailName, Integer cocktailSize,
                    String introduce, Integer maxAlchol,
                    Integer minAlchol){
        this.cocktailName = cocktailName;
        this.cocktailSize = cocktailSize;
        this.introduce = introduce;
        this.maxAlchol = maxAlchol;
        this.minAlchol = minAlchol;
    }
}
