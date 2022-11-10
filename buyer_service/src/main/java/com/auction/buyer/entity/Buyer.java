package com.auction.buyer.entity;

import java.math.BigDecimal;

import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Buyer {
	
	@Id
	private String buyerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String productId;
	private BigDecimal bidamount;	
	private String addressId;
	


}
