package com.auction.service;



import java.util.List;


import com.auction.entity.Seller;
import com.auction.feignclients.CommonFeintClient;
import com.auction.repository.SellerRepository;
import com.auction.request.CreateSellerRequest;
import com.auction.response.Product;
import com.auction.response.ProductResponse;
import com.auction.response.SellerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class SellerService {
	


	@Autowired
	SellerRepository sellerRepository;

	
	@Autowired
	CommonFeintClient commonFeintClient;
	
	@Autowired
	CommonService commonService;

	public SellerResponse createSeller(CreateSellerRequest createSellerRequest) {

		Seller seller = new Seller();
		seller.setFirstName(createSellerRequest.getFirstName());
		seller.setLastName(createSellerRequest.getLastName());
		seller.setEmail(createSellerRequest.getEmail());
		seller.setPhone(createSellerRequest.getPhone());			
		seller.setAddressId(createSellerRequest.getAddressId());
		seller = sellerRepository.save(seller);
		
		SellerResponse sellerResponse = new SellerResponse(seller);

		sellerResponse.setAddressResponse(commonService.getAddressById(seller.getAddressId()));		

		return sellerResponse;
	}
	
	public SellerResponse getById (String id) {
		Seller seller = sellerRepository.findById(id).get();
		SellerResponse sellerResponse = new SellerResponse(seller);
		
		sellerResponse.setAddressResponse(commonService.getAddressById(seller.getAddressId()));		
		
		return sellerResponse;
	}

	public SellerResponse addProductBySeller(CreateSellerRequest createSellerRequest) {
		Seller seller = new Seller();
		seller.setFirstName(createSellerRequest.getFirstName());
		seller.setLastName(createSellerRequest.getLastName());
		seller.setEmail(createSellerRequest.getEmail());
		seller.setPhone(createSellerRequest.getPhone());			
		seller.setAddressId(createSellerRequest.getAddressId());
		seller = sellerRepository.save(seller);		
		SellerResponse sellerResponse = new SellerResponse(seller);
		sellerResponse.setProductResponse(
				commonFeintClient.createProduct(createSellerRequest.getCreateProductRequest()));

		sellerResponse.setAddressResponse(commonService.getAddressById(seller.getAddressId()));		

		return sellerResponse;
	}

	public String deleteProduct(String id) {
		return commonService.deleteProduct(id);		
	}
	public ProductResponse showBids(String productId) {

		ProductResponse productResponse = commonService.getProductById(productId);

		productResponse.setBidsList(commonService.getAllBidsByProductId(productId));

		return productResponse;
	}

	public ResponseEntity<List<Product>> showAllProducts() {
		return commonFeintClient.getAllProducts();
	}

}
