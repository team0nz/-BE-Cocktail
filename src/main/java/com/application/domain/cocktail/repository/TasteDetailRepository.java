package com.application.domain.cocktail.repository;

import com.application.domain.cocktail.entity.cocktail.TasteDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasteDetailRepository extends JpaRepository<TasteDetail, Long> {
    @Query("SELECT td FROM taste_detail td WHERE td.tasteCategory.id = :id")
    List<TasteDetail> findByTasteCategory(@Param("id") Long tasteCategoryId);
}
