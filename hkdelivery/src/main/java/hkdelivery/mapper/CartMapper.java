package hkdelivery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hkdelivery.domain.CartDTO;
import hkdelivery.domain.GoodsDTO;

@Mapper
public interface CartMapper {

	public List<GoodsDTO> goodsAllSelect();
	
	public int cartInsert(CartDTO dto);
	
}
