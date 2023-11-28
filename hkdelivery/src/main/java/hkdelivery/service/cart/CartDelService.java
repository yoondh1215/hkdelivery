package hkdelivery.service.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.mapper.CartMapper;
import hkdelivery.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class CartDelService {

	@Autowired
	CartMapper cartMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute (String goodsNum, HttpSession session) {
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getId());
		
		cartMapper.goodsNumDelete(goodsNum, memberNum);
		
	}
}
