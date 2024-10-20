package org.ex.zomatocloneapi.requestdto;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.Getter;
import lombok.Setter;
import org.ex.zomatocloneapi.enums.DietTypes;

import java.util.List;

@Getter
@Setter
public class RestaurantRequest {
    private String name;
    private String description;
    private String email;
    private String phoneNumber;
    private List<DietTypes> dietType;
}
