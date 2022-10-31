package com.auction.buyer.feign;



import com.auction.buyer.request.BidRequest;
import com.auction.buyer.response.AddressResponse;
import com.auction.buyer.response.BidResponse;
import com.auction.buyer.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;

@FeignClient(value = "api-gateway")
public interface BuyerFeignClient {
    @GetMapping("/product-service/e-auction/api/v1/product/getById/{id}")
    public ProductResponse getProductById(@PathVariable("id") String id);


    @PutMapping("/product-service/e-auction/api/v1/product/{productId}/add-bid")
    public ProductResponse addBidToProduct(@PathVariable String productId, @RequestBody BidRequest bidRequest);


    @PutMapping("/product-service/e-auction/api/v1/product/{productId}/{buyerEmail}/{newBidAmount}")
    public ProductResponse updateAmountBid(@PathVariable("productId") String productId,
                                           @PathVariable("buyerEmail") String buyerEmail, @PathVariable("newBidAmount") BigDecimal newBidAmount);

    @PutMapping("/bid-service/e-auction/api/v1/bid/update-bid/{productId}/{buyerEmail}/{newBidAmount}")
    public BidResponse updateBidAmount(@PathVariable String productId,
                                       @PathVariable String buyerEmail, @PathVariable BigDecimal newBidAmount);
    @GetMapping("/address-service/e-auction/api/v1/address/getById/{id}")
    public AddressResponse getAddressById(@PathVariable("id") String id);
}
