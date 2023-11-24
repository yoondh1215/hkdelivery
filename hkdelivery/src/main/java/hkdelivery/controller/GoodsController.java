package hkdelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkdelivery.command.GoodsCommand;
import hkdelivery.service.goods.GoodsAutoNumService;
import hkdelivery.service.goods.GoodsDeleteService;
import hkdelivery.service.goods.GoodsInfoService;
import hkdelivery.service.goods.GoodsShopListService;
import hkdelivery.service.goods.GoodsWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Autowired
	GoodsAutoNumService goodsAutoNumService;
	@GetMapping("goodsRegist")
	public String goodsRegist(Model model) {
		goodsAutoNumService.execute(model);
		return "thymeleaf/goods/goodsForm";
	}
	
	@Autowired
	GoodsWriteService goodsWriteService;
	@PostMapping("goodsSubmit")
	public String goodsSubmit(@Validated GoodsCommand goodsCommand, BindingResult result, HttpSession session, Model model) {
		if (result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		//메인이미지는 필수이므로 파일선택을 안 한 경우 경고 메시지
		//오류메시지는 string인데 파일은 파일객체라 문자열 인식 못해서 command에 오류메시지 설정 불가.
		if (goodsCommand.getGoodsMain().isEmpty()) {
			result.rejectValue("goodsMain", "goodsCommand.goodsMain", "대문이미지를 선택해주세요");
			return "thymeleaf/goods/goodsForm"; //오류메시지를 보내기 위해 현재 페이지를 열어 줌
		}
		
		goodsWriteService.execute(goodsCommand, session);
		goodsShopListService.execute(model, session);
		return "thymeleaf/goods/goodsList";
	}
	
	@Autowired
	GoodsShopListService goodsShopListService;
	@GetMapping("goodsList")
	public String goodsList(Model model, HttpSession session) {
		goodsShopListService.execute(model, session);
		return "thymeleaf/goods/goodsList";
	}
	
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@PostMapping("goodsDelete")	//체크박스에 의하 받은 값을 배열로 받는다.
	public String goodsDelete (@RequestParam(value="checkBox") String checkBox[] ) {
		goodsDeleteService.execute(checkBox);
		return "redirect:goodsList";
	}
	
	@Autowired
	GoodsInfoService goodsInfoService;
	@GetMapping("goodsInfo")
	public String goodsInfo(@RequestParam("goodsNum") String goodsNum, Model model, HttpSession session) {
		goodsInfoService.execute(goodsNum, model, session);
		return "thymeleaf/goods/goodsInfo";
	}
	
}
