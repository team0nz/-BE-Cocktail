package com.application.domain.cocktail.repository.Mapping;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import com.application.domain.cocktail.entity.cocktail.Mapping.MappingTaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MappingTasteRepository extends JpaRepository<MappingTaste, Long> {
    @Query("SELECT mt FROM mapping_taste mt " +
            "LEFT JOIN mt.tasteDetail td " +
            "LEFT JOIN mt.tasteCategory tc " +
            "WHERE tc.id = :tasteCategoryId AND td.id = :tasteDetailId")
    List<MappingTaste> findPersonalizeCocktailAll(@Param("tasteCaegoryId")Long tasteCategoryId, @Param("tasteDetailId")Long tasteDetailId);

    List<MappingTaste> findByCocktail(Cocktail cocktail);
}
