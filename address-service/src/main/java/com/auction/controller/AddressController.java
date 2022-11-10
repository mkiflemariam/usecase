package com.auction.controller;

import com.auction.response.AddressResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.request.CreateAddressRequest;
import com.auction.service.AddressService;

@RestController
@RequestMapping("/e-auction/api/v1/address")
@RefreshScope
public class AddressController {
	Logger logger = LoggerFactory.getLogger(AddressController.class);
	//logger.info("entry");

	@Autowired
	AddressService addressService;
	
//	@Value("${address.test}")
//	private String addressTest;

	@PostMapping
	public AddressResponse createAddress (@RequestBody CreateAddressRequest createAddressRequest) {
		logger.info("entry to create address");
		return addressService.createAddress(createAddressRequest);
	}
	@GetMapping("/getById/{id}")
	public AddressResponse getAddressById(@PathVariable String id) {
		logger.info("Address controller before get address by id");
		return addressService.getById(id);
	}
//	@GetMapping("/test")
//	public String test() {
//		return addressTest;
//	}
	

}
