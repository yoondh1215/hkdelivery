package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkdelivery.service.purchase.PurchaseDetailService;
import hkdelivery.service.purchase.PurchaseListService;
import hkdelivery.service.purchase.PurchaseStatusService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("shopPurchase")
public class ShopPurchaseController {

	@Autowired
	PurchaseDetailService purchaseDetailService;
	@RequestMapping("purchaseDetail")
	public String purchaseDetail (@RequestParam(value="purchaseNum") String purchaseNum, HttpSession session, Model model) {
		purchaseDetailService.execute(purchaseNum, session, model);
		return "thymeleaf/purchase/purchaseDetail";
	}
	
	@Autowired
	PurchaseListService purchaseListService;	
	@RequestMapping("shopPurchaseList")
	public String empPurchaseList(HttpSession session, Model model) {
		purchaseListService.execute(session, model);
		return "thymeleaf/shopPurchase/purchaseList";
	}
	
	@Autowired
	PurchaseStatusService purchaseStatusService;
	@RequestMapping("purchaseStatus")
	public String purchaseStatus(String purchaseNum) {
		//purchaseStatusService.execute();
		return "redirect:purchaseList";
	}
	
}
