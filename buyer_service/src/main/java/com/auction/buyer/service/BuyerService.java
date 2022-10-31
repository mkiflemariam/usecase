package com.auction.buyer.service;

import com.auction.buyer.feign.BuyerFeignClient;
import com.auction.buyer.domain.Buyer;

import com.auction.buyer.repository.BuyerRepository;
import com.auction.buyer.request.BidRequest;
import com.auction.buyer.request.CreateBuyerRequest;
import com.auction.buyer.response.BuyerResponse;
import com.auction.buyer.response.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;



//    @Autowired
//    private BuyerRepository buyerRepository;

//
//    @Autowired
//    BuyerFeignClient buyerFeignCLient;
//
//    public BuyerResponseDto creatBuyer(BuyerRequestDto buyerRequestDto) {
//        Buyer newBuyer =  Buyer.builder()
//                .firstName(buyerRequestDto.getFirstName())
//                .lastName(buyerRequestDto.getLastName())
//                .email(buyerRequestDto.getEmail())
//                .phone(buyerRequestDto.getPhone())
//                .productId(buyerRequestDto.getProductId())
//                .bidAmount(buyerRequestDto.getBidAmount())
//                .addressId(buyerRequestDto.getAddressId())
//                .build();
//
//        Buyer buyer = buyerRepository.save(newBuyer);
//        BuyerResponseDto buyerResponseDto = new BuyerResponseDto(buyer);
//        BidRequestDto bidRequestDto = BidRequestDto.builder()
//                .amount(buyerResponseDto.getBidAmount())
//                .email(buyerResponseDto.getEmail())
//                .phone(buyerResponseDto.getPhone())
//                .name(buyerResponseDto.getFirstName())
//                .build();
//
//        buyerResponseDto.setProductResponseDto(buyerFeignCLient.addBidToProduct(buyerRequestDto.getProductId(), bidRequestDto));
//        buyerResponseDto.setAddressResponseDto(buyerFeignCLient.getAddressById(buyer.getAddressId()));
//
//        return buyerResponseDto;
//    }
//
//    public BuyerResponseDto getBuyId(String id) {
//        Buyer buyer = buyerRepository.findById(id).get();
//        BuyerResponseDto buyerResponseDto = new BuyerResponseDto(buyer);
//
//        buyerResponseDto.setAddressResponseDto(buyerFeignCLient.getAddressById(buyer.getAddressId()));
//        return buyerResponseDto;
//    }
//
//    public ProductResponseDto updateBidAmount(String productId, String buyerEmail, BigDecimal newBidAmount) {
//
//        ProductResponseDto productResponseDto = buyerFeignCLient.updateAmountBid(productId, buyerEmail, newBidAmount);
//
//        return productResponseDto;
//    }

    @Service
    public class BuyerService {

        Logger logger = LoggerFactory.getLogger(BuyerService.class);
        Integer bidNumber = 0;
        @Autowired
        BuyerRepository buyerRepository;

        @Autowired
        BuyerFeignClient buyerFeignClient;

        public BuyerResponse createBuyer(CreateBuyerRequest createBuyerRequest) {

            Buyer buyer = new Buyer();
            buyer.setFirstName(createBuyerRequest.getFirstName());
            buyer.setLastName(createBuyerRequest.getLastName());
            buyer.setEmail(createBuyerRequest.getEmail());
            buyer.setPhone(createBuyerRequest.getPhone());
            buyer.setProductId(createBuyerRequest.getProductId());
            buyer.setBidAmount(createBuyerRequest.getBidamount());
            buyer.setAddressId(createBuyerRequest.getAddressId());

            buyer = buyerRepository.save(buyer);

            BuyerResponse buyerResponse = new BuyerResponse(buyer);
            BidRequest bidRequest = new BidRequest();
            bidRequest.setAmount(buyerResponse.getBidamount());
            bidRequest.setEmail(buyerResponse.getEmail());
            bidRequest.setMobile(buyerResponse.getPhone());
            bidRequest.setName(buyerResponse.getLastName());
            
            logger.info("a");
            //buyerResponse.setProductResponse(productFeignClient.addBid2Product(createBuyerRequest.getProductId(), bidRequest));
            buyerResponse.setProductResponse(buyerFeignClient.addBidToProduct(createBuyerRequest.getProductId(), bidRequest));

            logger.info("3");
            //buyerResponse.setAddressResponse(addressFeignClient.getById(buyer.getAddressId()));
            buyerResponse.setAddressResponse(buyerFeignClient.getAddressById(buyer.getAddressId()));

            logger.info("4");
            return buyerResponse;
        }

        public BuyerResponse getById(String id) {

            Buyer buyer = buyerRepository.findById(id).get();
            BuyerResponse buyerResponse = new BuyerResponse(buyer);

            //buyerResponse.setAddressResponse(addressFeignClient.getById(buyer.getAddressId()));
            buyerResponse.setAddressResponse(buyerFeignClient.getAddressById(buyer.getAddressId()));


            return buyerResponse;
        }

        public ProductResponse updateBidAmount(String productId, String buyerEmail, BigDecimal newBidAmount) {

            ProductResponse productResponse = buyerFeignClient.updateAmountBid(productId, buyerEmail, newBidAmount);
            return productResponse;
        }

    }

