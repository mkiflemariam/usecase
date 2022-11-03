package com.auction.bid.service;


import com.auction.bid.dto.SellerRequestDTO;
import com.auction.bid.dto.SellerResponseDTO;
import com.auction.bid.entity.Seller;
import com.auction.bid.repository.SellerRepository;
import com.auction.bid.request.CreateSellerRequest;
import com.auction.bid.response.Product;
import com.auction.bid.response.SellerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class SellerService {


	@Autowired
	SellerRepository sellerRepository;

	public SellerResponseDTO createSeller(SellerRequestDTO sellerRequestDTO) {
		Seller seller = SellerAdapter.sellerRequestDtoToSeller(sellerRequestDTO);
		SellerResponseDTO sellerResponseDTO = SellerAdapter.sellerToSellerResponseDto(sellerRepository.save(seller));
		return sellerResponseDTO;
	}
	


	public SellerResponseDTO getSellerById(String id) {
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
