package hkdelivery.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("orderList")
public class OrderListDTO {

	//구매 하나당 결제 하나
	PurchaseDTO purchaseDTO;	//1
	PaymentDTO paymentDTO;		//1
	
	//구매 하나당 여러 구메-상품정보 -> list
	List<PurchaseListGoodsDTO> purchaseListGoodsDTOs;	//n

	
	
	public PurchaseDTO getPurchaseDTO() {
		return purchaseDTO;
	}

	public void setPurchaseDTO(PurchaseDTO purchaseDTO) {
		this.purchaseDTO = purchaseDTO;
	}

	public PaymentDTO getPaymentDTO() {
		return paymentDTO;
	}

	public void setPaymentDTO(PaymentDTO paymentDTO) {
		this.paymentDTO = paymentDTO;
	}

	public List<PurchaseListGoodsDTO> getPurchaseListGoodsDTOs() {
		return purchaseListGoodsDTOs;
	}

	public void setPurchaseListGoodsDTOs(List<PurchaseListGoodsDTO> purchaseListGoodsDTOs) {
		this.purchaseListGoodsDTOs = purchaseListGoodsDTOs;
	}
	
	
	
}
