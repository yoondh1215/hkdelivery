package hkdelivery.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("shop")
public class ShopDTO {

	String shopNum;
	String shopName;
	String businessRegiNum;
	String contractNum;
	String shopId;
	String shopPw;
	String shopAddr;
	String shopAddrDetail;
	String shopPost;
	String shopPhone;
	Date shopRegiDate;
	
	public String getShopNum() {
		return shopNum;
	}
	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getBusinessRegiNum() {
		return businessRegiNum;
	}
	public void setBusinessRegiNum(String businessRegiNum) {
		this.businessRegiNum = businessRegiNum;
	}
	public String getContractNum() {
		return contractNum;
	}
	public void setContractNum(String contractNum) {
		this.contractNum = contractNum;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getShopPw() {
		return shopPw;
	}
	public void setShopPw(String shopPw) {
		this.shopPw = shopPw;
	}
	public String getShopAddr() {
		return shopAddr;
	}
	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}
	public String getShopAddrDetail() {
		return shopAddrDetail;
	}
	public void setShopAddrDetail(String shopAddrDetail) {
		this.shopAddrDetail = shopAddrDetail;
	}
	public String getShopPost() {
		return shopPost;
	}
	public void setShopPost(String shopPost) {
		this.shopPost = shopPost;
	}
	public String getShopPhone() {
		return shopPhone;
	}
	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}
	public Date getShopRegiDate() {
		return shopRegiDate;
	}
	public void setShopRegiDate(Date shopRegiDate) {
		this.shopRegiDate = shopRegiDate;
	}
	
	
	
	
}
