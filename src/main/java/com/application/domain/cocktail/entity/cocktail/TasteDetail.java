package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;
import lombok.Builder;

@Entity(name="taste_detail")
public class TasteDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private TasteCategory tasteCategory;
    @Column(name="taste_detail")
    private String tasteDetail;

    @Builder
    public TasteDetail(String tasteDetail){
        this.tasteDetail = tasteDetail;
    }
}
