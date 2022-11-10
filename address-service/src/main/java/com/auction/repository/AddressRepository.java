package com.auction.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auction.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

}
