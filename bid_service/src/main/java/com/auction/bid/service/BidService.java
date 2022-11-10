package com.auction.bid.service;

 

import java.math.BigDecimal;


import com.auction.bid.command.api.data.Bid;
import com.auction.bid.command.api.data.BidRepository;
import com.auction.bid.request.BidRequest;
import com.auction.bid.response.BidResponse;
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service; 


@Service
public class BidService {

	@Autowired
	BidRepository bidRepository;

	@SuppressWarnings("unchecked")
	public BidResponse addBid(String productId, BidRequest bidRequest) {
		//List<Bid> lst = getAllBids();

		Bid bid = new Bid();
		if(getAllBids()==null) {
			
			bid.setAmount(bidRequest.getAmount());
			bid.setName(bidRequest.getName());		
			bid.setEmail(bidRequest.getEmail());
			bid.setMobile(bidRequest.getMobile());
			bid.setProductId(productId);
			bid = bidRepository.save(bid);

			//return bidResponse;
		}
		else {
			//List<Bid> bids = bidRepository.findAll();
			long count = getAllBids().stream().filter(f->f.getEmail().equalsIgnoreCase(bidRequest.getEmail())).count();
				
			if(count == 0){
				logger.info("ff");
				bid.setAmount(bidRequest.getAmount());
				bid.setName(bidRequest.getName());		
				bid.setEmail(bidRequest.getEmail());
				bid.setMobile(bidRequest.getMobile());
				bid.setProductId(productId);
				
				bid = bidRepository.save(bid);
				//BidResponse bidResponse = new BidResponse(bid);	
				logger.info("Second bid created");
				//return bidResponse;	
				
				}
			else {
				logger.info("can't add another bid using this email, already bid with this email");
				
				 new ResourceNotFoundException("can't add another bid using this email, already bid with this email", bidRequest.getEmail(), 0);
				//	
				}

		}
		return new BidResponse(bid);	
				
					
		
	}

	public List<Bid> getAllBids() {
		logger.info("Before Bid retrieving in service layer");
		
		return bidRepository.findAll();
	}

	public List<Bid> getAllBidsByProductId(String productId) {
		
//		 List<Bid> bid =bidRepository.findAll();
//		 if(bid!=null) {
//			 return null;
//		 }
//		 List<Bid> bidsOfProduct = new ArrayList<>();
//		bid.stream().filter(f->f.getProductId().equalsIgnoreCase(productId)).forEach(e->bidsOfProduct.add(e));
//		return bidsOfProduct;
		return bidRepository.findByProductId(productId);
	}

	public Bid updateBidAmount(String productId, String buyerEmail, BigDecimal newBidAmount) {		
		 
		Bid bid = bidRepository.findByProductIdAndEmail(productId, buyerEmail);
		bid.setAmount(newBidAmount);	
	 
		return bidRepository.save(bid);
	}

	public Bid getByEmail(String email) {
		logger.info("11");
		//Bid bid = bidRepository.findByEmail(email);
		logger.info("12");
		//BidResponse bidResponse = new BidResponse(bid);		
		return null;
	}
	public Boolean emailExist(String email) {
//		logger.info("10.1");
//		Bid bid = bidRepository.findByEmail(email);
//		logger.info("10.2");
//		if(bid.getEmail().equals(email)) {
//			return true;
//		}
//		else {
//		return false;
//		}		
		return null;
	}
	public BidResponse updateBidAmountUsingEmail(String email,BigDecimal newBidAmount) {
		
		long count = getAllBids().stream().filter(f->f.getEmail().equalsIgnoreCase(email)).count();
		if(count == 0) {
			logger.info("No bid using the email: "+email);
			return null;
		}
		else {
			 
			Bid bid = bidRepository.findByEmail(email);			
			bid.setAmount(newBidAmount);
			bid = bidRepository.save(bid);
			BidResponse bidResponse = new BidResponse(bid);
			return bidResponse;
		}
	}

	public Bid getBidById(String bidId) {
		
		Bid bid = bidRepository.findById(bidId).orElseThrow(()->new ResourceNotFoundException("Product", "id", 0));
		return bid;
	}
	
		
	
	

}
