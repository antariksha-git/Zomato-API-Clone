package org.ex.zomatocloneapi.repository;

import org.ex.zomatocloneapi.entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
    Optional<Cuisine> findByTitle(String name);
}
