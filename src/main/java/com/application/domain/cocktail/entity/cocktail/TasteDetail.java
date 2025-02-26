package com.application.domain.cocktail.entity.cocktail;

import com.application.domain.cocktail.repository.TasteDetailRepository;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
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

    public TasteDetail(){}

    @Builder
    public TasteDetail(String tasteDetail, TasteCategory tasteCategory){
        this.tasteDetail = tasteDetail;
        this.tasteCategory = tasteCategory;
    }
}
