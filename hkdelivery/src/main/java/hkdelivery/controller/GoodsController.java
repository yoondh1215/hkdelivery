package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hkdelivery.command.GoodsCommand;
import hkdelivery.service.goods.GoodsAutoNumService;
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
		return "thymeleaf/goods/goodsList"; 
	}
}
