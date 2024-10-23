package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.entity.MenuCategory;
import org.ex.zomatocloneapi.exception.RestaurantNotFoundByIdException;
import org.ex.zomatocloneapi.mapper.MenuCategoryMapper;
import org.ex.zomatocloneapi.repository.MenuCategoryRepository;
import org.ex.zomatocloneapi.repository.RestaurantRepository;
import org.ex.zomatocloneapi.requestdto.MenuCategoryRequest;
import org.ex.zomatocloneapi.responsedtao.MenuCategoryResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MenuCategoryService {

    private final MenuCategoryRepository menuCategoryRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuCategoryResponse saveMenuCategory(String restaurantId, MenuCategoryRequest menuCategoryRequest) {
        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> {
                    MenuCategory menuCategory = MenuCategoryMapper.mapToMenuCategory(menuCategoryRequest, new MenuCategory());
                    restaurant.getMenuCategories().add(menuCategory);
                    restaurantRepository.save(restaurant);
                    menuCategory.setRestaurant(restaurant);
                    menuCategoryRepository.save(menuCategory);
                    return MenuCategoryMapper.mapToMenuCategoryResponse(menuCategory);
                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant with id " + restaurantId + " not found"));
    }

}
