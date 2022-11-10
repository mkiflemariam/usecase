package com.auction.buyer.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import com.auction.buyer.request.CreateBuyerRequest;
import com.auction.buyer.response.BuyerResponse;
import com.auction.buyer.response.ProductResponse;

import com.auction.buyer.service.BuyerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/e-auction/api/v1/buyer")
@RefreshScope
public class BuyerController {
	

	@Autowired
	BuyerService buyerService;
	

	@PostMapping("/place-bid")
	public ResponseEntity<BuyerResponse> createBuyer(@Valid @RequestBody CreateBuyerRequest createBuyerRequest) {
		 
		return new ResponseEntity<>(buyerService.createBuyer(createBuyerRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BuyerResponse> getById(@PathVariable String id) {
		return ResponseEntity.ok(buyerService.getById(id));
	}
 
	
	@PutMapping("/update-bid/{productId}/{buyerEmail}/{newBidAmount}")
	public ResponseEntity<ProductResponse> updateBidAmount(@PathVariable String productId,
														   @PathVariable String buyerEmail, @PathVariable BigDecimal newBidAmount) {
		return new ResponseEntity<>(buyerService.updateBidAmount(productId, buyerEmail, newBidAmount), HttpStatus.OK);
		
	}
 
}
