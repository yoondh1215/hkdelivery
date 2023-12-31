package hkdelivery.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.OrderListDTO;
import hkdelivery.mapper.PurchaseMapper;
import hkdelivery.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class PurchaseListService {

	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	ShopMapper shopMapper;
	public void execute (HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String shopNum = shopMapper.getShopNum(authInfo.getId());
		
		List<OrderListDTO> list = purchaseMapper.orderList(null, shopNum, null);
		
		model.addAttribute("list",list);
		
		model.addAttribute("auth",authInfo);	//grade == shop 이면 배송정보 입력 가능하게 하려고.
		
	}
}
