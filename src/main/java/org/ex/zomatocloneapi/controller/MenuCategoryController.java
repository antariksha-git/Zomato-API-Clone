package org.ex.zomatocloneapi.controller;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.requestdto.MenuCategoryRequest;
import org.ex.zomatocloneapi.responsedtao.MenuCategoryResponse;
import org.ex.zomatocloneapi.service.MenuCategoryService;
import org.ex.zomatocloneapi.util.AppResponseBuilder;
import org.ex.zomatocloneapi.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;

    @PostMapping("{restaurant_id}/menu")
    public ResponseEntity<ResponseStructure<MenuCategoryResponse>> saveMenuCategoryToRestaurant(@PathVariable("restaurant_id")String restaurantId, @RequestBody MenuCategoryRequest menuCategoryRequest) {
        return AppResponseBuilder
                .create(HttpStatus.CREATED, "Menu category created successfully", menuCategoryService
                        .saveMenuCategory(restaurantId, menuCategoryRequest));
    }

    @PutMapping("menu/{category_id}")
    public ResponseEntity<ResponseStructure<MenuCategoryResponse>> updateMenuCategory(@PathVariable("category_id") long categoryId, @RequestBody MenuCategoryRequest menuCategoryRequest) {
        return AppResponseBuilder
                .create(HttpStatus.OK, "Menu category updated successfully", menuCategoryService
                        .updateMenuCategory(categoryId, menuCategoryRequest));
    }
}
