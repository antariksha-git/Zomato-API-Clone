package org.ex.zomatocloneapi.mapper;

import org.ex.zomatocloneapi.entity.MenuCategory;
import org.ex.zomatocloneapi.requestdto.MenuCategoryRequest;
import org.ex.zomatocloneapi.responsedtao.MenuCategoryResponse;

public class MenuCategoryMapper {
    public static MenuCategory mapToMenuCategory(MenuCategoryRequest menuCategoryRequest, MenuCategory menuCategory) {
        menuCategory.setTitle(menuCategoryRequest.getTitle());
        return menuCategory;
    }

    public static MenuCategoryResponse mapToMenuCategoryResponse(MenuCategory menuCategory) {
        MenuCategoryResponse menuCategoryResponse = new MenuCategoryResponse();
        menuCategoryResponse.setCategoryId(menuCategory.getCategoryId());
        menuCategoryResponse.setTitle(menuCategory.getTitle());

        return  menuCategoryResponse;
    }
}
