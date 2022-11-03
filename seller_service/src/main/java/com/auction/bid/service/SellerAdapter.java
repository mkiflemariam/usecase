package com.auction.bid.service;

import com.auction.bid.dto.SellerRequestDTO;
import com.auction.bid.dto.SellerResponseDTO;
import com.auction.bid.entity.Seller;

public class SellerAdapter {
    public static Seller sellerRequestDtoToSeller(SellerRequestDTO sellerRequestDTO) {


        Seller seller = Seller.builder()
                .firstName(sellerRequestDTO.getFirstName())
                .lastName(sellerRequestDTO.getLastName())
                .email(sellerRequestDTO.getEmail())
                .phone(sellerRequestDTO.getPhone())
                .addressId(sellerRequestDTO.getAddressId())
                .build();
        return seller;
    }

    public static SellerResponseDTO sellerToSellerResponseDto(Seller seller) {


        SellerResponseDTO sellerResponseDTO = SellerResponseDTO.builder()
                .sellerId(seller.getSellerId())
                .firstName(seller.getFirstName())
                .lastName(seller.getLastName())
                .email(seller.getEmail())
                .phone(seller.getPhone())
                .addressId(seller.getAddressId())
                .build();
        return sellerResponseDTO;
    }
}
