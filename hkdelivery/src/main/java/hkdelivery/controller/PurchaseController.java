package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkdelivery.service.purchase.GoodsBuyService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("purchase")
public class PurchaseController {

	@Autowired
	GoodsBuyService goodsBuyService;
	@RequestMapping("goodsBuy")
	public String goodsBuy(@RequestParam(value="prodCk") String [] prodCk,	//checkbox를 배열로 전환
			HttpSession session, Model model) {
		
		goodsBuyService.execute(prodCk, session, model);
		return "thymeleaf/purchase/goodsOrder";
	}
	
	
}
