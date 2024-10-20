package org.ex.zomatocloneapi.repository;

import org.ex.zomatocloneapi.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
}
