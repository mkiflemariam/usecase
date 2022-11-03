package com.auction.buyer.service;

import com.auction.buyer.domain.Buyer;
import com.auction.buyer.dto.BuyerRequestDTO;
import com.auction.buyer.dto.BuyerResponseDTO;

public class BuyerAdapter {
    public static Buyer buyerRequestDtoToBuyer(BuyerRequestDTO buyerRequestDTO) {

        Buyer buyer = Buyer.builder()
                .firstName(buyerRequestDTO.getFirstName())
                .lastName(buyerRequestDTO.getLastName())
                .email(buyerRequestDTO.getEmail())
                .phone(buyerRequestDTO.getPhone())
                .productId(buyerRequestDTO.getProductId())
                .bidAmount(buyerRequestDTO.getBidAmount())
                .addressId(buyerRequestDTO.getAddressId())
                .build();
        return buyer;
    }

    public static BuyerResponseDTO buyerToBuyerResponseDto(Buyer buyer) {
        BuyerResponseDTO buyerResponseDTO = BuyerResponseDTO.builder()
                .buyerId(buyer.getBuyerId())
                .firstName(buyer.getFirstName())
                .lastName(buyer.getLastName())
                .email(buyer.getEmail())
                .phone(buyer.getPhone())
                .productId(buyer.getProductId())
                .bidAmount(buyer.getBidAmount())
                .build();
        return buyerResponseDTO;
    }
}
