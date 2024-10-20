package org.ex.zomatocloneapi.service;

import lombok.AllArgsConstructor;
import org.ex.zomatocloneapi.entity.Address;
import org.ex.zomatocloneapi.mapper.AddressMapper;
import org.ex.zomatocloneapi.repository.AddressRepository;
import org.ex.zomatocloneapi.requestdto.AddressRequest;
import org.ex.zomatocloneapi.responsedtao.AddressResponse;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressResponse addAddress(AddressRequest addressRequest) {
        return AddressMapper
                .mapToAddressResponse(addressRepository
                        .save(AddressMapper.mapToAddress(addressRequest, new Address())));
    }
}
