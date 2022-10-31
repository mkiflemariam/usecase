package com.auction.bid.controller;


import com.auction.bid.request.CreateSellerRequest;
import com.auction.bid.response.Product;
import com.auction.bid.response.ProductResponse;
import com.auction.bid.response.SellerResponse;
import com.auction.bid.service.SellerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/e-auction/api/v1/seller")
public class SellerController {
	
	Logger logger = LoggerFactory.getLogger(SellerController.class);
	
	@Autowired
	SellerService sellerService;
	
	
	@PostMapping()
	public ResponseEntity<SellerResponse> createSeller (@Valid @RequestBody CreateSellerRequest createStudentRequest) {
		return new ResponseEntity<>(sellerService.createSeller(createStudentRequest), HttpStatus.CREATED);
	}
	@PostMapping("/add-product")
	public ResponseEntity<SellerResponse> addProductBySeller (@Valid @RequestBody CreateSellerRequest createStudentRequest) {
		logger.info("Seller controller entry");
		return new ResponseEntity<>(sellerService.addProductBySeller(createStudentRequest), HttpStatus.CREATED);
	}
		
	@GetMapping("/getById/{id}")
	public ResponseEntity<SellerResponse> getById (@PathVariable String id) {
		logger.info("");
		return ResponseEntity.ok(sellerService.getById(id));
	}
	//public ResponseEntity<String> deleteProduct(@PathVariable String id) {
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String id) {
		logger.info("1");
		sellerService.deleteProduct(id);
		 return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
	}
	@GetMapping("/show-bid/{productId}")
	public ResponseEntity<ProductResponse> showBids(@PathVariable String productId) {
		logger.info("First test");
		return ResponseEntity.ok(sellerService.showBids(productId));
		
	}
	@GetMapping("/show-bid")
	public ResponseEntity<List<Product>> showAllProducts() {
		logger.info("First test");
		return sellerService.showAllProducts();
		
	}
	
}
