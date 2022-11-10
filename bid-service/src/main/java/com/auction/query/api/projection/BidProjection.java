package com.auction.query.api.projection;

import com.auction.command.api.data.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BidProjection {
	@Autowired
    private BidRepository bidRepository;

}
