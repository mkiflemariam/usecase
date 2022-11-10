package com.auction.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.auction.entity.Product;
import com.auction.exception.ResourceNotFoundException;
import com.auction.openfeignclient.BidFeignClient;
import com.auction.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auction.repository.ProductRepository;
import com.auction.request.BidRequest;
import com.auction.response.BidResponse;
import com.auction.response.ProductResponse;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
    BidFeignClient bidFeignClient;

	public ProductResponse createProduct(CreateProductRequest createProductRequest) {
		Product product = new Product();
		product.setName(createProductRequest.getName());
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

			
			if(product.getBidEndDate().before(new Date())) {
				 new ResourceNotFoundException("Its Bid date is over", productId, 0);
			}


			if(bidResponse!=null) {
				product.setBids(bidResponse.getBidId());
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
	 
		if( productRepository.findById(productId).isPresent())  {
			Product product = productRepository.findById(productId).get();			 
			if(!product.getBids().isEmpty()) {
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
