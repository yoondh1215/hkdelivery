package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hkdelivery.command.MemberCommand;
import hkdelivery.service.member.MemberAutoNumService;
import hkdelivery.service.member.MemberInfoService;
import hkdelivery.service.member.MemberInsertService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	MemberAutoNumService memberAutoNumService;
	@GetMapping("memberRegist")
	public String memberRegi(Model model) {
		//회원번호 자동생성기
		memberAutoNumService.execute(model);
		return "thymeleaf/member/memberForm";
	}
	
	@Autowired
	MemberInsertService memberInsertService;
	@PostMapping("memberRegist")
	public String memberRegist (@Validated MemberCommand memberCommand, BindingResult result) {
		//@Validated 로 MemberCommand 에서 유효성검사.
		//BindingResult로 오류메시지를 html에 전달
		if (result.hasErrors()) {
			return "thymeleaf/member/memberForm";
		}
		
		if (!memberCommand.isMemberPwEqualsMemberPwCheck()) {
			//비밀번호와 비밀번호 확인이 다른 경우 메세지
			//result.rejectValue(필드명, 에러코드, 메시지)
			result.rejectValue("memberPwCheck", "memberCommand.memberPwCheck", "비밀번호확인이 일치하지 않습니다");
			return "thymeleaf/member/memberForm";
		} else {
			memberInsertService.execute(memberCommand);
			return "redirect:/";
		}
		
	}
	
	@Autowired
	MemberInfoService memberInfoService;
	@GetMapping("myInfo")
	public String myInfo(HttpSession session, Model model) {
		memberInfoService.execute(session, model);
		return "thymeleaf/member/memberMyInfo";
	}
	
	
	
	
}
