package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.entity.Cuisine;
import org.ex.zomatocloneapi.exception.RestaurantNotFoundByIdException;
import org.ex.zomatocloneapi.mapper.CuisineMapper;
import org.ex.zomatocloneapi.repository.CuisineRepository;
import org.ex.zomatocloneapi.repository.RestaurantRepository;
import org.ex.zomatocloneapi.requestdto.CuisineRequest;
import org.ex.zomatocloneapi.responsedtao.CuisineResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CuisineService {

    private final CuisineRepository cuisineRepository;
    private final RestaurantRepository restaurantRepository;

    public CuisineResponse addCuisine(CuisineRequest cuisineRequest) {
        return CuisineMapper
                .mapToCuisineResponse(cuisineRepository.save(CuisineMapper
                        .mapToCuisine(cuisineRequest, new Cuisine())));
    }

    public List<CuisineResponse> getAllCuisines() {
        return cuisineRepository.findAll()
                .stream()
                .map(CuisineMapper::mapToCuisineResponse) .toList();
    }

    private Cuisine findOrCreateCuisineByTitle(String title) {
        return cuisineRepository.findByTitle(title)
                .orElseGet(() -> {
                    Cuisine newCuisine = new Cuisine();
                    newCuisine.setTitle(title);
                    return cuisineRepository.save(newCuisine);
                });
    }

    public List<CuisineResponse> addCuisinesToRestaurant(String restaurantId, List<CuisineRequest> cuisineRequest) {
        Set<Cuisine> cuisines = cuisineRequest
                .stream()
                .map(c -> CuisineMapper.mapToCuisine(c, new Cuisine()))
                .map(c -> this.findOrCreateCuisineByTitle(c.getTitle()))
                .collect(Collectors.toSet());

        return restaurantRepository.findById(restaurantId)
                .map(r -> {
                    r.setCuisines(cuisines);
                    restaurantRepository.save(r);
                    return r.getCuisines().stream().map(CuisineMapper::mapToCuisineResponse).toList();
                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found by the given id"));
    }

    public CuisineResponse addCuisineToRestaurant(String restaurantId, CuisineRequest cuisineRequest) {
        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> {
                    Cuisine cuisine = this.findOrCreateCuisineByTitle(CuisineMapper.mapToCuisine(cuisineRequest, new Cuisine()).getTitle());
                    restaurant.getCuisines().add(cuisine);
                    restaurantRepository.save(restaurant);
                    return CuisineMapper.mapToCuisineResponse(cuisine);
                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found by the given id"));
    }
}
