package hkdelivery.domain;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Service;

@Service
@Alias("payment")
public class PaymentDTO {

	String purchaseNum;
	String confirmnumber;
	String cardnum;
	String tid;
	String totalprice;
	String resultmessage;
	String paymethod;
	String appldate;
	String appltime;
	String purchasename;
	
	public String getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getConfirmnumber() {
		return confirmnumber;
	}
	public void setConfirmnumber(String confirmnumber) {
		this.confirmnumber = confirmnumber;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public String getResultmessage() {
		return resultmessage;
	}
	public void setResultmessage(String resultmessage) {
		this.resultmessage = resultmessage;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public String getAppldate() {
		return appldate;
	}
	public void setAppldate(String appldate) {
		this.appldate = appldate;
	}
	public String getAppltime() {
		return appltime;
	}
	public void setAppltime(String appltime) {
		this.appltime = appltime;
	}
	public String getPurchasename() {
		return purchasename;
	}
	public void setPurchasename(String purchasename) {
		this.purchasename = purchasename;
	}
	
	
	
	
}
