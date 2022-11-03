package com.auction.product.service;

import com.auction.product.domain.Address;
import com.auction.product.dto.AddressRequestDTO;
import com.auction.product.dto.AddressResponseDto;

public class AddressAdapter {
    public static Address AddressDtoToAddress(AddressRequestDTO addressRequestDTO) {
        Address address = Address.builder()
                .street(addressRequestDTO.getStreet())
                .city(addressRequestDTO.getCity())
                .state(addressRequestDTO.getState())
                .pin(addressRequestDTO.getPin())
                .build();
        return address;
    }

    public static AddressResponseDto AddressToAddressResponseDto(Address address) {
        AddressResponseDto addressResponseDto = AddressResponseDto.builder()
                .Id(address.getId())
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .pin(address.getPin())
                .build();
        return addressResponseDto;
    }
}
