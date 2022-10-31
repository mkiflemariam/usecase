package com.auction.bid.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Product {
	private String productId;	
	private String name;	
	private String shortDescription;
	private String detailDescription;
	private String category;
	private BigDecimal startingPrice;
	private Date bidEndDate;
	private List<String> bids;
	
	
	public Product() {
		bids = new ArrayList<String>();
	}
	
	public List<String> getBids() {
		return bids;
	}
	public void setBids(List<String> bids) {
		
		this.bids=bids;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDetailDescription() {
		return detailDescription;
	}
	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	 
	public Date getBidEndDate() {
		return bidEndDate;
	}
	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}
	public BigDecimal getStartingPrice() {
		return startingPrice;
	}
	public void setStartingPrice(BigDecimal startingPrice) {
		this.startingPrice = startingPrice;
	}	
	

}
