package com.auction.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateProductRequest {
	@NotNull(message="Product name should not be null")
	@Size(min=5, max=30, message= "Product name should be between 5 and 30")
	private String name;	
	private String shortDescription;
	private String detailDescription;
	private String category;
	
	private BigDecimal startingPrice;
	@Future
	private Date bidEndDate;
	private List<String> bids;	
	
	public List<String> getBids() {
		return bids;
	}
	public void setBids(List<String> bids) {
		this.bids = bids;
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
