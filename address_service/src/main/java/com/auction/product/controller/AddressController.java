package com.auction.product.controller;

import com.auction.product.dto.AddressRequestDTO;
import com.auction.product.dto.AddressResponseDto;
import com.auction.product.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody AddressRequestDTO addressRequestDTO){
        return new ResponseEntity<AddressResponseDto>(addressService.createAddress(addressRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable int id){
        return new ResponseEntity<AddressResponseDto>(addressService.getAddressById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> findAllAddresses(){
        return new ResponseEntity<Collection<AddressResponseDto>>(addressService.findAllAddresses(), HttpStatus.OK);
    }
}
