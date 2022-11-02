package com.auction.buyer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyerResponseDTO {
    private Integer buyerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String productId;
    private BigDecimal bidAmount;
//    private BidResponseDTO bidResponseDTO;
//    private AddressResponseDTO addressResponseDTO;
//    private ProductResponseDTO productResponseDTO;

}
