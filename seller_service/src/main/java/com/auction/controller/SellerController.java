package com.auction.controller;

import java.util.List;

import javax.validation.Valid;


import com.auction.request.CreateSellerRequest;
import com.auction.response.Product;
import com.auction.response.ProductResponse;
import com.auction.response.SellerResponse;
import com.auction.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping("/e-auction/api/v1/seller")
public class SellerController {

	
	@Autowired
	SellerService sellerService;
	
	
	@PostMapping()
	public ResponseEntity<SellerResponse> createSeller (@Valid @RequestBody CreateSellerRequest createStudentRequest) {
		return new ResponseEntity<>(sellerService.createSeller(createStudentRequest), HttpStatus.CREATED);
	}
	@PostMapping("/add-product")
	public ResponseEntity<SellerResponse> addProductBySeller (@Valid @RequestBody CreateSellerRequest createStudentRequest) {

		return new ResponseEntity<>(sellerService.addProductBySeller(createStudentRequest), HttpStatus.CREATED);
	}
		
	@GetMapping("/getById/{id}")
	public ResponseEntity<SellerResponse> getById (@PathVariable String id) {

		return ResponseEntity.ok(sellerService.getById(id));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable String id) {

		sellerService.deleteProduct(id);
		 return new ResponseEntity<>("Product deleted successfully.", HttpStatus.OK);
	}
	@GetMapping("/show-bid/{productId}")
	public ResponseEntity<ProductResponse> showBids(@PathVariable String productId) {

		return ResponseEntity.ok(sellerService.showBids(productId));
		
	}
	@GetMapping("/show-bid")
	public ResponseEntity<List<Product>> showAllProducts() {

		return sellerService.showAllProducts();
		
	}
	
}
