package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hkdelivery.command.ShopCommand;
import hkdelivery.service.shop.ShopAutoNumService;
import hkdelivery.service.shop.ShopInsertService;

@Controller
@RequestMapping("shop")
public class ShopController {

	@GetMapping("shopRegist")
	public String shopRegi() {
		return "thymeleaf/shop/shopForm";
	}
	
	@Autowired
	ShopInsertService shopInsertService;
	@Autowired
	ShopAutoNumService shopAutoNumService;
	@PostMapping("shopRegist")
	public String shopRegist(ShopCommand shopCommand) {
		String shopNum = shopAutoNumService.execute();
		shopCommand.setShopNum(shopNum);
		shopInsertService.execute(shopCommand);
		return "/";
	}
	
}
