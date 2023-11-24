package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import hkdelivery.command.LoginCommand;
import hkdelivery.service.MainGoodsListService;

@Controller
public class MainController {

	@Autowired
	MainGoodsListService mainGoodsListService;
	//LoginCommand loginCommand 만 사용해도 되지만 @ModelAttribute도 사용 가능.
	@RequestMapping("/")
	public String index(@ModelAttribute("loginCommand") LoginCommand loginCommandm, Model model) {
		//인덱스 페이지에 상품리스트를 가져오기 위해 기능 추가
		mainGoodsListService.execute(model);
		return "thymeleaf/index";
	}
	

}
