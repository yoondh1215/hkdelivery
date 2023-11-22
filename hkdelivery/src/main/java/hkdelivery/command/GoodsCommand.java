package hkdelivery.command;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class GoodsCommand {

	//유효성검사를 위해 @validated 부여
	String goodsNum;
	String shopNum;
	@NotEmpty(message = "상품 이름을 입력하세요")
	String goodsName;
	@NotEmpty(message = "상품 설명을 입력하세요")
	String goodsContent;
	String goodsMain;
	String goodsMainOrg;
	String goodsImage;
	String goodsImageOrg;
	@NotNull(message = "가격을 입력하세요")
	Integer goodsPrice;
	@NotNull(message = "배송비를 입력하세요")
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
