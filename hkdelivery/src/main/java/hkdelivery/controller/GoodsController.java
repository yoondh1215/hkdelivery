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
import org.springframework.web.bind.annotation.ResponseBody;

import hkdelivery.command.GoodsCommand;
import hkdelivery.service.goods.GoodsAutoNumService;
import hkdelivery.service.goods.GoodsDeleteService;
import hkdelivery.service.goods.GoodsInfoService;
import hkdelivery.service.goods.GoodsShopListService;
import hkdelivery.service.goods.GoodsWishListService;
import hkdelivery.service.goods.GoodsWishService;
import hkdelivery.service.goods.GoodsWriteService;
import hkdelivery.service.goods.WishDelService;
import hkdelivery.service.goods.WishGoodsDelsService;
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
	
	//shop이 상품상세를 보기 위한 기능
	@Autowired
	GoodsInfoService goodsInfoService;
	@GetMapping("goodsInfo")
	public String goodsInfo(@RequestParam("goodsNum") String goodsNum, Model model, HttpSession session) {
		goodsInfoService.execute(goodsNum, model, session);
		return "thymeleaf/goods/goodsInfo";
	}
	
	//member가 주문하기 위한 기능
	@GetMapping("goodsOrder")
	public String execute (@RequestParam("goodsNum") String goodsNum, Model model, HttpSession session) {
		goodsInfoService.execute(goodsNum, model, session);
		return "thymeleaf/goods/goodsOrder";
	}
	
	// goodsOrder 페이지에서 ajax로 위시리스트에 추가하라고 보냄
	// /goods/goodsOrder?goodsNum=good100001 
	// ajax에 0 또는 1을 전달해야 하므로 RestAPI 나 @ResponseBody 사용
	// 누구의 관심상품인지 알기 위해 로그인 정보가 필요하므로 session 추가.
	@Autowired
	GoodsWishService goodsWishService;
	@PostMapping("goodsWishAdd")
	public @ResponseBody String goodsWishAdd (@RequestParam("goodsNum") String goodsNum, HttpSession session) {
		return goodsWishService.execute(goodsNum, session);
	}
	
	@Autowired
	GoodsWishListService goodsWishListService;
	//index 페이지서 wishList로.
	@GetMapping("wishList")
	public String wishList(HttpSession session, Model model) {
		goodsWishListService.execute(session, model);
		return "thymeleaf/goods/wishList";
	}
	
	@Autowired
	WishGoodsDelsService wishGoodsDelsService;
	@PostMapping("goodsWishDels")
	public String goodsWishDels(@RequestParam("wishGoodsDel") String wishGoodsDels[], 
			HttpSession session) {
		wishGoodsDelsService.execute(wishGoodsDels, session);
		return "redirect:wishList";
	}
	
	@Autowired
	WishDelService wishDelService;
	@GetMapping("wishDel")
	public String wishDel (@RequestParam("goodsNum") String goodsNum, HttpSession session) {
		wishDelService.execute(goodsNum, session);
		return "redirect:wishList";
	}
	
}
