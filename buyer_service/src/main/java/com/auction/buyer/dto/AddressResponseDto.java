package com.auction.buyer.dto;

import lombok.Data;

@Data
public class AddressResponseDto {

    private String addressId;
    private String street;
    private String city;
    private String state;
    private String pin;
}
