package hkdelivery.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.command.DeliveryCommand;
import hkdelivery.domain.DeliveryDTO;
import hkdelivery.mapper.DeliveryMapper;

@Service
public class DeliveryInsertService {

	@Autowired
	DeliveryMapper deliveryMapper;
	public void execute (DeliveryCommand deliveryCommand) {
		DeliveryDTO dto = new DeliveryDTO();
		
		dto.setDeliveryCompany(deliveryCommand.getDeliveryCompany());
		dto.setDeliveryDate(deliveryCommand.getDeliveryDate());
		dto.setDeliveryNum(deliveryCommand.getDeliveryNum());
		dto.setDeliveryStatus(deliveryCommand.getDeliveryStatus());
		dto.setPurchaseNum(deliveryCommand.getPurchaseNum());
		
		
		deliveryMapper.deliveryInsert(dto);
	}
	                      
}
