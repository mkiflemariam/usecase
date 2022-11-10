package com.auction.command.api.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepository extends JpaRepository<Bid, String> {
   List<Bid> findByProductId(String productId);
   Bid findByProductIdAndEmail(String productId, String email);
  Bid findByEmail(String email);
  List<Bid> findAll();
  //public Boolean existByEmail(String email); 
  
}
 

