package com.auction.product.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequestDTO {
    @NotNull(message = "Product should not be empty")
    @Size(min = 5, max = 30, message = "Product name should be between 5 and 30")
    private String productName;
    private String shortDescription;
    private String detailDescription;
    private String category;
    private BigDecimal startingPrice;
    private Date bidEndDate;
    private List<String> bid;
}
