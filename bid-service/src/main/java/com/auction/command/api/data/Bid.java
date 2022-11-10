package com.auction.command.api.data;







import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
//@Document(collection="bid2")
@Entity
public class Bid {
	
	@Id
	private String bidId;	
	private BigDecimal amount;
	private String name;
	private String email;
	private String mobile;
	private String productId;	
	
	public String getBidId() {
		return bidId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public void setBidId(String bidId) {
		this.bidId = bidId;
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

}
