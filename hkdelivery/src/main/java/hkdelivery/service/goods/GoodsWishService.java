package hkdelivery.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.mapper.MemberMapper;
import hkdelivery.mapper.WishMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsWishService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	WishMapper wishMapper;
	public String execute (String goodsNum, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		//memberNum 이 필요한데 auth에 id가 있으므로 id로 num 가져오기
		String memberNum = memberMapper.getMemberNum(auth.getId()); 
		
		Integer i = wishMapper.wishGoodsSelect(goodsNum, memberNum);
		
		if (auth.getGrade().equals("mem")) { //멤버라면 위시리스트 진행, 샵은 안됨
			if(i == null) {	//null일시 등록된 상품이 없으므로 등록을 실시
				wishMapper.wishInsert(goodsNum, memberNum);
				return "1";
			} else if (i == 1) {
				wishMapper.wishDelete(goodsNum, memberNum);
				return "0";
			}
		} else {
			return "999"; //멤버가 아닌 grade 가 접근시 999 반환.
		}
		return null;
	}
}
