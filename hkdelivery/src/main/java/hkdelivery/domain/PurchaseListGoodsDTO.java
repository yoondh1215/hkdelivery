package hkdelivery.domain;

import org.apache.ibatis.type.Alias;

@Alias("purchaseListGoods")
public class PurchaseListGoodsDTO {

	//구매한 상품마다 하나씩의 상품정보를 가져와야 함
	PurchaseListDTO purchaseList;
	GoodsDTO goods;
	
	
}
