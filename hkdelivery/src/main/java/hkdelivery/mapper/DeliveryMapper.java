package hkdelivery.mapper;

import org.apache.ibatis.annotations.Mapper;

import hkdelivery.domain.DeliveryDTO;

@Mapper
public interface DeliveryMapper {

	
	public Integer deliveryInsert(DeliveryDTO dto);
	public Integer deliveryDelete(String purchaseNum);
		
	
}
