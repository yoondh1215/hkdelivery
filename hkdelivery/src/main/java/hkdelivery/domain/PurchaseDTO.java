package hkdelivery.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("purchase")
public class PurchaseDTO {

	String purchaseNum;
	String memberNum;
	String purchaseName;
	Date purchaseDate;
	String purchasePhone;
	String purchaseAddr;
	String purchaseAddrDetail;
	Integer purchasePost;
	String purchaseMessage;
	String purchaseStatus;
	
	//이하 db에 추가
	Integer purchasePrice;
	String deliveryName;
	
	
	//디폴트 생성자 만들어주기. 롬복이면 @Data @NoArgsConstructor 인가? 쓰면 됨 난 안먹혀서 ctrl shift s 누르고 컨스트럭터 만들어줌
	public PurchaseDTO() {
		super();
	}


	//생성자. lombok이 정상작동 한다면 @AllArgsConstructor 쓰면 됨
	public PurchaseDTO(String purchaseNum, String memberNum, String purchaseName, Date purchaseDate,
			String purchasePhone, String purchaseAddr, String purchaseAddrDetail, Integer purchasePost,
			String purchaseMessage, String purchaseStatus, Integer purchasePrice, String deliveryName) {
		super();
		this.purchaseNum = purchaseNum;
		this.memberNum = memberNum;
		this.purchaseName = purchaseName;
		this.purchaseDate = purchaseDate;
		this.purchasePhone = purchasePhone;
		this.purchaseAddr = purchaseAddr;
		this.purchaseAddrDetail = purchaseAddrDetail;
		this.purchasePost = purchasePost;
		this.purchaseMessage = purchaseMessage;
		this.purchaseStatus = purchaseStatus;
		this.purchasePrice = purchasePrice;
		this.deliveryName = deliveryName;
	}

	//이하 Getter Setter


	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
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
	public String getPurchasePhone() {
		return purchasePhone;
	}
	public void setPurchasePhone(String purchasePhone) {
		this.purchasePhone = purchasePhone;
	}
	public String getPurchaseAddr() {
		return purchaseAddr;
	}
	public void setPurchaseAddr(String purchaseAddr) {
		this.purchaseAddr = purchaseAddr;
	}
	public String getPurchaseAddrDetail() {
		return purchaseAddrDetail;
	}
	public void setPurchaseAddrDetail(String purchaseAddrDetail) {
		this.purchaseAddrDetail = purchaseAddrDetail;
	}
	
	public Integer getPurchasePost() {
		return purchasePost;
	}
	public void setPurchasePost(Integer purchasePost) {
		this.purchasePost = purchasePost;
	}
	public String getPurchaseMessage() {
		return purchaseMessage;
	}
	public void setPurchaseMessage(String purchaseMessage) {
		this.purchaseMessage = purchaseMessage;
	}
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	public Integer getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}


	

	
	
	
}
