package hkdelivery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hkdelivery.domain.GoodsDTO;

@Mapper
public interface GoodsMapper {

	public String goodsAutoNum();
	public void goodsInsert(GoodsDTO dto); 
	public List<GoodsDTO> shopGoodsAllSelect(String shopNum);
	//배열로 전달 된 값을 MyBatis에서 사용하려면 @Param을 사용한다.
	public void goodsDelete(@Param("checkBox") String checkBox[]);

}
