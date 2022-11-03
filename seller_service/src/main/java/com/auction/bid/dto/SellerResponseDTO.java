package com.auction.bid.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SellerResponseDTO {
    private Integer sellerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String addressId;
//    private AddressResponse addressResponse;
}
