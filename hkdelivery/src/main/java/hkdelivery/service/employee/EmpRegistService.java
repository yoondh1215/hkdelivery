package hkdelivery.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkdelivery.command.EmpCommand;
import hkdelivery.domain.EmpDTO;
import hkdelivery.mapper.EmployeeMapper;
@Service
public class EmpRegistService {

	@Autowired
	EmployeeMapper employeeMapper;
	//비밀번호 암호화를 위한 security
	@Autowired
	PasswordEncoder passwordEncoder;
	public void execute (EmpCommand empCommand) {
		
		EmpDTO dto = new EmpDTO();
		
		dto.setEmpAddr(empCommand.getEmpAddr());
		dto.setEmpAddrDetail(empCommand.getEmpAddrDetail());
		dto.setEmpJumin(empCommand.getEmpJumin());
		dto.setEmpEmail(empCommand.getEmpEmail());
		dto.setEmpId(empCommand.getEmpId());
		dto.setEmpName(empCommand.getEmpName());
		dto.setEmpNum(empCommand.getEmpNum());
		dto.setEmpPhone(empCommand.getEmpPhone());
		dto.setEmpPost(empCommand.getEmpPost());
		//Pw는 암호화
		dto.setEmpPw(passwordEncoder.encode(empCommand.getEmpPw()));
		dto.setEmpRegiDate(empCommand.getEmpRegiDate());
		
		//회원번호는 DB로부터 가져오기
		String empNum = employeeMapper.empAutoNum();
		dto.setEmpNum(empNum);
		
		
		employeeMapper.empRegist(dto);
		
	}
}
