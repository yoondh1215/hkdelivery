package hkdelivery.service.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.CartGoodsDTO;
import hkdelivery.mapper.CartMapper;
import hkdelivery.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class CartQtyDownService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	public CartGoodsDTO execute (String goodsNum, HttpSession session) {
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getId());
		
		cartMapper.cartQtyDown(goodsNum, memberNum);
		CartGoodsDTO dto = cartMapper.goodsPriceMulCartQty(goodsNum, memberNum);
		return dto;
		
	}
}
