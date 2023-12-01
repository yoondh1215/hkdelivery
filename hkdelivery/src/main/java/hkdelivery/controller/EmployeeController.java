package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hkdelivery.command.EmpCommand;
import hkdelivery.service.employee.EmpReadService;
import hkdelivery.service.employee.EmpRegistService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("employee")
public class EmployeeController {

	@GetMapping("empRegist")
	public String empRegist1 () {
		return "thymeleaf/employee/empForm";
	}
	
	@Autowired
	EmpRegistService empRegistService;
	@PostMapping("empRegist")
	public String empRegist2 (EmpCommand empCommand) {
		empRegistService.execute(empCommand);
		return "redirect:/";
	}
	
	@Autowired
	EmpReadService empReadService;
	@GetMapping("empRead")
	public String empUpdate(HttpSession session, Model model) {
		empReadService.execute(session, model);
		return "thymeleaf/employee/empRead";
	}
	
	
	
}
