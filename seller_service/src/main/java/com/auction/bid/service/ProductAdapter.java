package com.auction.bid.service;


import com.auction.bid.dto.ProductRequestDTO;
import com.auction.bid.dto.ProductResponseDTO;
import com.auction.bid.entity.Product;

public class ProductAdapter {
    private static int counter = 0;
    public static Product productRequestDtoToProduct(ProductRequestDTO productRequestDTO) {

        Product product = Product.builder()
                .productName(productRequestDTO.getProductName())
                .shortDescription(productRequestDTO.getShortDescription())
                .detailDescription(productRequestDTO.getDetailDescription())
                .category(productRequestDTO.getCategory())
                .startingPrice(productRequestDTO.getBidAmount())
                .bidEndDate(productRequestDTO.getBidEndDate())
                .bid(productRequestDTO.getBid())
                .build();
        return product;
    }

    public static ProductResponseDTO productToProductRespose(Product product) {

        ProductResponseDTO productResponseDTO = ProductResponseDTO.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .shortDescription(product.getShortDescription())
                .detailDescription(product.getDetailDescription())
                .category(product.getCategory())
                .startingPrice(product.getStartingPrice())
                .bidEndDate(product.getBidEndDate())
                .bidIdList(product.getBid())
                .build();

        return productResponseDTO;
    }
}
