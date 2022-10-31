package com.auction.buyer.response;

import com.auction.buyer.domain.Buyer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuyerResponse {

    private String buyerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String productId;
    private BigDecimal bidamount;
    private AddressResponse addressResponse;
    private ProductResponse productResponse;

    public BuyerResponse(Buyer buyer) {
        this.buyerId = buyer.getBuyerId();
        this.firstName = buyer.getFirstName();
        this.lastName = buyer.getLastName();
        this.email = buyer.getEmail();
        this.phone = buyer.getPhone();
        this.productId = buyer.getProductId();
        this.bidamount = buyer.getBidAmount();
    }


    public ProductResponse getProductResponse() {
        return productResponse;
    }

    public void setProductResponse(ProductResponse productResponse) {
        this.productResponse = productResponse;
    }



    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getBidamount() {
        return bidamount;
    }

    public void setBidamount(BigDecimal bidamount) {
        this.bidamount = bidamount;
    }

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }
}
