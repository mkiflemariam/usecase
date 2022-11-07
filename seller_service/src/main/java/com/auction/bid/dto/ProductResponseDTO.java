package com.auction.bid.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDTO {
    private Integer productId;
    private String productName;
    private String shortDescription;
    private String detailDescription;
    private String category;
    private BigDecimal startingPrice;
    private Date bidEndDate;
    private List<String> bidIdList;
}
