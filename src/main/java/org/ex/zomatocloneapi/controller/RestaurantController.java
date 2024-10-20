package org.ex.zomatocloneapi.controller;

import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.ex.zomatocloneapi.requestdto.RestaurantRequest;
import org.ex.zomatocloneapi.responsedtao.RestaurantResponse;
import org.ex.zomatocloneapi.service.RestaurantService;
import org.ex.zomatocloneapi.util.AppResponseBuilder;
import org.ex.zomatocloneapi.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@RequestBody RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
        return AppResponseBuilder.create(HttpStatus.CREATED, "Restaurant added successfully", restaurantResponse);
    }

    @GetMapping("/restaurant/{restaurant_id}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> findRestaurantById(@PathVariable("restaurant_id") String restaurantId) {
        RestaurantResponse restaurantResponse = restaurantService.findRestaurantById(restaurantId);
        return AppResponseBuilder.create(HttpStatus.FOUND, "Restaurant found", restaurantResponse);
    }

    @PutMapping("/restaurant/{restaurant_id}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> updateRestaurant(@PathVariable("restaurant_id") String restaurantId, @RequestBody RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.updateRestaurant(restaurantId, restaurantRequest);
        return AppResponseBuilder.create(HttpStatus.OK, "Restaurant updated successfully", restaurantResponse);
    }

}
