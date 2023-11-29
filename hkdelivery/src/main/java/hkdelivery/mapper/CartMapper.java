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
	//장바구니 조회에서 결제로 넘어갈 때 prodCk가 체크된 것만 가져와야 하므로 받아올 인자로 prodCk 배열 추가함.
	//따라서 기존 cartListService도 수정해야 함.
	//추가로 마이바티스 오류가 생기므로 @Param 으로 받아준다.
	public List<CartGoodsDTO> cartList(@Param ("memberNum") String memberNum, 
										@Param("goodsNums") String [] prodCk);

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
