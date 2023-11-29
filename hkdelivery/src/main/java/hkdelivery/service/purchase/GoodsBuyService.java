package hkdelivery.service.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.CartGoodsDTO;
import hkdelivery.mapper.CartMapper;
import hkdelivery.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsBuyService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	public void execute (String[] prodCk, HttpSession session, Model model) {
	
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(authInfo.getId()); 
		
		//카트로부터 구매정보를 가져와야 함.
		//prodCk가 체크된 goodsNum만 가져와야 함.
		//따라서 cartMapper의 cartList메서드의 인자에 스트링 멤버넘뿐 아니라 스트링[]prodCk를 추가해준다.
		
		List<CartGoodsDTO> list = cartMapper.cartList(memberNum, prodCk); 
		
		Integer sumPrice = 0;	//상품수량 합계금액
		Integer sumTotalPrice = 0;	//결제금액
		Integer sumDeliveryCost = 0;	//배송비 합계
		String goodsNums = "";	//상품번호 저장
		
		for (CartGoodsDTO dto : list) {
			sumTotalPrice += dto.getTotalPrice();
			sumDeliveryCost += dto.getGoodsDTO().getDeliveryCost();
			goodsNums += dto.getGoodsDTO().getGoodsNum() + "-";
		}
		
		sumPrice = sumTotalPrice + sumDeliveryCost;
		model.addAttribute("list", list);
		model.addAttribute("sumPrice", sumPrice);
		model.addAttribute("sumTotalPrice", sumTotalPrice);
		model.addAttribute("sumDeliveryCost", sumDeliveryCost);
		model.addAttribute("goodsNums", goodsNums);
		
		
		
		
	}
}
