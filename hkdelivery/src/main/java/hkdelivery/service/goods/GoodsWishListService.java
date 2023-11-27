package hkdelivery.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.GoodsDTO;
import hkdelivery.mapper.MemberMapper;
import hkdelivery.mapper.WishMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsWishListService {
	
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	WishMapper wishMapper;
	
	public void execute (HttpSession session, Model model) {
		//내 정보 가져오기
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(authInfo.getId()); 
		
		//관심상품 정보 가지고 오기
		List<GoodsDTO> list = wishMapper.wishGoodsList(memberNum);
		model.addAttribute("dtos",list);
		
	}
	
}
