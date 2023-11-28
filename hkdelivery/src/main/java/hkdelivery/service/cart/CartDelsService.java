package hkdelivery.service.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.mapper.CartMapper;
import hkdelivery.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class CartDelsService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CartMapper cartMapper;
	public String execute (String[] goodsNums, HttpSession session) {
		
		//배열로 받아온 값을 리스트에 저장
		List<String> list = new ArrayList<String>();
		for (String goodsNum : goodsNums) {
			list.add(goodsNum);
		}
		
		//리스트에 저장한 값을 map 에 저장
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsNums", list);		//map 의 goodsNums 안에 list goodsNums가 들어감
		
		//map에 회원번호도 추가
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(auth.getId());
		map.put("memberNum", memberNum);		//map 의 memberNum 안에 String memberNum을 넣음
		
		int i = cartMapper.goodsNumsDelete(map);
		if (i >= 1) {
			return "200";
		} else return "999";
	}
}
