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
public class OrderListService {

	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute (HttpSession session, Model model) {
		
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(authInfo.getId());
		
		List <OrderListDTO> list = purchaseMapper.orderList(memberNum, null, null);
		model.addAttribute("list", list);
		
		
	}
}
