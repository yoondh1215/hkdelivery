package hkdelivery.service.delivery;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.command.DeliveryCommand;
import hkdelivery.domain.DeliveryDTO;
import hkdelivery.repository.DeliveryRepository;

@Service
public class DeliveryInsertService {

	//interface 대신 class 를 사용해봄 이유: 연습.
	//DeliveryRepository는 hkdelivery/repository 아래다 만들어줬다.
	@Autowired
	DeliveryRepository deliveryRepository;
	public void execute (DeliveryCommand deliveryCommand) {
		DeliveryDTO deliveryDTO = new DeliveryDTO();
		
		//command의 값을 dto에 복사해준다.
		BeanUtils.copyProperties(deliveryCommand, deliveryDTO);
		
		deliveryRepository.deliveryInsert(deliveryDTO);
	}
	                      
}
