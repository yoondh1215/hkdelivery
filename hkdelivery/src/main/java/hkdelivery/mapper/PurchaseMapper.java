package hkdelivery.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import hkdelivery.domain.OrderListDTO;
import hkdelivery.domain.PaymentDTO;
import hkdelivery.domain.PurchaseDTO;
import hkdelivery.domain.PurchaseListDTO;

@Mapper
public interface PurchaseMapper {

	//select AutoNum의 역할도 한다.
	public String selectNum();
	
	public Integer purchaseInsert(PurchaseDTO dto);
	
	public int purchaseListInsert(PurchaseListDTO plDto);

	//purchaseName을 만들기 위한 메서드
	public PurchaseDTO purchaseSelect(String purchaseNum);
	public int purchaseGoodsCount(String purchaseNum);
	public String firstGoods(String purchaseNum);
	
	public int paymentInsert(PaymentDTO dto);
	public int purchaseStatusUpdate(@Param("status") String status, @Param("purchaseNum") String purchaseNum);
	
	
	public List<OrderListDTO> orderList(String memberNum);
	
	//구매 취소
	public int paymentDelete(String purchaseNum);
	
}
