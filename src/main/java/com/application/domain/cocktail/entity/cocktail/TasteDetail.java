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
    @Column(name="taste_detail", unique = true)
    private String tasteDetail;

    public TasteDetail(){}

    @Builder
    public TasteDetail(Long id, String tasteDetail, TasteCategory tasteCategory){
        this.id = id;
        this.tasteDetail = tasteDetail;
        this.tasteCategory = tasteCategory;
    }

    public boolean isNew(){
        return (this.id == null);
    }

    public void update(TasteDetail tasteDetail){
        this.tasteDetail = tasteDetail.getTasteDetail();
        this.tasteCategory = tasteDetail.getTasteCategory();
    }
}
