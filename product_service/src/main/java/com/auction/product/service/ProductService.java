package com.auction.product.service;

import com.auction.product.domain.Product;
import com.auction.product.exception.ResourceNotFoundException;
import com.auction.product.openfeignclient.BidFeignClient;
import com.auction.product.repository.ProductRepository;
import com.auction.product.request.BidRequest;
import com.auction.product.request.CreateProductRequest;
import com.auction.product.response.BidResponse;
import com.auction.product.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service

public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BidFeignClient bidFeignClient;

    public ProductResponse createProduct(CreateProductRequest createProductRequest) {
        Product product = new Product();
        product.setProductName(createProductRequest.getName());
        product.setShortDescription(createProductRequest.getShortDescription());
        product.setDetailDescription(createProductRequest.getDetailDescription());
        product.setCategory(createProductRequest.getCategory());
        product.setBidEndDate(createProductRequest.getBidEndDate()); //exception
        product.setStartingPrice(createProductRequest.getStartingPrice());

        product = productRepository.save(product);

        ProductResponse productResponse = new ProductResponse(product);

        return productResponse;
    }

    public ProductResponse getById(String id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "id", 0));
        ProductResponse productResponse = new ProductResponse(product);

        return productResponse;

    }
    public Product findById(String id) {
        Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product", "id", 0));

        return product;

    }



    public void deleteProduct(String id) {

        productRepository.deleteById(id);

    }
    public ProductResponse addBidToProduct(String productId, BidRequest bidRequest) {

        BidResponse bidResponse = bidFeignClient.addBid(productId, bidRequest);
        bidResponse = bidFeignClient.searchBidByEmail(bidResponse.getEmail());

        if( productRepository.findById(productId).isPresent())  {

            Product product = productRepository.findById(productId).get();


            if(getById(productId).getBidEndDate().before(new Date())) {
                new ResourceNotFoundException("Its Bid date is over", productId, 0);
            }


            if(bidResponse!=null) {
                product.setBid(bidResponse.getBidId());
            }

            product = productRepository.save(product);

            ProductResponse productResponse = new ProductResponse(product);

            productResponse.setBidResponse(bidResponse);
            return productResponse;

        }
        else {
            new ResourceNotFoundException("Product Id is not found",productId , 0);
            return null;

        }


    }

    public ProductResponse updateBidAmount(String productId, String buyerEmail, BigDecimal newBidAmount) {
        BidResponse bidResponse = new BidResponse();

        if( !productRepository.findById(productId).isPresent())  {
            Product product = productRepository.findById(productId).get();
            if(!product.getBid().isEmpty()) {
                bidResponse = bidFeignClient.updateBidAmountUsingEmail(productId, buyerEmail, newBidAmount);
                bidResponse = bidFeignClient.searchBidByEmail(bidResponse.getEmail());

            }
            ProductResponse productResponse = new ProductResponse(product);
            productResponse.setBidResponse(bidResponse); //setBid(bidResponse);
            return productResponse;
        }
        else {
            return null;
        }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}


//    @Autowired
//    ProductRepository productRepository;
//
//    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
//        Product product = ProductAdapter.productRequestDtoToProduct(productRequestDTO);
//
//        Product product1 = productRepository.save(product);
//        System.out.println(product1);
//        ProductResponseDTO productResponseDTO = ProductAdapter.productToProductRespose(product);
//        System.out.println(productResponseDTO);
//
//        return productResponseDTO;
//    }
//
//    public ProductResponseDTO getProductById(String id) {
//        ProductResponseDTO productResponseDTO =ProductAdapter.productToProductRespose(productRepository.findById(id).get());
//        return productResponseDTO;
//    }
//
//    public List<ProductResponseDTO> getAllProducts() {
//        List<Product> productList = productRepository.findAll();
//        List<ProductResponseDTO> productResponsDTOS = new ArrayList<>();
//        if(productList.isEmpty()){
//
//        }
//        for(Product p : productList){
//            productResponsDTOS.add(ProductAdapter.productToProductRespose(p));
//        }
//        return productResponsDTOS;
//    }
//}
