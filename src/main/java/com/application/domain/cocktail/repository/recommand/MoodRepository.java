package com.application.domain.cocktail.repository.recommand;

import com.application.domain.cocktail.entity.cocktail.recommand.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
}
