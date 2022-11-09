package com.auction.product.openfeignclient;

import java.math.BigDecimal;


import com.auction.product.request.BidRequest;
import com.auction.product.response.BidResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



public interface BidFeignClient {

    @PostMapping("/bid-producer-service/e-auction/api/v1/commandBids/{productId}")
	public BidResponse addBid(@PathVariable String productId, @RequestBody BidRequest bidRequest);
    
	@PutMapping("/bid-producer-service/e-auction/api/v1/commandBids/{productId}/{buyerEmail}/{newBidAmount}")
	public BidResponse updateBidAmountUsingEmail (@PathVariable String productId, @PathVariable("buyerEmail") String email, 
			@PathVariable("newBidAmount") BigDecimal newBidAmount);
	@GetMapping("/bid-producer-service/e-auction/api/v1/queryBids/{email}")
	public Boolean emailExist(@PathVariable String email);
	
	@GetMapping("/bid-producer-service/e-auction/api/v1/bid/searchBidByEmail/{email}")
	public BidResponse searchBidByEmail(@PathVariable String email);


}
