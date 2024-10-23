package org.ex.zomatocloneapi.repository;

import org.ex.zomatocloneapi.entity.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
    Optional<FoodType> findByTitleIgnoreCase(String title);
}
