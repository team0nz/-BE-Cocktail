package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="taste_category")
@AllArgsConstructor
@Getter
public class TasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String tasteCategory;
    @OneToMany(mappedBy = "tasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TasteDetail> details = new ArrayList<>();

    @Builder
    public TasteCategory(String tasteCategory){
        this.tasteCategory = tasteCategory;
    }
}
