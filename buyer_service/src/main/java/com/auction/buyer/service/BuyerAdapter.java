package com.auction.buyer.service;

import com.auction.buyer.domain.Buyer;
import com.auction.buyer.dto.BuyerRequestDto;
import com.auction.buyer.dto.BuyerResponseDto;

public class BuyerAdapter {
    
    public BuyerRequestDto getBuyerDto(Buyer buyer){
        
        BuyerRequestDto buyerDto = BuyerRequestDto.builder()
                .firstName(buyer.getFirstName())
                .lastName(buyer.getLastName())
                .email(buyer.getEmail())
                .phone(buyer.getPhone())
                .productId(buyer.getProductId())
                .addressId(buyer.getAddressId())
                .bidAmount(buyer.getBidAmount())
                //.bidRequestDto(buyer.getBidRequestDto)
                .build();
     return buyerDto;   
    }
    
    public Buyer getBuyer(BuyerRequestDto buyerDto){
        Buyer newBuyer =  Buyer.builder()
                .firstName(buyerDto.getFirstName())
                .lastName(buyerDto.getLastName())
                .email(buyerDto.getEmail())
                .phone(buyerDto.getPhone())
                .productId(buyerDto.getProductId())
                .bidAmount(buyerDto.getBidAmount())
                .addressId(buyerDto.getAddressId())
                .build();
        return newBuyer;
    }

    public BuyerResponseDto getBuyerResonseDto(Buyer buyer){

        BuyerResponseDto buyerResponseDto  = BuyerResponseDto.builder()
                .buyerId(buyer.getBuyerId())
                .firstName(buyer.getFirstName())
                .lastName(buyer.getLastName())
                .email(buyer.getEmail())
                .phone(buyer.getPhone())
                .productId(buyer.getProductId())
                .bidAmount(buyer.getBidAmount())
                //.addressResponseDto(buyer.getAddressResponseDto)
                //.productResponseDto(buyer.getProductResponseDto())
                //.bidRequestDto(buyer.getBidRequestDto())
                .build();
        return buyerResponseDto;
    }
}
