package hkdelivery.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkdelivery.command.LoginCommand;
import hkdelivery.service.login.IdCheckService;
import hkdelivery.service.login.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
	public String login(LoginCommand loginCommand, HttpSession session, BindingResult result, HttpServletResponse response) {
		loginService.execute(loginCommand, session, result, response);
		//오류가 있으면 index.html 페이지에 리젝트 메시지가 보내지도록 구현
		if (result.hasErrors()) {
			return "thymeleaf/index";
		}
		return "redirect:/";
	} 
	
	
	@GetMapping("logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		Cookie cookie = new Cookie("authLogin", "");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		session.invalidate(); //로그아웃시 세션 삭제
		return "redirect:/";
	}
	
	//item.login 은 goodsOrder 페이지에서 비로그인시 위시리스트 클릭하면 실행됨.
	@GetMapping("item.login")
	public String item(LoginCommand loginCommand) {
		return "thymeleaf/login";
	}
	
	
	@PostMapping("item.login")
	public String item(@Validated LoginCommand loginCommand, BindingResult result, HttpSession session, HttpServletResponse response) {
		loginService.execute(loginCommand, session, result, response);
		
		if (result.hasErrors()) {
			//입력하지 않은 값이 있으면 다시 페이지를 로드
			return "thymeleaf/login";
		}
		
		//정상적으로 로그인 되었으면 팝업창을 닫고 부모창은 새로고침 하기 위한 servlet 코드.
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 자바스크립트 코드
		String str = "<script language='javascript'>"
					+ " opener.location.reload(); "
					+ " window.self.close();"
					+ " </script>";
		out.print(str);
		out.close();
		
		return null;
		
	}
	
}
