package com.auction.product.service;

import com.auction.product.DTO.ProductRequestDTO;
import com.auction.product.DTO.ProductResponse;
import com.auction.product.domain.Product;
import com.auction.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequestDTO productRequestDTO) {
        Product product = ProductAdapter.productRequestDtoToProduct(productRequestDTO);
        ProductResponse productResponse = ProductAdapter.productToProductRespose(productRepository.save(product));
        return productResponse;
    }
}
