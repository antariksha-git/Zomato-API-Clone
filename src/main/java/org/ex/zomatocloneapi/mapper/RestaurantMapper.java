package org.ex.zomatocloneapi.mapper;

import org.ex.zomatocloneapi.entity.Restaurant;
import org.ex.zomatocloneapi.requestdto.RestaurantRequest;
import org.ex.zomatocloneapi.responsedtao.RestaurantResponse;

public class RestaurantMapper {

    public static Restaurant mapToRestaurant(RestaurantRequest restaurantRequest, Restaurant restaurant) {
        restaurant.setDescription(restaurantRequest.getDescription());
        restaurant.setName(restaurantRequest.getName());
        restaurant.setDescription(restaurantRequest.getDescription());
        restaurant.setEmail(restaurantRequest.getEmail());
        restaurant.setPhoneNumber(restaurantRequest.getPhoneNumber());
        restaurant.setDietType(restaurantRequest.getDietType());

        return restaurant;
    }

    public static RestaurantResponse mapToRestaurantResponse(Restaurant restaurant) {
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        restaurantResponse.setRestaurantId(restaurant.getRestaurantId());
        restaurantResponse.setDescription(restaurant.getDescription());
        restaurantResponse.setName(restaurant.getName());
        restaurantResponse.setDescription(restaurant.getDescription());
        restaurantResponse.setEmail(restaurant.getEmail());
        restaurantResponse.setPhoneNumber(restaurant.getPhoneNumber());
        restaurantResponse.setDietType(restaurant.getDietType());

        return restaurantResponse;
    }
}
