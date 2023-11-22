package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkdelivery.command.LoginCommand;
import hkdelivery.service.login.IdCheckService;
import hkdelivery.service.login.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	IdCheckService idCheckService;
	@PostMapping("registIdCheck")
	//html 문서가 아닌 텍스트를 전달하기 위해서 @ResponseBody 사용
	public @ResponseBody String userIdCheck(@RequestParam(value="registId") String registId) {
		String resultId =  idCheckService.execute(registId);
		
		if (resultId == null) {
			return "사용가능한 아이디입니다";
		} else {
			return "이미 사용중인 아이디입니다.";
		}
	}
	
	@Autowired
	LoginService loginService;
	@PostMapping("login")
	public String login(LoginCommand loginCommand, HttpSession session, BindingResult result) {
		loginService.execute(loginCommand, session, result);
		//오류가 있으면 index.html 페이지에 리젝트 메시지가 보내지도록 구현
		if (result.hasErrors()) {
			return "thymeleaf/index";
		}
		return "redirect:/";
	} 
	
	
}
