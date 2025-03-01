package com.application.domain.cocktail.entity.cocktail.Mapping;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.recommand.Situation;
import com.application.domain.cocktail.entity.cocktail.recommand.Mood;
import com.application.domain.cocktail.entity.cocktail.recommand.Season;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity(name="mapping_recommend")
@Getter
public class MappingRecommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="cocktail_id", nullable = false)
    private Cocktail cocktail;

    @ManyToOne
    @JoinColumn
    private Situation situation;

    @ManyToOne
    @JoinColumn
    private Mood mood;

    @ManyToOne
    @JoinColumn
    private Season season;

    protected  MappingRecommend(){}

    @Builder
    public MappingRecommend(Cocktail cocktail, Situation situation, Mood mood, Season season){
        this.cocktail = cocktail;
        this.situation = situation;
        this.mood = mood;
        this.season = season;
    }

    public void update(Cocktail cocktail, Situation situation, Mood mood, Season season){
        this.cocktail = cocktail;
        this.situation = situation;
        this.mood = mood;
        this.season = season;
    }
}
