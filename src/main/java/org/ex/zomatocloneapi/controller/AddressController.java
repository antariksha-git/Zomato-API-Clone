package org.ex.zomatocloneapi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.requestdto.AddressRequest;
import org.ex.zomatocloneapi.responsedtao.AddressResponse;
import org.ex.zomatocloneapi.service.AddressService;
import org.ex.zomatocloneapi.util.AppResponseBuilder;
import org.ex.zomatocloneapi.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/address/{restaurant_id}")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddress(@PathVariable("restaurant_id")String restaurantId, @RequestBody @Valid AddressRequest addressRequest) {
        return AppResponseBuilder
                .create(HttpStatus.CREATED, "Address created successfully", addressService.addAddressToRestaurant(addressRequest, restaurantId));
    }

    @PutMapping("/address/{address_id}")
    public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@PathVariable("address_id")int addressId, @RequestBody @Valid AddressRequest addressRequest) {
        return AppResponseBuilder
                .create(HttpStatus.OK, "Address updated successfully", addressService.updateAddress(addressId, addressRequest));
    }

}
