package com.auction.buyer.controller;

import com.auction.buyer.dto.BuyerRequestDto;
import com.auction.buyer.dto.ProductResponseDto;
import com.auction.buyer.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/e-aution/api/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @PostMapping("/place-bid")
    public ResponseEntity<?> insertBuyer(@RequestBody BuyerRequestDto buyerRequestDto ){

        return new ResponseEntity(buyerService.creatBuyer(buyerRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        return ResponseEntity.ok(buyerService.getBuyId(id));
    }

    @PutMapping("/update-bid/{productId}/{buyerEmail}/{newBidAmount}")
    public ResponseEntity<?> updateBidAmount(@PathVariable String productId, @PathVariable String buyerEmail, @PathVariable String newBidAmount ){
        return new ResponseEntity<ProductResponseDto>(buyerService.updateBidAmount(productId,buyerEmail,newBidAmount), HttpStatus.OK);
    }
}
