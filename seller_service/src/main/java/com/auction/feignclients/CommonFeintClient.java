package com.auction.feignclients;

import java.util.List;

import com.auction.request.CreateProductRequest;
import com.auction.response.AddressResponse;
import com.auction.response.BidResponse;
import com.auction.response.Product;
import com.auction.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "api-gateway")
public interface CommonFeintClient {
	@PostMapping("/product-service/e-auction/api/v1/product")
	public ProductResponse createProduct(@RequestBody CreateProductRequest createProductRequest);
	
	@DeleteMapping("/product-service/e-auction/api/v1/product/delete/{id}")
	public String deleteProduct(@PathVariable("id") String id); 
	
	@GetMapping("/product-service/e-auction/api/v1/product/getById/{id}")
	public ProductResponse getProductById(@PathVariable("id") String id);

	
	@GetMapping("/bid-producer-service/e-auction/api/v1/bid/getAllBids/{productId}")
	public List<BidResponse> getAllBidsByProductId(@PathVariable String productId);
	
	@GetMapping("/product-service/e-auction/api/v1/product")
	public ResponseEntity<List<Product>> getAllProducts();

	@GetMapping("/address-service/e-auction/api/v1/address/getById/{id}")
	public AddressResponse getAddressById(@PathVariable("id") String id);
	


}
