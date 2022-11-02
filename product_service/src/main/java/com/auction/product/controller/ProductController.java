package com.auction.product.controller;

import com.auction.product.DTO.ProductRequestDTO;
import com.auction.product.DTO.ProductResponse;
import com.auction.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDTO productRequestDTO){

        ProductResponse product = productService.createProduct(productRequestDTO);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

}
