package com.auction.bid.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class SellerRequestDTO {
    @NotEmpty(message="first name should not be null or empty")
    @Size(min=5, max=30, message="First name size should be between 5 and 30 letters")
    private String firstName;
    @NotEmpty(message="Last name should not be null or empty")
    @Size(min=5, max=25, message="First name size should be between 5 and 25 letters")
    private String lastName;

    @NotEmpty(message="Email should not be null or empty")
    @Email
    private String email;

    @NotNull(message="Phone number shoud not be empty or null")
    @Size(min=10, max=10, message="Phone number should be 10 characters")
    private String phone;

    private String addressId;

//    private CreateProductRequest createProductRequest;
}
