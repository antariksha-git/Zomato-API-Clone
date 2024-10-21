package org.ex.zomatocloneapi.requestdto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    @NotBlank(message = "Address Line 1 cannot be blank")
    @Size(max = 255, message = "Address Line 1 cannot exceed 255 characters")
    @Pattern(regexp = "^[A-Za-z0-9 #,-]*$", message = "Address Line 1 contains invalid characters")
    private String addressLine1;

    @Size(max = 255, message = "Address Line 2 cannot exceed 255 characters")
    @Pattern(regexp = "^[A-Za-z0-9 #,-]*$", message = "Address Line 2 contains invalid characters")
    private String addressLine2;

    @Size(max = 100, message = "Landmark cannot exceed 100 characters")
    @Pattern(regexp = "^[A-Za-z0-9 #,-]*$", message = "Landmark contains invalid characters")
    private String landmark;

    @NotBlank(message = "Area cannot be blank")
    @Size(max = 100, message = "Area cannot exceed 100 characters")
    @Pattern(regexp = "^[A-Za-z0-9 #,-]*$", message = "Area contains invalid characters")
    private String area;

    @NotBlank(message = "City cannot be blank")
    @Pattern(regexp = "^[A-Za-z]+$", message = "City must contain only alphabetic characters")
    private String city;

    @NotBlank(message = "State cannot be blank")
    @Pattern(regexp = "^[A-Za-z]+$", message = "State must contain only alphabetic characters")
    private String state;

    @NotBlank(message = "Pin Code cannot be blank")
    @Pattern(regexp = "^[1-9][0-9]{5}$", message = "Pin Code must be a valid 6-digit number")
    private String pinCode;

    @NotNull(message = "Latitude cannot be null")
    @Min(value = -90, message = "Latitude must be between -90 and 90")
    @Max(value = 90, message = "Latitude must be between -90 and 90")
    private Double latitude;

    @NotNull(message = "Longitude cannot be null")
    @Min(value = -180, message = "Longitude must be between -180 and 180")
    @Max(value = 180, message = "Longitude must be between -180 and 180")
    private Double longitude;
}
