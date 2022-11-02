package com.auction.buyer.service;

import com.auction.buyer.domain.Buyer;
import com.auction.buyer.dto.BuyerRequestDTO;
import com.auction.buyer.dto.BuyerResponseDTO;
import com.auction.buyer.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
    public class BuyerService {

        @Autowired
        BuyerRepository buyerRepository;

        public BuyerResponseDTO createBuyer(BuyerRequestDTO buyerRequestDTO) {
            Buyer buyer = BuyerAdapter.buyerRequestDtoToBuyer(buyerRequestDTO);
            BuyerResponseDTO buyerResponseDTO = BuyerAdapter.buyerToBuyerResponseDto(buyerRepository.save(buyer));
            //feign client
            return buyerResponseDTO;
        }
    }

