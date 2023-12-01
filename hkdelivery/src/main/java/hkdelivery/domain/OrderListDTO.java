package hkdelivery.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("orderList")
public class OrderListDTO {

	String purhaseNum;
	String purchaseName;
	Date purchaseDate;
	Integer totalprice;
	String confirmnumber;
	public String getPurhaseNum() {
		return purhaseNum;
	}
	public void setPurhaseNum(String purhaseNum) {
		this.purhaseNum = purhaseNum;
	}
	public String getPurchaseName() {
		return purchaseName;
	}
	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Integer getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	public String getConfirmnumber() {
		return confirmnumber;
	}
	public void setConfirmnumber(String confirmnumber) {
		this.confirmnumber = confirmnumber;
	}
	
	
}
