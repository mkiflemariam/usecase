package com.auction.buyer.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BidRequestDto {

    private String name;
    private String email;
    private String mobile;
    private BigDecimal amount;
}
