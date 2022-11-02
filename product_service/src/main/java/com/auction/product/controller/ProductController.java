package com.auction.product.controller;

import com.auction.product.DTO.ProductRequestDTO;
import com.auction.product.DTO.ProductResponse;
import com.auction.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequestDTO productRequestDTO){
        ProductResponse productResponse = productService.createProduct(productRequestDTO);
        return new ResponseEntity<ProductResponse>(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id){
        return new ResponseEntity<ProductResponse>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?>  getAllProducts(){
        List<ProductResponse> productResponses = productService.getAllProducts();

        return new ResponseEntity<Collection<ProductResponse>>(productResponses, HttpStatus.OK);
    }



}
