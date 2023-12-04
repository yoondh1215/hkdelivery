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

	//배송정보 추가. mapper에도 추가해줌.
	DeliveryDTO deliveryDTO;
	
	
	
	public DeliveryDTO getDeliveryDTO() {
		return deliveryDTO;
	}

	public void setDeliveryDTO(DeliveryDTO deliveryDTO) {
		this.deliveryDTO = deliveryDTO;
	}

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
