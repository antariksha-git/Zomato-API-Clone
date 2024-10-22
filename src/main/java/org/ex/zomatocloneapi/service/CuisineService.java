package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.entity.Cuisine;
import org.ex.zomatocloneapi.mapper.CuisineMapper;
import org.ex.zomatocloneapi.repository.CuisineRepository;
import org.ex.zomatocloneapi.requestdto.CuisineRequest;
import org.ex.zomatocloneapi.responsedtao.CuisineResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CuisineService {

    private final CuisineRepository cuisineRepository;

    public CuisineResponse addCuisine(CuisineRequest cuisineRequest) {
        return CuisineMapper
                .mapToCuisineResponse(cuisineRepository.save(CuisineMapper
                        .mapToCuisine(cuisineRequest, new Cuisine())));
    }

    public List<CuisineResponse> getAllCuisines() {
        return cuisineRepository.findAll()
                .stream()
                .map(CuisineMapper::mapToCuisineResponse) .toList();
    }

    public Cuisine findOrCreateCuisineByName(String title) {
        return cuisineRepository.findByTitle(title)
                .orElseGet(() -> {
                    Cuisine newCuisine = new Cuisine();
                    newCuisine.setTitle(title);
                    return cuisineRepository.save(newCuisine);
                });
    }


}
