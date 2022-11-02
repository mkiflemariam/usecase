package com.auction.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private String shortDescription;
    private String detailDescription;
    private String category;
    private BigDecimal startingPrice;
    private Date bidEndDate;

    @ElementCollection
    private List<String> bid;

}
