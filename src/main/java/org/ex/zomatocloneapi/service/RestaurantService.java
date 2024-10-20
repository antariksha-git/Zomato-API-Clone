package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.entity.Restaurant;
import org.ex.zomatocloneapi.exception.RestaurantNotFoundById;
import org.ex.zomatocloneapi.mapper.RestaurantMapper;
import org.ex.zomatocloneapi.repository.RestaurantRepository;
import org.ex.zomatocloneapi.requestdto.RestaurantRequest;
import org.ex.zomatocloneapi.responsedtao.RestaurantResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        return RestaurantMapper
                .mapToRestaurantResponse(restaurantRepository
                        .save(RestaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant())));
    }

    public RestaurantResponse findRestaurantById(String restaurantId) {
        return RestaurantMapper
                .mapToRestaurantResponse(restaurantRepository
                        .findById(restaurantId)
                        .orElseThrow(() -> new RestaurantNotFoundById("Restaurant not found")));
    }
}
