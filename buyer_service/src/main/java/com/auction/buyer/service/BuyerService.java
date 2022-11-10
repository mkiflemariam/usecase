package com.auction.buyer.service;

import java.math.BigDecimal;

import com.auction.buyer.entity.Buyer;
import com.auction.buyer.feignclient.BuyerCommonFeignClient;
import com.auction.buyer.repository.BuyerRepository;


import com.auction.buyer.request.BidRequest;
import com.auction.buyer.request.CreateBuyerRequest;
import com.auction.buyer.response.BuyerResponse;
import com.auction.buyer.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


 

@Service
public class BuyerService {
	
	Integer bidNumber = 0;
	@Autowired
	BuyerRepository buyerRepository;
	

	@Autowired
	BuyerCommonFeignClient buyerCommonFeignClient;

	public BuyerResponse createBuyer(CreateBuyerRequest createBuyerRequest) {
		
		Buyer buyer = new Buyer();
		buyer.setFirstName(createBuyerRequest.getFirstName());
		buyer.setLastName(createBuyerRequest.getLastName());
		buyer.setEmail(createBuyerRequest.getEmail());
		buyer.setPhone(createBuyerRequest.getPhone());
		buyer.setProductId(createBuyerRequest.getProductId());
		buyer.setBidamount(createBuyerRequest.getBidamount());
		buyer.setAddressId(createBuyerRequest.getAddressId());		 
		
		buyer = buyerRepository.save(buyer);
		
		BuyerResponse buyerResponse = new BuyerResponse(buyer);
		BidRequest bidRequest = new BidRequest();
		bidRequest.setAmount(buyerResponse.getBidamount());
		bidRequest.setEmail(buyerResponse.getEmail());
		bidRequest.setMobile(buyerResponse.getPhone());
		bidRequest.setName(buyerResponse.getLastName());

		buyerResponse.setProductResponse(buyerCommonFeignClient.addBid2Product(createBuyerRequest.getProductId(), bidRequest));

		buyerResponse.setAddressResponse(buyerCommonFeignClient.getAddressById(buyer.getAddressId()));

		return buyerResponse;
	}

	public BuyerResponse getById(String id) {
	 
		Buyer buyer = buyerRepository.findById(id).get();
		BuyerResponse buyerResponse = new BuyerResponse(buyer);

		buyerResponse.setAddressResponse(buyerCommonFeignClient.getAddressById(buyer.getAddressId()));
		
		
		return buyerResponse;
	}

	public ProductResponse updateBidAmount(String productId, String buyerEmail, BigDecimal newBidAmount) {

		ProductResponse productResponse = buyerCommonFeignClient.updateAmountBid(productId, buyerEmail, newBidAmount);
		return productResponse;
	}

}
