package hkdelivery.service.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.mapper.PurchaseMapper;

@Service
public class PurchaseStatusService {

	@Autowired
	PurchaseMapper purchaseMapper;
	public void execute (String purchaseNum) {
		purchaseMapper.purchaseStatusUpdate("상품준비중", purchaseNum);
		
	}
}
