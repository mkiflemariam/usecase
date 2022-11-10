package com.auction.bid.command.api.controller;

import com.auction.bid.api.command.producer.BidEventProducer;
import com.auction.bid.command.api.commands.CreateBidCommand;
import com.auction.bid.command.api.data.Bid;
import com.auction.bid.command.api.data.BidEventType;
import com.auction.bid.response.BidResponse;
import com.auction.bid.service.BidService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/e-auction/api/v1/bid")
@Slf4j
public class BidCommandController {

	@Autowired
	BidService bidService;
		
	@Autowired
	BidEventProducer bidEventProducer;

	
	@PostMapping
	public ResponseEntity<CreateBidCommand> postBid(@RequestBody CreateBidCommand createBidCommand) throws JsonProcessingException {

        createBidCommand.setBidEventType(BidEventType.NEW);
        bidEventProducer.sendBidEvent_Approach2(createBidCommand);

        return ResponseEntity.status(HttpStatus.CREATED).body(createBidCommand);

		
	}
	

	@PutMapping("/{bidId}")
    public ResponseEntity<?> putBidyEvent(@PathVariable String bidId, @RequestBody @Valid CreateBidCommand createBidCommand) throws JsonProcessingException, ExecutionException, InterruptedException {

        if(createBidCommand.getBidEventId()==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please pass the bidEventId");
        }

        createBidCommand.setBidEventType(BidEventType.UPDATE);
        createBidCommand.setBidId(bidId);
        bidEventProducer.sendBidEvent_Approach2(createBidCommand);
        return ResponseEntity.status(HttpStatus.OK).body(createBidCommand);
    }

	
	@PutMapping("/update-bid/{productId}/{buyerEmail}/{newBidAmount}")
	public ResponseEntity<BidResponse> updateBidAmount(@PathVariable String productId,
													   @PathVariable String buyerEmail, @PathVariable BigDecimal newBidAmount) {
		 
		Bid bid = bidService.updateBidAmount(productId, buyerEmail, newBidAmount);
		return new ResponseEntity<>(new BidResponse(bid), HttpStatus.OK); 	
		
	}
	
	@PutMapping("/{buyerEmail}/{newBidAmount}")
	public ResponseEntity<BidResponse> updateBidAmountUsingEmail (@PathVariable String buyerEmail, @PathVariable BigDecimal newBidAmount) {		
		 
		return new ResponseEntity<>(bidService.updateBidAmountUsingEmail(buyerEmail, newBidAmount), HttpStatus.OK); 
	}

	
}

	
	
	

