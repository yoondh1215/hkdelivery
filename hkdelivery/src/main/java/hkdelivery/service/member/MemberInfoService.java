package hkdelivery.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.MemberDTO;
import hkdelivery.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberInfoService {

	@Autowired
	MemberMapper memberMapper;
	public void execute (HttpSession session, Model model) {
		
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String memberId = authInfo.getId();
		String memberNum = memberMapper.getMemberNum(memberId);
		
		MemberDTO memDto = new MemberDTO();
		memDto = memberMapper.selectMemberInfo(memberNum);
		
		model.addAttribute("dto",memDto);
		
	}
}
