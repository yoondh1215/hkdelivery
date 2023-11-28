package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkdelivery.service.cart.CartInsertService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("cart")
public class CartController {

	@Autowired
	CartInsertService cartInsertService;
	//비동기식인 ajax에 값을 전달하기 위해서는 RestAPI 또는 @ResponseBody를 사용해야 한다.
	@GetMapping("cartAdd")
	@ResponseBody
	public String cartAdd(@RequestParam(value="goodsNum") String goodsNum, 
						@RequestParam(value="qty") Integer qty, 
						HttpSession session) {
		return cartInsertService.execute(goodsNum, qty, session);
	}
	
	@GetMapping("cartList")
	public String cartList(Model model, HttpSession session) {
		
		return "thymeleaf/cart/cartList";
	}
}
