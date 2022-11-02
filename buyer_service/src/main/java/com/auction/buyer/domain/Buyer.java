package com.auction.buyer.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {

    @Id
    private Integer buyerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String productId;
    private String addressId;
    private BigDecimal bidAmount;

}
