package hkdelivery.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hkdelivery.command.LoginCommand;
import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.mapper.LoginMapper;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {

	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder; //회원가입시 비밀번호를 암호화 했으므로 암호로 비교해야 함
	
	public void execute (LoginCommand loginCommand, HttpSession session, BindingResult result, HttpServletResponse response) {
		
		String id = loginCommand.getId();
		String password = loginCommand.getPassword();
		
		AuthInfoDTO authInfo = loginMapper.loginSelect(id);
		
		if (id != "" && id != null) {
			if (authInfo != null) {	//가입한 회원이 맞으면 authInfo가 null이 아님
				//아이디가 존재하면 비밀번호 매치 확인
				//						로그인창에서 입력한 비밀번호 값
				//									DB서 가져온 암호화된 비밀번호 값
			if (passwordEncoder.matches(password, authInfo.getPassword())) {
				System.out.println("비밀번호가 일치합니다.");
				//id와 비밀번호가 일치하면 session에 로그인 정보를 저장
				session.setAttribute("auth", authInfo);
				
			
				
			} else {
				System.out.println("비밀번호가 일치하지 않습니다.");
				result.rejectValue("password", "loginCommand.password", "비밀번호가 일치하지 않습니다.");
			}
			} 
		} else { //id를 받아오지 못했다면 없는 아이디임
			System.out.println("존재하지 않는 아이디입니다.");
			result.rejectValue("id", "loginCommand.id", "존재하지 않는 아이디입니다.");
		}
		
	}
}
