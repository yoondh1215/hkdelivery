package hkdelivery.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.command.EmpCommand;
import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.EmpDTO;
import hkdelivery.mapper.EmployeeMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class EmpReadService {

	@Autowired
	EmployeeMapper employeeMapper;
	public void execute (HttpSession session, Model model) {
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String empId = authInfo.getId();
		
		String empNum = employeeMapper.getEmpNum(empId);
		
		EmpDTO dto =  employeeMapper.empRead(empNum);
		
		model.addAttribute("dto",dto);
		
	}
}
