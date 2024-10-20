package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.entity.Address;
import org.ex.zomatocloneapi.entity.Restaurant;
import org.ex.zomatocloneapi.mapper.AddressMapper;
import org.ex.zomatocloneapi.repository.AddressRepository;
import org.ex.zomatocloneapi.repository.RestaurantRepository;
import org.ex.zomatocloneapi.requestdto.AddressRequest;
import org.ex.zomatocloneapi.responsedtao.AddressResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final RestaurantRepository restaurantRepository;

    public AddressResponse addAddressToRestaurant(AddressRequest addressRequest, String restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .map(r -> {
                    r.setAddress(AddressMapper.mapToAddress(addressRequest, new Address()));
                    restaurantRepository.save(r);
                    return AddressMapper.mapToAddressResponse(r.getAddress());
                })
                .orElseThrow();
    }

    public AddressResponse updateAddress(int addressId, AddressRequest addressRequest) {
        return addressRepository.findById((long) addressId)
                .map(a ->
                    AddressMapper.mapToAddressResponse(addressRepository
                            .save(AddressMapper.mapToAddress(addressRequest, a)))
                ).orElseThrow();
    }

}
