package com.auction.buyer.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@Builder
@Setter
@Getter
public class Buyer {

    @Id
    private String buyerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String productId;
    private String addressId;
    private BigDecimal bidAmount;


}
