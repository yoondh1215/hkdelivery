package hkdelivery.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.mapper.DeliveryMapper;

@Service
public class DeliveryDeleteService {

	@Autowired
	DeliveryMapper deliveryMapper;
	public void execute (String purchaseNum) {
		deliveryMapper.deliveryDelete(purchaseNum);
	}
	
	
}
