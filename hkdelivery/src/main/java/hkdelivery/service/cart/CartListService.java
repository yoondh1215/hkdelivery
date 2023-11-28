package hkdelivery.service.cart;

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
public class CartListService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	public void execute (Model model, HttpSession session) {
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getId());
		
		//상품정보와 장바구니 정보를 같이 가져와야 한다.
		//domain에 CartDTO, GoodsDTO를 가진 CartGoodsDTO 를 만든다.
		List<CartGoodsDTO> list = cartMapper.cartList(memberNum);
		
		//장바구니의 상품 전체 합계금액 가져오기
		Integer sumPrice = cartMapper.sumPrice(memberNum);
	
		
		model.addAttribute("list", list);
		model.addAttribute("sumPrice", sumPrice);
	}
}
