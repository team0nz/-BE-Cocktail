package com.application.domain.cocktail.repository;

import com.application.domain.cocktail.entity.cocktail.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Long> {

    @Query("SELECT c FROM cocktail c" +
    " JOIN mapping_taste mt ON c.id = mt.cocktail.id "+
            "JOIN taste_detail td ON mt.tasteDetail.id = td.id " +
            " WHERE mt.tasteDetail.id = :tasteId")
    List<Cocktail> findCocktailByTasteId(@Param("tasteId") Long tasteId);
}
