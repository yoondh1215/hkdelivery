package hkdelivery.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.OrderListDTO;
import hkdelivery.mapper.MemberMapper;
import hkdelivery.mapper.PurchaseMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class OrderProcessListService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PurchaseMapper purchaseMapper;
	public void execute (HttpSession session, Model model) {
		
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(authInfo.getId());
		
		//가져와야 할 것: 주문일, 결제번호, 상품명, 주무번호, 주문상태
		List<OrderListDTO> orderList = purchaseMapper.orderList(memberNum, null, null);
		
		model.addAttribute("list", orderList);
		
	}
}
