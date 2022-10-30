package com.auction.buyer.dto;

import com.auction.buyer.domain.Buyer;
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

    public BuyerResponseDto(Buyer buyer){
        this.buyerId = buyer.getBuyerId();
        this.firstName = buyer.getFirstName();
        this.lastName = buyer.getLastName();
        this.email = buyer.getEmail();
        this.phone = buyer.getPhone();
        this.productId = buyer.getProductId();
        this.bidAmount = buyer.getBidAmount();

    }
}
