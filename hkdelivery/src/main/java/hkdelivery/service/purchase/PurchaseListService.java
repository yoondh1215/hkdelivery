package hkdelivery.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.OrderListDTO;
import hkdelivery.mapper.PurchaseMapper;

@Service
public class PurchaseListService {

	@Autowired
	PurchaseMapper purchaseMapper;
	public void execute (Model model) {
		//회원이 구매리스트를 가져올 때의 로직을 그대로 사용
		List<OrderListDTO> list = purchaseMapper.orderList(null);
		
		model.addAttribute("list",list);
		
	}
}
