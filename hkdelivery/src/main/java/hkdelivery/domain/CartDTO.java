package hkdelivery.domain;

import org.apache.ibatis.type.Alias;

@Alias("cart")
public class CartDTO {

	String memberNum;
	String goodsNum;
	Integer cartQty;
	
	String[] goodsNums;
	
	
	public String[] getGoodsNums() {
		return goodsNums;
	}
	public void setGoodsNums(String[] goodsNums) {
		this.goodsNums = goodsNums;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Integer getCartQty() {
		return cartQty;
	}
	public void setCartQty(Integer cartQty) {
		this.cartQty = cartQty;
	}
	
	
}
