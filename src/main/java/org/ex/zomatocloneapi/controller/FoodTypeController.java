package org.ex.zomatocloneapi.controller;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.requestdto.FoodTypeRequest;
import org.ex.zomatocloneapi.responsedtao.FoodTypeResponse;
import org.ex.zomatocloneapi.service.FoodTypeService;
import org.ex.zomatocloneapi.util.AppResponseBuilder;
import org.ex.zomatocloneapi.util.ErrorStructure;
import org.ex.zomatocloneapi.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class FoodTypeController {

    private final FoodTypeService foodTypeService;

    @PostMapping("/food-type")
    public ResponseEntity<ResponseStructure<FoodTypeResponse>> saveFoodType(@RequestBody FoodTypeRequest foodTypeRequest) {
        return AppResponseBuilder
                .create(HttpStatus.CREATED, "Food created successfully", foodTypeService
                        .saveFoodType(foodTypeRequest));
    }

}
