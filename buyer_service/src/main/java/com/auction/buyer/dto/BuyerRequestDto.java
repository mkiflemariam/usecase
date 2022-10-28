package com.auction.buyer.dto;

import com.auction.buyer.dto.BidRequestDto;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
public class BuyerRequestDto {

    @NotNull(message = "First Name should not be null or empty")
    @Size(min = 5, max = 30, message = "First name should be between 5 and 30 characters long")
    private String firstName;

    @NotNull(message = "Last Name should not be null or empty")
    @Size(min = 5, max = 25, message = "Last name should be between 5 and 25 characters long")
    private String lastName;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    @NotNull(message = "Phone number should not be null or empty")
    @Size(min = 10, max = 10, message = "Phone number should be exactly 10 characters long")
    private String phone;
    private String productId;
    private String addressId;
    private BigDecimal bidAmount;
    private BidRequestDto bidRequestDto;
}
