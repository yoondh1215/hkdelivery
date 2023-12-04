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
public class PurchaseDetailService {

	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	ShopMapper shopMapper;
	public void execute (String purchaseNum, HttpSession session, Model model) {
		
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String shopNum = shopMapper.getShopNum(authInfo.getId());
		
		List<OrderListDTO> list = purchaseMapper.orderList(null, shopNum, purchaseNum);
		
		//list 중 한 개만 가져오므로 list.get(0) 로 적용.
		model.addAttribute("dto",list.get(0));
		
	}
}
