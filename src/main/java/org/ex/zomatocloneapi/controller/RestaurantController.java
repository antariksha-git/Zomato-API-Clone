package org.ex.zomatocloneapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.requestdto.RestaurantRequest;
import org.ex.zomatocloneapi.responsedtao.RestaurantResponse;
import org.ex.zomatocloneapi.service.ImageService;
import org.ex.zomatocloneapi.service.RestaurantService;
import org.ex.zomatocloneapi.util.AppResponseBuilder;
import org.ex.zomatocloneapi.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final ImageService imageService;

    @Operation(summary = "Add a new restaurant", description = "Creates a new restaurant in the system and returns the restaurant details.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Restaurant added successfully", content = @Content(schema = @Schema(implementation = RestaurantResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data", content = @Content)
    })
    @PostMapping("/restaurant")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(
            @RequestBody @Valid RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
        return AppResponseBuilder.create(HttpStatus.CREATED, "Restaurant added successfully", restaurantResponse);
    }

    @Operation(summary = "Get restaurant by ID", description = "Fetches the details of a restaurant using its unique ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "302", description = "Restaurant found", content = @Content(schema = @Schema(implementation = RestaurantResponse.class))),
            @ApiResponse(responseCode = "404", description = "Restaurant not found", content = @Content)
    })
    @GetMapping("/restaurant/{restaurant_id}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> findRestaurantById(
            @PathVariable("restaurant_id") String restaurantId) {
        RestaurantResponse restaurantResponse = restaurantService.findRestaurantById(restaurantId);
        return AppResponseBuilder.create(HttpStatus.FOUND, "Restaurant found", restaurantResponse);
    }

    @Operation(summary = "Update a restaurant", description = "Updates the details of an existing restaurant using its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Restaurant updated successfully", content = @Content(schema = @Schema(implementation = RestaurantResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data", content = @Content),
            @ApiResponse(responseCode = "404", description = "Restaurant not found", content = @Content)
    })
    @PutMapping("/restaurant/{restaurant_id}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> updateRestaurant(
            @PathVariable("restaurant_id") String restaurantId,
            @RequestBody @Valid RestaurantRequest restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.updateRestaurant(restaurantId, restaurantRequest);
        return AppResponseBuilder.create(HttpStatus.OK, "Restaurant updated successfully", restaurantResponse);
    }

    @Operation(summary = "Upload restaurant logo", description = "Uploads an image file to be used as the restaurant's logo.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Image uploaded successfully", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Invalid file or restaurant ID", content = @Content)
    })
    @PostMapping("/{restaurantId}/upload-logo")
    public ResponseEntity<ResponseStructure<String>> uploadLogo(
            @PathVariable String restaurantId,
            @RequestParam("file") MultipartFile file) {
        String imageUrl = restaurantService.uploadRestaurantLogo(restaurantId, file);
        return AppResponseBuilder.create(HttpStatus.CREATED, "Image uploaded successfully", imageUrl);
    }
}
