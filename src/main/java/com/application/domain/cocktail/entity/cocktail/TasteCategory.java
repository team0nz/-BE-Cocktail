package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name="taste_category")
@AllArgsConstructor
@Getter
public class TasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String tasteCategory;
    @OneToMany(mappedBy = "tasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TasteDetail> details = new ArrayList<>();

    public TasteCategory(){}

    @Builder
    public TasteCategory(Long id, String tasteCategory){
        this.id = id;
        this.tasteCategory = tasteCategory;
    }

    public boolean isNew(){
        return (this.id == null);
    }

    public void update(TasteCategory tasteCategory){
        this.tasteCategory = tasteCategory.getTasteCategory();
        this.details = tasteCategory.getDetails();
    }
}
