package hkdelivery.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.repository.DeliveryRepository;

@Service
public class DeliveryDeleteService {

	@Autowired
	DeliveryRepository deliveryRepository;
	public void execute (String purchaseNum) {
		deliveryRepository.deliveryDelete(purchaseNum);
	}
	
	
}
