package com.auction.buyer.service;

import com.auction.buyer.domain.Buyer;
import com.auction.buyer.dto.BuyerRequestDTO;
import com.auction.buyer.dto.BuyerResponseDTO;
import com.auction.buyer.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
    public class BuyerService {

        @Autowired
        BuyerRepository buyerRepository;

        public BuyerResponseDTO createBuyer(BuyerRequestDTO buyerRequestDTO) {
            Buyer buyer = BuyerAdapter.buyerRequestDtoToBuyer(buyerRequestDTO);
            System.out.println(buyer);
            BuyerResponseDTO buyerResponseDTO = BuyerAdapter.buyerToBuyerResponseDto(buyerRepository.save(buyer));
            //feign client
            return buyerResponseDTO;
        }

    public BuyerResponseDTO getBuyerById(int id) {
        Buyer buyer = buyerRepository.findById(id).get();
        BuyerResponseDTO buyerResponseDTO = BuyerAdapter.buyerToBuyerResponseDto(buyer);
        return buyerResponseDTO;
    }

    public List<BuyerResponseDTO> getAllBuyers() {
            List<Buyer> buyers = buyerRepository.findAll();
            List<BuyerResponseDTO> buyerResponseDTOS = new ArrayList<>();
            if(buyers != null){
                for(Buyer b:buyers){
                    buyerResponseDTOS.add(BuyerAdapter.buyerToBuyerResponseDto(b));
                }
            }
        return buyerResponseDTOS;
    }
}

