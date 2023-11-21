package hkdelivery.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkdelivery.command.MemberCommand;
import hkdelivery.domain.MemberDTO;
import hkdelivery.mapper.MemberMapper;


@Service
public class MemberInsertService {
	
	//비밀번호 암호화를 위한 security
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	MemberMapper memberMapper;
	public void execute (MemberCommand memberCommand) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberAddrDetail(memberCommand.getMemberAddr());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberGender(memberCommand.getMemberGender());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberName(memberCommand.getMemberId());
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberPost(memberCommand.getMemberPost());
		//비밀번호 암호화
		dto.setMemberPw(passwordEncoder.encode(memberCommand.getMemberPw()));
		
		memberMapper.memberInsert(dto);
	
	}
}
