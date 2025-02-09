package com.application.domain.cocktail.entity.cocktail.Mapping;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.Recommend;
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
    @JoinColumn(name="recommend_id", nullable = false)
    private Recommend recommend;
}
