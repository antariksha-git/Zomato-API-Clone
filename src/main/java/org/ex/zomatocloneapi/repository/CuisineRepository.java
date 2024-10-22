package org.ex.zomatocloneapi.repository;

import org.ex.zomatocloneapi.entity.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
    Cuisine findByTitle(String name);
}
