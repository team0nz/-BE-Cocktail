package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;

@Entity(name="taste_detail")
public class TasteDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="taste_id")
    private TasteCategory tasteCategory;
    @Column(name="taste_detail")
    private String tasteDetail;
}
