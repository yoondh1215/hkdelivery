package hkdelivery.domain;

import org.apache.ibatis.type.Alias;
//PurchaseListGoodsDTO 는 OrderListDTO 에 속함
@Alias("purchaseListGoods")
public class PurchaseListGoodsDTO {

	//구매한 상품마다 하나씩의 상품정보를 가져와야 함
	PurchaseListDTO purchaseList;
	GoodsDTO goods;
	public PurchaseListDTO getPurchaseList() {
		return purchaseList;
	}
	public void setPurchaseList(PurchaseListDTO purchaseList) {
		this.purchaseList = purchaseList;
	}
	public GoodsDTO getGoods() {
		return goods;
	}
	public void setGoods(GoodsDTO goods) {
		this.goods = goods;
	}
	
	
}
