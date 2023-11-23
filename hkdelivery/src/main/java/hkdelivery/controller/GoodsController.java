package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkdelivery.command.GoodsCommand;
import hkdelivery.service.goods.GoodsAutoNumService;
import hkdelivery.service.goods.GoodsDeleteService;
import hkdelivery.service.goods.GoodsShopListService;
import hkdelivery.service.goods.GoodsWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	GoodsAutoNumService goodsAutoNumService;
	@GetMapping("goodsRegist")
	public String goodsRegist(Model model) {
		goodsAutoNumService.execute(model);
		return "thymeleaf/goods/goodsForm";
	}
	
	@Autowired
	GoodsWriteService goodsWriteService;
	@PostMapping("goodsSubmit")
	public String goodsSubmit(@Validated GoodsCommand goodsCommand, BindingResult result, HttpSession session) {
		if (result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		goodsWriteService.execute(goodsCommand, session);
		return "redirect:goodsList";
	}
	
	@Autowired
	GoodsShopListService goodsShopListService;
	@GetMapping("goodsList")
	public String goodsList(Model model, HttpSession session) {
		goodsShopListService.execute(model, session);
		return "thymeleaf/goods/goodsList";
	}
	
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@PostMapping("goodsDelete")	//체크박스에 의하 받은 값을 배열로 받는다.
	public String goodsDelete (@RequestParam(value="checkBox") String checkBox[] ) {
		goodsDeleteService.execute(checkBox);
		return "redirect:goodsList";
	}
	
}
