package org.ex.zomatocloneapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.requestdto.CuisineRequest;
import org.ex.zomatocloneapi.responsedtao.CuisineResponse;
import org.ex.zomatocloneapi.service.CuisineService;
import org.ex.zomatocloneapi.service.RestaurantService;
import org.ex.zomatocloneapi.util.AppResponseBuilder;
import org.ex.zomatocloneapi.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class CuisineController {

    private final CuisineService cuisineService;
    private final RestaurantService restaurantService;

    @Operation(summary = "Create a new cuisine", description = "Creates a new cuisine and returns the created cuisine details.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cuisine created successfully", content = @Content(schema = @Schema(implementation = CuisineResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data", content = @Content)
    })
    @PostMapping("/cuisine")
    public ResponseEntity<ResponseStructure<CuisineResponse>> saveCuisine(@RequestBody CuisineRequest cuisineRequest) {
        return AppResponseBuilder.create(HttpStatus.CREATED, "Create cuisine", cuisineService.addCuisine(cuisineRequest));
    }

    @Operation(summary = "Get all cuisines", description = "Fetches the details of all cuisines available in the system.")
    @ApiResponses({
            @ApiResponse(responseCode = "302", description = "Cuisines found", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "404", description = "No cuisines found", content = @Content)
    })
    @GetMapping("/cuisine")
    public ResponseEntity<ResponseStructure<List<CuisineResponse>>> getCuisine() {
        return AppResponseBuilder.create(HttpStatus.FOUND, "Found All Cuisines", cuisineService.getAllCuisines());
    }

    @Operation(summary = "Add multiple cuisines to a restaurant", description = "Adds a list of cuisines to the specified restaurant.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cuisines added successfully", content = @Content(schema = @Schema(implementation = List.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data or restaurant ID", content = @Content)
    })
    @PostMapping("/{restaurant_id}/cuisines")
    public ResponseEntity<ResponseStructure<List<CuisineResponse>>> saveCuisineToRestaurant(@RequestBody List<CuisineRequest> cuisineRequest, @PathVariable("restaurant_id") String restaurantId) {
        return AppResponseBuilder.create(HttpStatus.CREATED, "Successfully added cuisines to restaurant", cuisineService.addCuisinesToRestaurant(restaurantId, cuisineRequest));
    }

    @Operation(summary = "Add a single cuisine to a restaurant", description = "Adds a single cuisine to the specified restaurant.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cuisine added successfully", content = @Content(schema = @Schema(implementation = CuisineResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data or restaurant ID", content = @Content)
    })
    @PostMapping("/{restaurant_id}/cuisine")
    public ResponseEntity<ResponseStructure<CuisineResponse>> saveCuisineToRestaurant(@RequestBody CuisineRequest cuisineRequest, @PathVariable("restaurant_id") String restaurantId) {
        return AppResponseBuilder.create(HttpStatus.CREATED, "Successfully added cuisines to restaurant", cuisineService.addCuisineToRestaurant(restaurantId, cuisineRequest));
    }
}
