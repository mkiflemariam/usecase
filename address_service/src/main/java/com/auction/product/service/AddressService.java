package com.auction.product.service;

import com.auction.product.domain.Address;
import com.auction.product.dto.AddressRequestDTO;
import com.auction.product.dto.AddressResponseDto;
import com.auction.product.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    public AddressResponseDto createAddress(AddressRequestDTO addressRequestDTO) {
        Address address = AddressAdapter.AddressDtoToAddress(addressRequestDTO);

        AddressResponseDto addressResponseDto = AddressAdapter.AddressToAddressResponseDto(addressRepository.save(address));
        return addressResponseDto;
    }

    public AddressResponseDto getAddressById(int id) {

        AddressResponseDto addressResponseDto = AddressAdapter.AddressToAddressResponseDto(addressRepository.findById(id).get());
        return addressResponseDto;
    }


    public Collection<AddressResponseDto> findAllAddresses() {
        List<Address> addressList = addressRepository.findAll();
        List<AddressResponseDto> addressResponseDtos = new ArrayList<>();
        if(addressList!=null){
            for(Address a:addressList){
                addressResponseDtos.add(AddressAdapter.AddressToAddressResponseDto(a));
            }

        }
        return addressResponseDtos;
    }
}
