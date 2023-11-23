package hkdelivery.service.goods;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.GoodsDTO;
import hkdelivery.mapper.GoodsMapper;
import hkdelivery.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsShopListService {

	@Autowired
	GoodsMapper goodsMapper;
	@Autowired
	ShopMapper shopMapper;
	public void execute (Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth"); //세션에서 auth에다 shopId 담는데 성공
		
		String id = auth.getId();
		System.out.println(id + "샵아이디임"); //샵아이디 받아오는지 확인 완료
	
		String shopNum = shopMapper.getShopNum(id);
		
		List<GoodsDTO> goodsList = new ArrayList<GoodsDTO>();
		goodsList = goodsMapper.shopGoodsAllSelect(shopNum);
		
		model.addAttribute("goodsList", goodsList);
	}
	
	
}
