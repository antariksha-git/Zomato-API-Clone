package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.ex.zomatocloneapi.entity.FoodType;
import org.ex.zomatocloneapi.mapper.FoodTypeMapper;
import org.ex.zomatocloneapi.repository.FoodTypeRepository;
import org.ex.zomatocloneapi.requestdto.FoodTypeRequest;
import org.ex.zomatocloneapi.responsedtao.FoodTypeResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
public class FoodTypeService {

    private final FoodTypeRepository foodTypeRepository;

    public FoodTypeResponse saveFoodType(FoodTypeRequest foodTypeRequest) {
        return FoodTypeMapper
                .mapToFoodTypeResponse(findOrCreateFoodTypeByTitle(foodTypeRequest.getTitle()));
    }

    public List<String> getAllFoodTypes() {
        return foodTypeRepository.findAll()
                .stream()
                .map(FoodType::getTitle)
                .toList();
    }

    private FoodType findOrCreateFoodTypeByTitle(String title) {
        return foodTypeRepository.findByTitleIgnoreCase(title)
                .orElseGet(() -> {
                    FoodType foodType = new FoodType();
                    foodType.setTitle(title);
                    return foodTypeRepository.save(foodType);
                });
    }

}
