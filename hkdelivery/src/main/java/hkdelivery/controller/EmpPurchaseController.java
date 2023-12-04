package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("empPurchase")
public class EmpPurchaseController {

	@Autowired
	PurchaseListService purchaseListService;	
	@RequestMapping("empPurchaseList")
	public String empPurchaseList(Model model) {
		purchaseListService.exeute(model);
		return "thymeleaf/empPurchase/purchaseList";
	}
}
