package com.auction.bid.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private String sellerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String addressId;


}
