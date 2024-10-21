package org.ex.zomatocloneapi.requestdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.ex.zomatocloneapi.enums.DietTypes;
import java.util.List;

@Getter
@Setter
public class RestaurantRequest {

    @NotBlank(message = "Restaurant name cannot be blank")
    @Size(max = 255, message = "Restaurant name cannot exceed 255 characters")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Restaurant name contains invalid characters")
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Pattern(regexp = "^[A-Za-z0-9 ,.-]*$", message = "Description contains invalid characters")
    private String description;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be a valid 10-digit number")
    private String phoneNumber;

    private List<DietTypes> dietType;
}
