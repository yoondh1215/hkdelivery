package hkdelivery.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.GoodsDTO;
import hkdelivery.mapper.GoodsMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsInfoService {

	@Autowired
	GoodsMapper goodsMapper;
	public void execute (String goodsNum, Model model, HttpSession session) {
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		
		GoodsDTO goodsInfoDto = new GoodsDTO();
		goodsInfoDto = goodsMapper.goodsInfoSelect(goodsNum);
		System.out.println(goodsNum);
		
		model.addAttribute("goodsInfo", goodsInfoDto);
		
		model.addAttribute("auth", auth);
	}
}
