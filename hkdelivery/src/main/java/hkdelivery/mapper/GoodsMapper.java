package hkdelivery.mapper;

import org.apache.ibatis.annotations.Mapper;

import hkdelivery.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {

	public String goodsAutoNum();
	public void goodsInsert(GoodsDTO dto); //성공여부를 int로 확인
}
