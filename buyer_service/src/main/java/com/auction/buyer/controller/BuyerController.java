package com.auction.buyer.controller;


import com.auction.buyer.request.CreateBuyerRequest;
import com.auction.buyer.response.BuyerResponse;
import com.auction.buyer.response.ProductResponse;
import com.auction.buyer.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/e-aution/api/buyer")
public class BuyerController {

//    @Autowired
//    private BuyerService buyerService;
//
//    @PostMapping("/place-bid")
//    public ResponseEntity<?> insertBuyer(@RequestBody BuyerRequestDto buyerRequestDto ){
//
//        return new ResponseEntity(buyerService.creatBuyer(buyerRequestDto), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getById(@PathVariable String id){
//        return ResponseEntity.ok(buyerService.getBuyId(id));
//    }
//
//    @PutMapping("/update-bid/{productId}/{buyerEmail}/{newBidAmount}")
//    public ResponseEntity<?> updateBidAmount(@PathVariable String productId, @PathVariable String buyerEmail, @PathVariable BigDecimal newBidAmount ){
//        return new ResponseEntity<ProductResponseDto>(buyerService.updateBidAmount(productId,buyerEmail,newBidAmount), HttpStatus.OK);
//    }


    @Autowired
    BuyerService buyerService;


    @PostMapping("/place-bid")
    public ResponseEntity<?> createBuyer(@Valid @RequestBody CreateBuyerRequest createBuyerRequest) {

        return new ResponseEntity<BuyerResponse>(buyerService.createBuyer(createBuyerRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuyerResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(buyerService.getById(id));
    }


    @PutMapping("/update-bid/{productId}/{buyerEmail}/{newBidAmount}")
    public ResponseEntity<?> updateBidAmount(@PathVariable String productId,
                                                           @PathVariable String buyerEmail, @PathVariable BigDecimal newBidAmount) {
        return new ResponseEntity<ProductResponse>(buyerService.updateBidAmount(productId, buyerEmail, newBidAmount), HttpStatus.OK);

    }
}
