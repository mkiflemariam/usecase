package com.auction.bid.command.api.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, String> {
//  public List<Bid> findByProductId(String productId);
//  public Bid findByProductIdAndEmail(String productId, String email);
//  public Bid findByEmail(String email);
//  public List<Bid> findAll();

  
}
 

