package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkdelivery.command.PurchaseCommand;
import hkdelivery.service.IniPayReqService;
import hkdelivery.service.purchase.GoodsBuyService;
import hkdelivery.service.purchase.GoodsOrderService;
import hkdelivery.service.purchase.IniPayReturnService;
import hkdelivery.service.purchase.OrderProcessListService;
import hkdelivery.service.purchase.PaymentDeleteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("purchase")
public class PurchaseController {

	@Autowired
	GoodsBuyService goodsBuyService;
	@RequestMapping("goodsBuy")
	public String goodsBuy(@RequestParam(value="prodCk") String [] prodCk,	//checkbox를 배열로 전환
			HttpSession session, Model model) {
		goodsBuyService.execute(prodCk, session, model);
		return "thymeleaf/purchase/goodsOrder";
	}
	
	@Autowired
	GoodsOrderService goodsOrderService;
	@PostMapping("goodsOrder")
	public String goodsOrder(PurchaseCommand purchaseCommand, HttpSession session, Model model) {
		
		System.out.println("purchase/goodsOrder 링크가 맞는지 확인용임.");
		
		String purchaseNum = goodsOrderService.execute(purchaseCommand, session, model);
		
		return "redirect:paymentOk?purchaseNum="+purchaseNum;
	}
	
	@Autowired
	IniPayReqService iniPayReqService;
	@GetMapping("paymentOk")
	public String paymentOk(@RequestParam("purchaseNum") String purchaseNum, 
							HttpSession session, Model model) {
		
		try { 	//서비스에서 예외를 컨트롤러로 throws 했으므로 여기서 트라이 캐치로 처리
			iniPayReqService.execute(purchaseNum, model, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//결제 페이지로 이동
		return "thymeleaf/purchase/payment";
	}
	
	@Autowired
	IniPayReturnService iniPayReturnService;
	@PostMapping("INIstdpay_pc_return")
	public String payReturn (HttpServletRequest request, HttpSession session, Model model) {
		iniPayReturnService.execute(request, session, model);
		return "thymeleaf/purchase/buyfinished";
	}
	
	@GetMapping("close")
	public String close() {
		return "thymeleaf/purchase/close";
	}
	
	@Autowired
	OrderProcessListService orderProcessListService;
	//인덱스에서 회원이 누른 주문목록
	@RequestMapping("orderList")
	public String orderList(HttpSession session, Model model) {
		orderProcessListService.execute(session, model);
		return "thymeleaf/purchase/orderList";
	}
	
	//orderList.html에서 결제 취소
	@Autowired
	PaymentDeleteService paymentDeleteService;
	@RequestMapping("paymentDel")
	public String execute (@RequestParam("puchaseNum") String purchaseNum) {
		paymentDeleteService.execute(purchaseNum);
		return "redirect:orderList";
	}
	
	
	
	
}
