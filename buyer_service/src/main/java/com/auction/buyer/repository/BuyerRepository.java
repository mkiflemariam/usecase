package com.auction.buyer.repository;

import com.auction.buyer.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String> {

}
