package org.ex.zomatocloneapi.mapper;

import org.ex.zomatocloneapi.entity.Address;
import org.ex.zomatocloneapi.requestdto.AddressRequest;
import org.ex.zomatocloneapi.responsedtao.AddressResponse;

public class AddressMapper {
    public static Address mapToAddress(AddressRequest addressRequest, Address address) {
        address.setAddressLine1(addressRequest.getAddressLine1());
        address.setAddressLine2(addressRequest.getAddressLine2());
        address.setCity(addressRequest.getCity());
        address.setArea(addressRequest.getArea());
        address.setLandmark(addressRequest.getLandmark());
        address.setState(addressRequest.getState());
        address.setLatitude(addressRequest.getLatitude());
        address.setLongitude(addressRequest.getLongitude());
        address.setPinCode(addressRequest.getPinCode());

        return address;
    }

    public static AddressResponse mapToAddressResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setAddressLine2(address.getAddressLine2());
        addressResponse.setAddressLine1(address.getAddressLine1());
        addressResponse.setCity(address.getCity());
        addressResponse.setArea(address.getArea());
        addressResponse.setLandmark(address.getLandmark());
        addressResponse.setState(address.getState());
        addressResponse.setLatitude(address.getLatitude());
        addressResponse.setLongitude(address.getLongitude());
        addressResponse.setPinCode(address.getPinCode());

        return addressResponse;
    }

}
