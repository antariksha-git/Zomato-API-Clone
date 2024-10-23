package org.ex.zomatocloneapi.service;

import lombok.Getter;
import lombok.Setter;
import org.ex.zomatocloneapi.repository.FoodTypeRepository;
import org.ex.zomatocloneapi.responsedtao.FoodTypeResponse;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class FoodTypeService {

    private final FoodTypeRepository foodTypeRepository;

    public FoodTypeResponse saveFoodType(FoodTypeRepository foodTypeRepository) {
        return
    }

}
