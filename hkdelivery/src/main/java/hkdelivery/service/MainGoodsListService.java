package hkdelivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.GoodsDTO;
import hkdelivery.mapper.CartMapper;

@Service
public class MainGoodsListService {
	@Autowired
	CartMapper cartMapper;
	public void execute (Model model) {
		List<GoodsDTO> goodsList = cartMapper.goodsAllSelect();
		model.addAttribute("goodsList",goodsList);
		
	}
}
