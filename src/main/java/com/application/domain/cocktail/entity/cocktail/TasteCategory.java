package com.application.domain.cocktail.entity.cocktail;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name="taste_category")
public class TasteCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String taste;
    @OneToMany(mappedBy = "tasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TasteDetail> details = new ArrayList<>();
}
