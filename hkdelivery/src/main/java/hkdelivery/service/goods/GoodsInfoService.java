package hkdelivery.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.GoodsDTO;
import hkdelivery.mapper.GoodsMapper;
import hkdelivery.mapper.MemberMapper;
import hkdelivery.mapper.WishMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsInfoService {

	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	WishMapper wishMapper;
	public void execute (String goodsNum, Model model, HttpSession session) {
		GoodsDTO goodsInfoDto = new GoodsDTO();
		goodsInfoDto = goodsMapper.goodsInfoSelect(goodsNum);
		//회원정보 가져오기
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		
		if (auth != null) {	//로그인 정보가 있다면 회원이 위시리스트에 등록한 상품인지 확인
			try {	//auth 가 member가 아닐 경우 오류가 발생할 수도 있어서 예외처리.
				String memberNum = memberMapper.getMemberNum(auth.getId());
				Integer i = wishMapper.wishGoodsSelect(goodsNum, memberNum);
				model.addAttribute("wish", i);
			} catch (Exception e){
				
			}
		}
		
		model.addAttribute("goodsInfo", goodsInfoDto);
	}
}
