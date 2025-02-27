package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Entity(name = "cocktail")
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cocktailName;
    @Column
    private Integer cocktailSize;
    @Column
    private String introduce;
    @Column(nullable = false)
    private Integer maxAlchol;
    @Column(nullable = false)
    private Integer minAlchol;

    public Cocktail(){}

    @Builder
    public Cocktail(Long id, String cocktailName, Integer cocktailSize,
                    String introduce, Integer maxAlchol,
                    Integer minAlchol){
        this.id = id;
        this.cocktailName = cocktailName;
        this.cocktailSize = cocktailSize;
        this.introduce = introduce;
        this.maxAlchol = maxAlchol;
        this.minAlchol = minAlchol;
    }

    public boolean isNew(){
        return (this.id == null);
    }

    public void update(Cocktail cocktail){
        this.cocktailName = cocktail.getCocktailName();
        this.cocktailSize = cocktail.getCocktailSize();
        this.introduce = cocktail.getIntroduce();
        this.maxAlchol = cocktail.getMaxAlchol();
        this.minAlchol = cocktail.getMinAlchol();
    }
}
