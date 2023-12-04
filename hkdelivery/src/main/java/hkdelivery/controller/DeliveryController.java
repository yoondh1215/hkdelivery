package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkdelivery.command.DeliveryCommand;
import hkdelivery.service.delivery.DeliveryDeleteService;
import hkdelivery.service.delivery.DeliveryInsertService;

@Controller
@RequestMapping("delivery")
public class DeliveryController {

	@Autowired
	DeliveryInsertService deliveryInsertService;
	@PostMapping("deliveryAction")
	public String deliveryAction (DeliveryCommand deliveryCommand) {
		deliveryInsertService.execute(deliveryCommand);
		return "redirect:/purchase/purchaseDetail?purcahseNum="+deliveryCommand.getPurchaseNum();
	}
	
	@Autowired
	DeliveryDeleteService deliveryDeleteService;
	@PostMapping("deliveryDel")
	public String deliveryDel(@RequestParam("purchaseNum") String purchaseNum) {
		deliveryDeleteService.execute(purchaseNum);
		return "redirect:/purchase/purchaseDetail?purchaseNum="+purchaseNum;
	}
	
}
