package com.auction.buyer;


import com.auction.buyer.dto.AddressResponseDto;
import com.auction.buyer.dto.BidRequestDto;
import com.auction.buyer.dto.ProductResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;

public interface BuyerFeignClient {
    @GetMapping("/address-service/e-auction/api/v1/address/getById/{id}")
    public AddressResponseDto getAddressById(String id);

    @PutMapping("/product-service/e-auction/api/v1/product/{productId}/{buyerEmail}/{newBidAmount}}")
    public ProductResponseDto updateAmountBid(String productId, String buyerEmail, BigDecimal newBidAmount);

    @PutMapping("/bid-service/e-auction/api/v1/bid/update-bid/{productId}/{buyerEmail}/{newBidAmount}}")
    public ProductResponseDto updateBidAmount(String productId, String buyerEmail, BigDecimal newBidAmount);

    @PutMapping("/product-service/e-auction/api/v1/product/{productId}/add-bid")
    public ProductResponseDto addBidToProduct(String productId, BidRequestDto bidRequestDto);
}
