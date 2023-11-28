package hkdelivery.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hkdelivery.domain.CartDTO;
import hkdelivery.domain.CartGoodsDTO;
import hkdelivery.domain.GoodsDTO;

@Mapper
public interface CartMapper {

	public List<GoodsDTO> goodsAllSelect();
	
	public int cartInsert(CartDTO dto);
	
	public List<CartGoodsDTO> cartList(String memberNum);

	public Integer sumPrice(String memberNum);
	
	public int goodsNumsDelete(Map<String, Object> map);

	public int goodsNumDelete(String memberNum, String goodsNum);

	public CartGoodsDTO cartQtyDown(String goodsNum, String memberNum);

	//조인문 없이 조인하기 - 두 테이블 검색 쿼리가 각각 존재해야 함
	public GoodsDTO goodsSelect(String goodsNum);
	public CartDTO cartSelect(String memberNum);
	//두 테이블로부터 데이터를 가져와 CartGoodsDTO로 받아옴
	public CartGoodsDTO goodsPriceMulCartQty (@Param("goodsNum") String goodsNum, 
			@Param("memberNum") String memberNum); 
	
	
	
	
}
