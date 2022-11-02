package com.auction.product.service;

import com.auction.product.DTO.ProductRequestDTO;
import com.auction.product.DTO.ProductResponse;
import com.auction.product.domain.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ProductAdapter {
    private static int counter = 0;
    public static Product productRequestDtoToProduct(ProductRequestDTO productRequestDTO) {

        Product product = Product.builder()
                .productId("" + counter++)
                .productName(productRequestDTO.getProductName())
                .shortDescription(productRequestDTO.getShortDescription())
                .detailDescription(productRequestDTO.getDetailDescription())
                .category(productRequestDTO.getCategory())
                .startingPrice(productRequestDTO.getStartingPrice())
                .bidEndDate(productRequestDTO.getBidEndDate())
                .bid(productRequestDTO.getBid())
                .build();
        return product;
    }

    public static ProductResponse productToProductRespose(Product product) {

        ProductResponse productResponse = ProductResponse.builder()
                .productName(product.getProductName())
                .shortDescription(product.getShortDescription())
                .detailDescription(product.getDetailDescription())
                .category(product.getCategory())
                .startingPrice(product.getStartingPrice())
                .bidEndDate(product.getBidEndDate())
                .bidIdList(product.getBid())
                .build();
        return productResponse;
    }
}
