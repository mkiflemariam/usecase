package com.auction.buyer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyerRequestDTO {

    @NotEmpty(message = "first name should not be empty")
    @Size(min = 5, max = 30, message = "first name should be between 5 and 30 character long")
    private String firstName;

    @NotEmpty(message = "last name should not be empty")
    @Size(min = 5, max = 25, message = "last name should be between 5 and 25 character long")
    private String lastName;

    @NotEmpty(message = "email should not be empty")
    @Email
    private String email;

    @NotEmpty(message = "Phone number should not be empty")
    @Size(min = 10, max = 10, message = "phone number should be 10 character long")
    private String phone;
    private String productId;
    private BigDecimal bidAmount;
    private String addressId;
    //private BidRequestDTO bidRequestDTO;
}
