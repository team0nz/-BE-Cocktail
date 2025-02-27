package com.application.domain.cocktail.entity.cocktail.recommand;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String location;

    public Location(){}

    @Builder
    public Location(Long id, String location){
        this.id = id;
        this.location = location;
    }

    public boolean isNew(){
        return (this.id == null);
    }

    public void update(Location location){
        this.location = location.getLocation();
    }
}
