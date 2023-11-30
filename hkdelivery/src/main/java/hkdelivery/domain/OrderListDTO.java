package hkdelivery.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("orderList")
public class OrderListDTO {

	//구매정보 마다 결제정보 하나를 가져와야 함
	PurchaseDTO purchaseDTO;
	PaymentDTO maymentDTO;
	
	//구매정보마다 하나 이상의 구매/ 상품정보를 가져와야 함
	List<PurchaseListGoodsDTO> purchaseListGoodsDTOs;
	
	
	
}
