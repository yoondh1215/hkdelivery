package hkdelivery.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.mapper.MemberMapper;
import hkdelivery.mapper.WishMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class WishDelService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	WishMapper wishMapper;
	public void execute (String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getId());
		
		wishMapper.wishDelete(goodsNum, memberNum);
		
	}
}
