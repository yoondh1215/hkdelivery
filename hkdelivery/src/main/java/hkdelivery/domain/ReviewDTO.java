package hkdelivery.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("review")
public class ReviewDTO {

	String review_title;
	String reviewContent;
	String reviewScore;
	Date reviewDate;
	String memberId;
	String purchaseNum;
	String goodsNum;
	Integer reviewNum;
	
	
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public Integer getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(Integer reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	
	
	
	
}
