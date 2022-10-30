package com.auction.buyer.service;

import com.auction.buyer.BuyerFeignClient;
import com.auction.buyer.domain.Buyer;
import com.auction.buyer.dto.BidRequestDto;
import com.auction.buyer.dto.BuyerRequestDto;
import com.auction.buyer.dto.BuyerResponseDto;
import com.auction.buyer.dto.ProductResponseDto;
import com.auction.buyer.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    BuyerFeignClient buyerFeignCLient;

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

        Buyer buyer = buyerRepository.save(newBuyer);
        BuyerResponseDto buyerResponseDto = new BuyerResponseDto(buyer);
        BidRequestDto bidRequestDto = BidRequestDto.builder()
                .amount(buyerResponseDto.getBidAmount())
                .email(buyerResponseDto.getEmail())
                .phone(buyerResponseDto.getPhone())
                .name(buyerResponseDto.getFirstName())
                .build();

        buyerResponseDto.setProductResponseDto(buyerFeignCLient.addBidToProduct(buyerRequestDto.getProductId(), bidRequestDto));
        buyerResponseDto.setAddressResponseDto(buyerFeignCLient.getAddressById(buyer.getAddressId()));

        return buyerResponseDto;
    }

    public BuyerResponseDto getBuyId(String id) {
        Buyer buyer = buyerRepository.findById(id).get();
        BuyerResponseDto buyerResponseDto = new BuyerResponseDto(buyer);

        buyerResponseDto.setAddressResponseDto(buyerFeignCLient.getAddressById(buyer.getAddressId()));
        return buyerResponseDto;
    }

    public ProductResponseDto updateBidAmount(String productId, String buyerEmail, BigDecimal newBidAmount) {

        ProductResponseDto productResponseDto = buyerFeignCLient.updateAmountBid(productId, buyerEmail, newBidAmount);

        return productResponseDto;
    }
}
