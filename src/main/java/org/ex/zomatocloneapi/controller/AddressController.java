package org.ex.zomatocloneapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Add an address to a restaurant", description = "Creates a new address for the specified restaurant.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Address created successfully", content = @Content(schema = @Schema(implementation = AddressResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data", content = @Content)
    })
    @PostMapping("/address/{restaurant_id}")
    public ResponseEntity<ResponseStructure<AddressResponse>> addAddress(
            @PathVariable("restaurant_id") String restaurantId,
            @RequestBody @Valid AddressRequest addressRequest) {
        return AppResponseBuilder
                .create(HttpStatus.CREATED, "Address created successfully", addressService.addAddressToRestaurant(addressRequest, restaurantId));
    }

    @Operation(summary = "Update an existing address", description = "Updates the details of an existing address by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Address updated successfully", content = @Content(schema = @Schema(implementation = AddressResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request data", content = @Content),
            @ApiResponse(responseCode = "404", description = "Address not found", content = @Content)
    })
    @PutMapping("/address/{address_id}")
    public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(
            @PathVariable("address_id") int addressId,
            @RequestBody @Valid AddressRequest addressRequest) {
        return AppResponseBuilder
                .create(HttpStatus.OK, "Address updated successfully", addressService.updateAddress(addressId, addressRequest));
    }

}
