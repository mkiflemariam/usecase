package com.auction.product.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressResponseDto {

    private Integer Id;
    private String street;
    private String city;
    private String state;
    private String pin;
}
