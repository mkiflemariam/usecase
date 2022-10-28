package com.auction.buyer.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BuyerResponseDto {
    private String buyerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String productId;
    private BigDecimal bidAmount;
    private AddressResponseDto addressResponseDto;
    private ProductResponseDto productResponseDto;
    private BidRequestDto bidRequestDto;
}
