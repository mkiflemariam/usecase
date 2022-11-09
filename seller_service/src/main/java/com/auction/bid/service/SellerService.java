package com.auction.bid.service;


import com.auction.bid.dto.ProductRequestDTO;
import com.auction.bid.dto.ProductResponseDTO;
import com.auction.bid.dto.SellerRequestDTO;
import com.auction.bid.dto.SellerResponseDTO;
import com.auction.bid.entity.Seller;
import com.auction.bid.repository.SellerRepository;
import com.auction.bid.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class SellerService {


	@Autowired
	SellerRepository sellerRepository;

//	@Autowired
//	FeignServiceUtil feignServiceUtil;

	public SellerResponseDTO createSeller(SellerRequestDTO sellerRequestDTO) {
		Seller seller = SellerAdapter.sellerRequestDtoToSeller(sellerRequestDTO);
		System.out.println(seller);
		SellerResponseDTO sellerResponseDTO = SellerAdapter.sellerToSellerResponseDto(sellerRepository.save(seller));
		return sellerResponseDTO;
	}
	
	public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO){
		return null;
	}

	public SellerResponseDTO getSellerById(int id) {
		SellerResponseDTO sellerResponseDTO =SellerAdapter.sellerToSellerResponseDto(sellerRepository.findById(id).get());
		return sellerResponseDTO;
	}


	public Collection<SellerResponseDTO> findAllSellers() {
		List<Seller> sellerList = sellerRepository.findAll();
		List<SellerResponseDTO> sellerResponseDTOS = new ArrayList<>();
		if(sellerList!=null){
			for (Seller s: sellerList){
				sellerResponseDTOS.add(SellerAdapter.sellerToSellerResponseDto(s));
			}
		}
		return sellerResponseDTOS;
	}
}
