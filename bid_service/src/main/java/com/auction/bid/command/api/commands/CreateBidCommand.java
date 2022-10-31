package com.auction.bid.command.api.commands;

import com.auction.bid.command.api.data.BidEventType;
import lombok.Builder;



import java.math.BigDecimal;



@Builder
public class CreateBidCommand { 
	
	private String bidId;
    private Integer bidEventId;
    private BigDecimal amount;
	private String name;
	private String email;
	private String mobile;
	private String productId;
	private BidEventType bidEventType;
	
	
	public Integer getBidEventId() {
		return bidEventId;
	}
		
	public void setBidEventId(Integer bidEventId) {
		this.bidEventId = bidEventId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}


	public BidEventType getBidEventType() {
		return bidEventType;
	}


	public void setBidEventType(BidEventType bidEventType) {
		this.bidEventType = bidEventType;
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}
	

	
	
 
    
    
}
