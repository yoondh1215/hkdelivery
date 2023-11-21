package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkdelivery.service.login.IdCheckService;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	IdCheckService idCheckService;
	@PostMapping("memberIdCheck")
	//html 문서가 아닌 텍스트를 전달하기 위해서 @ResponseBody 사용
	public @ResponseBody String userIdCheck(@RequestParam(value="memberId") String memberId) {
		String resultId =  idCheckService.execute(memberId);
		
		if (resultId == null) {
			return "사용가능한 아이디입니다";
		} else {
			return "이미 사용중인 아이디입니다.";
		}
	}
}
