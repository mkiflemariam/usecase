package com.auction.bid.query.api.projection;

import com.auction.bid.command.api.data.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class BidProjection {
	@Autowired
    private BidRepository bidRepository;

//    public ProductProjection(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

//    @QueryHandler
//    public List<BidRestModel> handle(GetBidsQuery getBidsQuery) {
//        List<Bid> bids =
//                bidRepository.findAll();
//
//        List<BidRestModel> bidRestModels =
//                bids.stream()
//                        .map(bid -> BidRestModel
//                                .builder()
//                                .amount(bid.getAmount())
//                                .email(bid.getMail())
//                                .name(bid.getName())
//                                .mobile(bid.getMobile())
//                                .productId(bid.getProductId())
//                                .build())
//                        .collect(Collectors.toList());
//
//        return bidRestModels;
//    }
}
