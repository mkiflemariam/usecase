package com.auction.bid.util;

import com.auction.bid.dto.ProductRequestDTO;
import com.auction.bid.dto.ProductResponseDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(value = "product", url = "http://localhost:8090")
public interface FeignServiceUtil {

    @PostMapping
    public ProductResponseDTO createProduct(@RequestBody ProductRequestDTO productRequestDTO);
}
