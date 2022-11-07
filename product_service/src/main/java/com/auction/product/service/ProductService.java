package com.auction.product.service;

import com.auction.product.DTO.ProductRequestDTO;
import com.auction.product.DTO.ProductResponseDTO;
import com.auction.product.domain.Product;
import com.auction.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = ProductAdapter.productRequestDtoToProduct(productRequestDTO);

        Product product1 = productRepository.save(product);
        System.out.println(product1);
        ProductResponseDTO productResponseDTO = ProductAdapter.productToProductRespose(product);
        System.out.println(productResponseDTO);

        return productResponseDTO;
    }

    public ProductResponseDTO getProductById(int id) {
        ProductResponseDTO productResponseDTO =ProductAdapter.productToProductRespose(productRepository.findById(id).get());
        return productResponseDTO;
    }

    public List<ProductResponseDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDTO> productResponsDTOS = new ArrayList<>();
        if(productList.isEmpty()){

        }
        for(Product p : productList){
            productResponsDTOS.add(ProductAdapter.productToProductRespose(p));
        }
        return productResponsDTOS;
    }
}
