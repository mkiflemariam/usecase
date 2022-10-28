package com.auction.buyer.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BidResponseDto {

    private String bidId;
    private String name;
    private String email;
    private String mobile;
    private BigDecimal amount;

}
