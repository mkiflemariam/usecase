package com.auction.buyer.service;

import com.auction.buyer.domain.Buyer;
import com.auction.buyer.dto.BidRequestDto;
import com.auction.buyer.dto.BuyerRequestDto;
import com.auction.buyer.dto.BuyerResponseDto;
import com.auction.buyer.dto.ProductResponseDto;
import com.auction.buyer.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;


    public BuyerResponseDto creatBuyer(BuyerRequestDto buyerRequestDto) {
        Buyer newBuyer =  Buyer.builder()
                .firstName(buyerRequestDto.getFirstName())
                .lastName(buyerRequestDto.getLastName())
                .email(buyerRequestDto.getEmail())
                .phone(buyerRequestDto.getPhone())
                .productId(buyerRequestDto.getProductId())
                .bidAmount(buyerRequestDto.getBidAmount())
                .addressId(buyerRequestDto.getAddressId())
                .build();
        BuyerResponseDto buyerResponseDto = new BuyerResponseDto(buyerRepository.save(newBuyer));
        BidRequestDto bidRequestDto = BidRequestDto.builder()
                .amount()
        return null;
    }

    public Object getBuyId(String id) {
        return null;
    }

    public ProductResponseDto updateBidAmount(String productId, String buyerEmail, String newBidAmount) {
        return null;
    }
}
