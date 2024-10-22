package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.entity.Cuisine;
import org.ex.zomatocloneapi.mapper.CuisineMapper;
import org.ex.zomatocloneapi.repository.CuisineRepository;
import org.ex.zomatocloneapi.requestdto.CuisineRequest;
import org.ex.zomatocloneapi.responsedtao.CuisineResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CuisineService {

    private final CuisineRepository cuisineRepository;

    public CuisineResponse addCuisine(CuisineRequest cuisineRequest) {
        return CuisineMapper
                .mapToCuisineResponse(cuisineRepository.save(CuisineMapper
                        .mapToCuisine(cuisineRequest, new Cuisine())));
    }

}
