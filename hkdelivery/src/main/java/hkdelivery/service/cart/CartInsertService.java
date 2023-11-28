package hkdelivery.service.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.CartDTO;
import hkdelivery.mapper.CartMapper;
import hkdelivery.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class CartInsertService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	public String execute (String goodsNum, Integer qty, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		
		if (auth != null) {
			//member grade 만 장바구니 사용 가능. 아닐 경우 오류 발생 가능성 있음.
			if (auth.getGrade().equals("mem")) {
				String memberNum = memberMapper.getMemberNum(auth.getId());
				CartDTO dto = new CartDTO();
				dto.setCartQty(qty);
				dto.setGoodsNum(goodsNum);
				dto.setMemberNum(memberNum);
				cartMapper.cartInsert(dto);
				return "200"; //장바구니가 제대로 업데이트 된 경우
			} else {
				System.out.println("장바구니는 member만 사용 가능합니다. 업체 및 직원은 사용불가");
				return "999"; //grade가 mem이 아닌 사용자가 접근한 경우
			}
		} else {
			System.out.println("로그인 상태에서 장바구니 사용 가능합니다"); //비로그인인 경우
			return "000";
		}
	}
}
