package hkdelivery.domain;

import org.apache.ibatis.type.Alias;

@Alias("purchaseList")
public class PurchaseListDTO {

	String purchaseNum;
	String goodsNum;
	Integer purchaseQty;
	Integer totalPrice;
	
	//db엔 없지만 여기엔 필요해서 추가
	String memberNum;
	String[] goodsNums;

	public String[] getGoodsNums() {
		return goodsNums;
	}

	public void setGoodsNums(String[] goodsNums) {
		this.goodsNums = goodsNums;
	}

	public String getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

	public Integer getPurchaseQty() {
		return purchaseQty;
	}

	public void setPurchaseQty(Integer purchaseQty) {
		this.purchaseQty = purchaseQty;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	
	
	
}
