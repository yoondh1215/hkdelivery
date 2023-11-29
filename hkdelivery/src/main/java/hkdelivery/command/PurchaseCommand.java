package hkdelivery.command;

public class PurchaseCommand {

	Integer sumTotalPrice;
	Integer sumDeliveryCost;
	Integer sumPrice;
	String goodsNums;
	String deliveryName;
	String deliveryAddr;
	String deliveryAddrDetail;
	Integer deliveryPost;
	String deliveryPhone;
	String message;
	
	
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public Integer getSumTotalPrice() {
		return sumTotalPrice;
	}
	public void setSumTotalPrice(Integer sumTotalPrice) {
		this.sumTotalPrice = sumTotalPrice;
	}
	public Integer getSumDeliveryCost() {
		return sumDeliveryCost;
	}
	public void setSumDeliveryCost(Integer sumDeliveryCost) {
		this.sumDeliveryCost = sumDeliveryCost;
	}
	public Integer getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(Integer sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getGoodsNums() {
		return goodsNums;
	}
	public void setGoodsNums(String goodsNums) {
		this.goodsNums = goodsNums;
	}
	
	public String getDeliveryAddr() {
		return deliveryAddr;
	}
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}
	public String getDeliveryAddrDetail() {
		return deliveryAddrDetail;
	}
	public void setDeliveryAddrDetail(String deliveryAddrDetail) {
		this.deliveryAddrDetail = deliveryAddrDetail;
	}
	
	public Integer getDeliveryPost() {
		return deliveryPost;
	}
	public void setDeliveryPost(Integer deliveryPost) {
		this.deliveryPost = deliveryPost;
	}
	public String getDeliveryPhone() {
		return deliveryPhone;
	}
	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
