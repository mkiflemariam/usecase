package com.auction.buyer.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductResponseDto {

    private String productId;
    private String name;
    private String shortDescription;
    private String detailDescription;
    private String category;
    private BigDecimal startingPrice;
    private Date bidEndDate;
    private BidResponseDto bidResponseDto;
}
