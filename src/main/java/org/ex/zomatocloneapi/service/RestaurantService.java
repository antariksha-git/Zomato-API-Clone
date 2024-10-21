package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.entity.Image;
import org.ex.zomatocloneapi.entity.Restaurant;
import org.ex.zomatocloneapi.exception.RestaurantNotFoundByIdException;
import org.ex.zomatocloneapi.exception.RestaurantNotFoundByIdException;
import org.ex.zomatocloneapi.mapper.RestaurantMapper;
import org.ex.zomatocloneapi.repository.RestaurantRepository;
import org.ex.zomatocloneapi.requestdto.RestaurantRequest;
import org.ex.zomatocloneapi.responsedtao.RestaurantResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final ImageService imageService;

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
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        Image image = new Image();
        image.setUrl(imageUrl);

        restaurant.setImage(image);
        restaurantRepository.save(restaurant);

        return imageUrl;
    }
}
