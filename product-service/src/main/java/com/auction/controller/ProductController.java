package com.auction.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.auction.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.entity.Product;
import com.auction.request.BidRequest;
import com.auction.request.CreateProductRequest;
import com.auction.response.ProductResponse;
import com.auction.service.ProductService;

@RestController
@RequestMapping("/e-auction/api/v1/product")
@RefreshScope
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping
	public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {

		return new ResponseEntity<>(productService.createProduct(createProductRequest), HttpStatus.CREATED);		
	}
	@GetMapping("/getById/{id}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") String id) {

				
		return ResponseEntity.ok(productService.getById(id));		
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> productList = productService.getAllProducts(); 
		if(productList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		

		 
		return ResponseEntity.ok(productList);		
	}
	

	@PutMapping("/{productId}/add-bid")	
	public ResponseEntity<ProductResponse> addBid2Product(@PathVariable String productId, @RequestBody BidRequest bidRequest) {

		return new ResponseEntity<>(productService.addBidToProduct(productId, bidRequest), HttpStatus.OK);
	}

	
	@PutMapping("/{productId}/{buyerEmail}/{newBidAmount}")	
	public ResponseEntity<ProductResponse> updateAmountBid(@PathVariable String productId, @PathVariable String buyerEmail, @PathVariable BigDecimal newBidAmount ) {
		return new ResponseEntity<>(productService.updateBidAmount(productId, buyerEmail, newBidAmount), HttpStatus.OK);		 
		
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) {

		Product product = productService.findById(id);
		if(product.getBidEndDate().before(new Date())) {

			 new ResourceNotFoundException("Its Bid date is over", id, 0);
			return new ResponseEntity<String>("Its Bid date is over", HttpStatus.BAD_REQUEST);	
		}
		else if(product.getBids().isEmpty() || product.getBids() == null)  {

			productService.deleteProduct(id);

			return new ResponseEntity<String>(" Product deleted successfully.", HttpStatus.OK);
			//	
		}

		return new ResponseEntity<String>("At least one bid is placed", HttpStatus.BAD_REQUEST);
			
	}	

}
