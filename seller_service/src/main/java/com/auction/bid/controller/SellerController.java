package com.auction.bid.controller;


import com.auction.bid.dto.SellerRequestDTO;
import com.auction.bid.dto.SellerResponseDTO;
import com.auction.bid.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
public class SellerController {

	@Autowired
	SellerService sellerService;
	
	
	@PostMapping
	public ResponseEntity<?> createSeller (@RequestBody SellerRequestDTO sellerRequestDTO) {
		return new ResponseEntity<SellerResponseDTO>(sellerService.createSeller(sellerRequestDTO), HttpStatus.CREATED);
	}

		
	@GetMapping("/{id}")
	public ResponseEntity<?> getSellerById (@PathVariable String id) {

		return new ResponseEntity<SellerResponseDTO>(sellerService.getSellerById(id), HttpStatus.OK);
	}


	@GetMapping
	public ResponseEntity<?> showAllSellers() {

		return new ResponseEntity<Collection<SellerResponseDTO>>(sellerService.findAllSellers(), HttpStatus.OK);
		
	}
	
}
