package org.ex.zomatocloneapi.controller;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.repository.CuisineRepository;
import org.ex.zomatocloneapi.requestdto.CuisineRequest;
import org.ex.zomatocloneapi.responsedtao.CuisineResponse;
import org.ex.zomatocloneapi.service.CuisineService;
import org.ex.zomatocloneapi.util.AppResponseBuilder;
import org.ex.zomatocloneapi.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class CuisineController {

    private final CuisineService cuisineService;

    @PostMapping("/cuisine")
    public ResponseEntity<ResponseStructure<CuisineResponse>> saveCuisine(@RequestBody CuisineRequest cuisineRequest) {
        return AppResponseBuilder.create(HttpStatus.CREATED, "Create cuisine", cuisineService.addCuisine(cuisineRequest));
    }
}
