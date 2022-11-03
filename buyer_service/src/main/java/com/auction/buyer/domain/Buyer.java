package com.auction.buyer.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer buyerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String productId;
    private String addressId;
    private BigDecimal bidAmount;

}
