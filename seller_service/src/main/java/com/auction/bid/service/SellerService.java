package com.auction.bid.service;


import java.util.List;

import com.auction.bid.entity.Seller;
import com.auction.bid.feignclients.SellerFeintClient;
import com.auction.bid.repository.SellerRepository;
import com.auction.bid.request.CreateSellerRequest;
import com.auction.bid.response.Product;
import com.auction.bid.response.ProductResponse;
import com.auction.bid.response.SellerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class SellerService {
	
	
	Logger logger = LoggerFactory.getLogger(SellerService.class);

	@Autowired
	SellerRepository sellerRepository;


	
	@Autowired
	SellerFeintClient sellerFeintClient;
	
	@Autowired
	CommonService commonService;

	public SellerResponse createSeller(CreateSellerRequest createSellerRequest) {

		Seller seller = new Seller();
		seller.setFirstName(createSellerRequest.getFirstName());
		seller.setLastName(createSellerRequest.getLastName());
		seller.setEmail(createSellerRequest.getEmail());
		seller.setPhone(createSellerRequest.getPhone());			
		seller.setAddressId(createSellerRequest.getAddressId());
		seller = sellerRepository.save(seller);
		
		SellerResponse sellerResponse = new SellerResponse(seller);
			
		sellerResponse.setAddressResponse(commonService.getAddressById(seller.getAddressId()));		

		return sellerResponse;
	}
	
	public SellerResponse getById (String id) {
		Seller seller = sellerRepository.findById(id).get();
		SellerResponse sellerResponse = new SellerResponse(seller);		
		//sellerResponse.setAddressResponse(SellerFeintClient.getAddressById(seller.getAddressId()));		
		
		sellerResponse.setAddressResponse(commonService.getAddressById(seller.getAddressId()));		
		
		return sellerResponse;
	}

	public SellerResponse addProductBySeller(CreateSellerRequest createSellerRequest) {
		Seller seller = new Seller();
		seller.setFirstName(createSellerRequest.getFirstName());
		seller.setLastName(createSellerRequest.getLastName());
		seller.setEmail(createSellerRequest.getEmail());
		seller.setPhone(createSellerRequest.getPhone());			
		seller.setAddressId(createSellerRequest.getAddressId());
		seller = sellerRepository.save(seller);		
		SellerResponse sellerResponse = new SellerResponse(seller);
		logger.info("at seller service- before rest call");
		sellerResponse.setProductResponse(
				sellerFeintClient.createProduct(createSellerRequest.getCreateProductRequest()));
		logger.info("after product rest call");
		sellerResponse.setAddressResponse(commonService.getAddressById(seller.getAddressId()));		
		logger.info("at seller service after rest call");
		return sellerResponse;
	}

	public String deleteProduct(String id) {
		return commonService.deleteProduct(id);		
	}
	public ProductResponse showBids(String productId) {
		logger.info("Test in service at the beginning");
		ProductResponse productResponse = commonService.getProductById(productId);
		logger.info("Test in service after productResponse");
		productResponse.setBidsList(commonService.getAllBidsByProductId(productId));
		logger.info("Test in service after setting setBidsList");
		//productResponse.setBids(productResponse.);
		return productResponse;
	}

	public ResponseEntity<List<Product>> showAllProducts() {
		return sellerFeintClient.getAllProducts();
	}

}
