package hkdelivery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import hkdelivery.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {

	public String goodsAutoNum();
	public void goodsInsert(GoodsDTO dto); 
	public List<GoodsDTO> shopGoodsAllSelect(String shopNum);
	

}
