package org.ex.zomatocloneapi.responsedtao;

import lombok.Getter;
import lombok.Setter;
import org.ex.zomatocloneapi.enums.DietTypes;

import java.util.List;

@Getter
@Setter
public class RestaurantResponse {
    private String restaurantId;
    private String name;
    private String description;
    private String email;
    private String phoneNumber;
    private List<DietTypes> dietType;
    private AddressResponse addressResponse;
}
