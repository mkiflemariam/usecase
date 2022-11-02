package com.auction.product.service;

import com.auction.product.DTO.ProductRequestDTO;
import com.auction.product.DTO.ProductResponse;
import com.auction.product.domain.Product;
import com.auction.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequestDTO productRequestDTO) {
        Product product = ProductAdapter.productRequestDtoToProduct(productRequestDTO);

        Product product1 = productRepository.save(product);
        System.out.println(product1);
        ProductResponse productResponse = ProductAdapter.productToProductRespose(product);
        System.out.println(productResponse);

        return productResponse;
    }

    public ProductResponse getProductById(int id) {
        ProductResponse productResponse=ProductAdapter.productToProductRespose(productRepository.findById(id).get());
        return productResponse;
    }
}
