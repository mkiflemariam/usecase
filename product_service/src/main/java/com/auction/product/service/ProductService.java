package com.auction.product.service;

import com.auction.product.DTO.ProductRequestDTO;
import com.auction.product.DTO.ProductResponse;
import com.auction.product.domain.Product;
import com.auction.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

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

    public List<ProductResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        if(productList.isEmpty()){

        }
        for(Product p : productList){
            productResponses.add(ProductAdapter.productToProductRespose(p));
        }
        return productResponses;
    }
}
