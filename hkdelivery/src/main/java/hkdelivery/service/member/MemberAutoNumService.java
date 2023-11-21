package hkdelivery.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.command.MemberCommand;
import hkdelivery.mapper.MemberMapper;

@Service
public class MemberAutoNumService {

	@Autowired
	MemberMapper memberMapper;
	public void execute (Model model) {
		String memberNum = memberMapper.memberAutoNum();
		MemberCommand memberCommand = new MemberCommand();
		memberCommand.setMemberNum(memberNum);
		model.addAttribute("memberCommand", memberCommand);
	
	}
}
