package com.application.domain.cocktail.repository;

import com.application.domain.cocktail.entity.cocktail.TasteDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasteDetailRepository extends JpaRepository<TasteDetail, Long> {

}
