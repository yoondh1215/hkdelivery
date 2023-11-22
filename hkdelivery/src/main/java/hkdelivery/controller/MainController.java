package hkdelivery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import hkdelivery.command.LoginCommand;

@Controller
public class MainController {

	//LoginCommand loginCommand 만 사용해도 되지만 @ModelAttribute도 사용 가능.
	@RequestMapping("/")
	public String index(@ModelAttribute("loginCommand") LoginCommand loginCommand) {
		return "thymeleaf/index";
	}
	
}
