package org.ex.zomatocloneapi.mapper;

import org.ex.zomatocloneapi.entity.FoodType;
import org.ex.zomatocloneapi.requestdto.FoodTypeRequest;
import org.ex.zomatocloneapi.responsedtao.FoodTypeResponse;

public class FoodMapper {

    public static FoodType mapToFoodType(FoodTypeRequest foodTypeRequest, FoodType foodType) {
        foodType.setTitle(foodTypeRequest.getTitle());

        return foodType;
    }

    public static FoodTypeResponse mapToFoodTypeResponse(FoodType foodType) {
        FoodTypeResponse foodTypeResponse = new FoodTypeResponse();
        foodTypeResponse.setTitle(foodType.getTitle());
        foodTypeResponse.setTypeId(foodType.getTypeId());

        return foodTypeResponse;
    }
}
