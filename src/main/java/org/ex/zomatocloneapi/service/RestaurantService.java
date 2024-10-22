package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.entity.Cuisine;
import org.ex.zomatocloneapi.entity.Image;
import org.ex.zomatocloneapi.entity.Restaurant;
import org.ex.zomatocloneapi.exception.RestaurantNotFoundByIdException;
import org.ex.zomatocloneapi.exception.RestaurantNotFoundByIdException;
import org.ex.zomatocloneapi.mapper.CuisineMapper;
import org.ex.zomatocloneapi.mapper.RestaurantMapper;
import org.ex.zomatocloneapi.repository.RestaurantRepository;
import org.ex.zomatocloneapi.requestdto.CuisineRequest;
import org.ex.zomatocloneapi.requestdto.RestaurantRequest;
import org.ex.zomatocloneapi.responsedtao.CuisineResponse;
import org.ex.zomatocloneapi.responsedtao.RestaurantResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ImageService imageService;
    private final CuisineService cuisineService;

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        return RestaurantMapper
                .mapToRestaurantResponse(restaurantRepository
                        .save(RestaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant())));
    }

    public RestaurantResponse findRestaurantById(String restaurantId) {
        return RestaurantMapper
                .mapToRestaurantResponse(restaurantRepository
                        .findById(restaurantId)
                        .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found")));
    }

    public RestaurantResponse updateRestaurant(String restaurantId, RestaurantRequest restaurantRequest) {
        return restaurantRepository.findById(restaurantId)
                .map(r -> {
                return RestaurantMapper
                        .mapToRestaurantResponse(restaurantRepository
                                .save(RestaurantMapper.mapToRestaurant(restaurantRequest, r)));
                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found"));

    }

    public String uploadRestaurantLogo(String restaurantId, MultipartFile file) {
        String imageUrl = imageService.uploadRestaurantLogo(file);
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found"));

        Image image = new Image();
        image.setUrl(imageUrl);

        restaurant.setImage(image);
        restaurantRepository.save(restaurant);

        return imageUrl;
    }

    public List<CuisineResponse> addCuisineToRestaurant(String restaurantId, List<CuisineRequest> cuisineRequest) {
        Set<Cuisine> cuisines = cuisineRequest
                .stream()
                .map(c -> CuisineMapper.mapToCuisine(c, new Cuisine()))
                .map(c -> cuisineService.findOrCreateCuisineByName(c.getTitle()))
                .collect(Collectors.toSet());

        return restaurantRepository.findById(restaurantId)
                .map(r -> {
                    r.setCuisines(cuisines);
                    restaurantRepository.save(r);
                    return r.getCuisines().stream().map(CuisineMapper::mapToCuisineResponse).toList();
                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found by the given id"));
    }
}
