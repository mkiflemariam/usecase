package com.auction.bid.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Bid {
    private String bidId;
    private BigDecimal amount;
    private String name;
    private String email;
    private String mobile;
    private String productId;
}
