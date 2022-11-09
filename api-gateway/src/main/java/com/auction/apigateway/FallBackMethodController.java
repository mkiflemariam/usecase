package com.auction.apigateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/sellerServiceFallBack")
    public String sellerServiceFallBackMethod() {
        return "Seller Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/productServiceFallBack")
    public String productServiceFallBackMethod() {
        return "Product Service is taking longer than Expected." +
                " Please try again later";
    }
}