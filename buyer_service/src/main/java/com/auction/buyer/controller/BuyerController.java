package com.auction.buyer.controller;


import com.auction.buyer.dto.BuyerRequestDTO;
import com.auction.buyer.dto.BuyerResponseDTO;
import com.auction.buyer.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @PostMapping
    public ResponseEntity<?> createBuyer(@RequestBody BuyerRequestDTO buyerRequestDTO){
        BuyerResponseDTO buyerResponse = buyerService.createBuyer(buyerRequestDTO);
        return new ResponseEntity<BuyerResponseDTO>(buyerResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBuyerById(@PathVariable int id){
        return new ResponseEntity<BuyerResponseDTO>(buyerService.getBuyerById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllBuyers(){
        List<BuyerResponseDTO> buyerResponseDTOS = buyerService.getAllBuyers();
        return new ResponseEntity<Collection<BuyerResponseDTO>>(buyerService.getAllBuyers(), HttpStatus.OK);
    }
}
