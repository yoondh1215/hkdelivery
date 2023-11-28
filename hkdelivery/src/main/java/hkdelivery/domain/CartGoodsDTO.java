package hkdelivery.domain;

import org.apache.ibatis.type.Alias;

@Alias("cartGoodsDTO")
public class CartGoodsDTO {

	CartDTO cartDTO;
	GoodsDTO goodsDTO;
	Integer totalPrice;
	
	public CartDTO getCartDTO() {
		return cartDTO;
	}
	public void setCartDTO(CartDTO cartDTO) {
		this.cartDTO = cartDTO;
	}
	public GoodsDTO getGoodsDTO() {
		return goodsDTO;
	}
	public void setGoodsDTO(GoodsDTO goodsDTO) {
		this.goodsDTO = goodsDTO;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
	
}
