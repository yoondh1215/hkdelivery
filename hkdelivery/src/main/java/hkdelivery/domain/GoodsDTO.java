package hkdelivery.domain;

import org.apache.ibatis.type.Alias;

@Alias("goods")
public class GoodsDTO {

	String goodsNum;
	String shopNum;
	String goodsName;
	String goodsContent;
	String goodsMain;
	String goodsMainOrg;
	String goodsImage;
	String goodsImageOrg;
	Integer goodsPrice;
	Integer deliveryCost;
	
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getShopNum() {
		return shopNum;
	}
	public void setShopNum(String shopNum) {
		this.shopNum = shopNum;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	public String getGoodsMain() {
		return goodsMain;
	}
	public void setGoodsMain(String goodsMain) {
		this.goodsMain = goodsMain;
	}
	public String getGoodsMainOrg() {
		return goodsMainOrg;
	}
	public void setGoodsMainOrg(String goodsMainOrg) {
		this.goodsMainOrg = goodsMainOrg;
	}
	public String getGoodsImage() {
		return goodsImage;
	}
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	public String getGoodsImageOrg() {
		return goodsImageOrg;
	}
	public void setGoodsImageOrg(String goodsImageOrg) {
		this.goodsImageOrg = goodsImageOrg;
	}
	public Integer getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Integer goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public Integer getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(Integer deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	
	
}
