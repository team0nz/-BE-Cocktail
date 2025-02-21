package com.application.domain.cocktail.entity.cocktail.Mapping;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.recommand.Location;
import com.application.domain.cocktail.entity.cocktail.recommand.Mood;
import com.application.domain.cocktail.entity.cocktail.recommand.Season;
import jakarta.persistence.*;

@Entity(name="mapping_recommend")
public class MappingRecommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="cocktail_id", nullable = false)
    private Cocktail cocktail;

    @ManyToOne
    @JoinColumn
    private Location location;

    @ManyToOne
    @JoinColumn
    private Mood mood;

    @ManyToOne
    @JoinColumn
    private Season season;
}
