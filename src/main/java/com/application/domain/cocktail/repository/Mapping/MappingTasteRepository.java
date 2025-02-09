package com.application.domain.cocktail.repository.Mapping;

import com.application.domain.cocktail.entity.cocktail.Mapping.MappingTaste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingTasteRepository extends JpaRepository<MappingTaste, Long> {
}
