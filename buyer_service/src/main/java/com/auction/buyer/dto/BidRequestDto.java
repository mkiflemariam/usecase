package com.auction.buyer.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BidRequestDto {

    private String name;
    private String email;
    private String mobile;
    private BigDecimal amount;
}
