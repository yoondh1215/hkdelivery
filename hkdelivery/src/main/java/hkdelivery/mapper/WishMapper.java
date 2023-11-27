package hkdelivery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hkdelivery.domain.GoodsDTO;

@Mapper
public interface WishMapper {

	//리턴을 int 가 아니라 Integer로 한다. 일치하는 값이 없으면 null도 나오기 때문.
	public Integer wishGoodsSelect(String goodsNum, String memberNum);
	//이건 null 이 안나오니까 int로 줬다.
	public int wishInsert(String goodsNum, String memberNum);
	public int wishDelete (String goodsNum, String memberNum);

	public List<GoodsDTO> wishGoodsList(String memberNum);
	
	public int wishGoodsDeletes(@Param("goodsNums") String[] wishGoodsDels, @Param("memberNum") String memberNum); 
	
	
	
}
