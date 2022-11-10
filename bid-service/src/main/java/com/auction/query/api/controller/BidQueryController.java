package com.auction.query.api.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.auction.response.BidResponse;
import com.auction.service.BidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.command.api.data.Bid;


@RestController
@RequestMapping("/e-auction/api/v1/bids")
public class BidQueryController {
	Logger logger = LoggerFactory.getLogger(BidQueryController.class);
	@Autowired
    BidService bidService;
	

		
	
	//@GetMapping("/getAllBids/{productId}")
	//public ResponseEntity<List<BidResponse>> getAllBidsByProductId(@PathVariable String productId){
	@GetMapping("/getAllBids/{productId}")
	public ResponseEntity<List<BidResponse>> getAllBidsByProductId(@PathVariable String productId){
		logger.info("Test Inside bid before reading bidList");
		List<Bid> bidList = bidService.getAllBidsByProductId(productId); 
		logger.info("after");
		logger.info("BidList"+bidList);
		if(bidList.isEmpty() ) {
			logger.info("inside empty checking");
			return ResponseEntity.notFound().build();
		}
		logger.info("Test checking  bidList empty");
		List<BidResponse> bidResponseList = new ArrayList<BidResponse>();
		bidList.stream().filter(f->f!=null).sorted(Comparator.comparing(Bid::getAmount).reversed())
		.forEach(bid->{bidResponseList.add(new BidResponse(bid));});
		logger.info("Test checking  bidList filtering");
		return ResponseEntity.ok(bidResponseList);
	}
	@GetMapping("/{email}")
	public Boolean emailExist(@PathVariable String email){
		logger.info("10");
		return bidService.emailExist(email);		
		
	}
	@GetMapping("/getAllBids")
	public ResponseEntity<List<BidResponse>> getAllBids(){
		logger.info("Befor retrieving");
		List<Bid> bidList = bidService.getAllBids(); 
		logger.info("After retrieving");
		if(bidList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}		
		List<BidResponse> bidResponseList = new ArrayList<BidResponse>();
		
		bidList.stream().forEach(bid->{bidResponseList.add(new BidResponse(bid));});
		return ResponseEntity.ok(bidResponseList);
	}
	
	@GetMapping("/hello/{bidId}")
	public ResponseEntity<BidResponse> getBidById(@PathVariable String bidId){
		Bid bid = bidService.getBidById(bidId);
		return ResponseEntity.ok(new BidResponse(bid));
 
	}

	
}
	

	
	

