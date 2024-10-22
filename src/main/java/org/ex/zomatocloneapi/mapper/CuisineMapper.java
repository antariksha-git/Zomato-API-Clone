package org.ex.zomatocloneapi.mapper;

import org.ex.zomatocloneapi.entity.Cuisine;
import org.ex.zomatocloneapi.requestdto.CuisineRequest;
import org.ex.zomatocloneapi.responsedtao.CuisineResponse;

public class CuisineMapper {

    public static Cuisine mapToCuisine(CuisineRequest cuisineRequest, Cuisine cuisine) {
        cuisine.setTitle(cuisineRequest.getTitle());
        return cuisine;
    }

    public static CuisineResponse mapToCuisineResponse(Cuisine cuisine) {
        CuisineResponse cuisineResponse = new CuisineResponse();
        cuisineResponse.setTitle(cuisine.getTitle());
        cuisineResponse.setCuisineId(cuisine.getCuisineId());
        return cuisineResponse;
    }
}
