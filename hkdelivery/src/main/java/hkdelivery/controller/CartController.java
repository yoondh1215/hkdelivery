package hkdelivery.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hkdelivery.domain.CartGoodsDTO;
import hkdelivery.service.cart.CartDelService;
import hkdelivery.service.cart.CartDelsService;
import hkdelivery.service.cart.CartInsertService;
import hkdelivery.service.cart.CartListService;
import hkdelivery.service.cart.CartQtyDownService;
import jakarta.servlet.http.HttpServletResponse;
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
	
	@Autowired
	CartListService cartListService;
	@GetMapping("cartList")
	public String cartList(Model model, HttpSession session) {
		cartListService.execute(model, session);
		return "thymeleaf/cart/cartList";
	}
	
	//체크박스 여러개를 삭제하는 기능
	@Autowired
	CartDelsService cartDelsService;
	@PostMapping("cartDels")
	@ResponseBody
	public String cartDels(@RequestParam("goodsNums[]")String goodsNums[], //javascript 배열이므로 배열로 받아옴 
			HttpSession session) {
		return cartDelsService.execute(goodsNums, session);
	}
	
	//항목 하나만 삭제하는 기능
	@Autowired
	CartDelService cartDelService;
	@GetMapping("cartDel")
	public String cartDel(@RequestParam("goodsNum") String goodsNum, HttpSession session) {
		cartDelService.execute(goodsNum, session);
		return "redirect:cartList";
	}
	
	@Autowired
	CartQtyDownService cartQtyDownService;
	@GetMapping("cartQtyDown")
	public void cartQtyDown(@RequestParam(value="goodsNum") String goodsNum, HttpSession session, HttpServletResponse response) {
		//DTO를 model 로 전달하지 않고 ObjectMapper 사용해보기.
		CartGoodsDTO dto = cartQtyDownService.execute(goodsNum, session);
		
		ObjectMapper mapper = new ObjectMapper();
		response.setCharacterEncoding("utf-8");
		//response를 통해 OBjectMapper 를 ajax에 전달
		try {
			response.getWriter().print(mapper.writeValueAsString(dto));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	} 
	
	
}
