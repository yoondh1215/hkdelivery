package hkdelivery.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.inicis.std.util.SignatureUtil;

import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.PurchaseDTO;
import hkdelivery.mapper.MemberMapper;
import hkdelivery.mapper.PurchaseMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IniPayReqService {

	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	MemberMapper memberMapper;												//throws Exception 을 해서 오류발생시 controller로 던지고 컨트롤러에서 예외처리.
	public void execute (String purchaseNum, Model model, HttpSession session) throws Exception {
		
		//1. 구매 정보 가져오기
		PurchaseDTO dto = purchaseMapper.purchaseSelect(purchaseNum);
		
		//2.이니시스에서 요구하는 메일 정보
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		// 이건 항상 쓰던건데 일단 필요없음 String memberNum = memberMapper.getMemberNum(authInfo.getId()); 
		String buyerEmail = authInfo.getEmail();
		
		//구매 상품 갯수와 구매한 상품 중 하나의 이름을 이용해 purchase_name 으로 사용할 것임
		//상품A 외 n개 이런 식으로 표현하기 위해서임.
		int cnt = purchaseMapper.purchaseGoodsCount(purchaseNum);
		String goodsNum = purchaseMapper.firstGoods(purchaseNum);
		//두 개를 합쳐서 구매이름 만들기
		String purchaseName = goodsNum + "외" + String.valueOf(cnt -1);
		
		//이니시스에서 받아온 코드 중 필요한 부분만 수정해서 추가
		String mid					= "INIpayTest";		                    // 상점아이디					
		String signKey			    = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";	// 웹 결제 signkey
		
		//SignatureUtil은 이니페이의 외부 모듈로 build.gradle 에서 불러와야 함.
		String mKey = SignatureUtil.hash(signKey, "SHA-256");

		String timestamp			= SignatureUtil.getTimestamp();			// util에 의해서 자동생성
		String orderNumber			= purchaseNum;	// 가맹점 주문번호(가맹점에서 직접 설정)
		String price				= dto.getPurchasePrice().toString();								// 상품가격(특수기호 제외, 가맹점에서 직접 설정)

		Map<String, String> signParam = new HashMap<String, String>();

		signParam.put("oid", orderNumber);
		signParam.put("price", price);
		signParam.put("timestamp", timestamp);

		String signature = SignatureUtil.makeSignature(signParam);
		//결제시 필요한 내용들로 이니시스에서 준 변수명을 그대로 사용.
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("mid", mid);
		model.addAttribute("signature", signature);
		model.addAttribute("orderNumber", orderNumber);
		model.addAttribute("mKey", mKey);
		model.addAttribute("purchaseName", purchaseName);
		model.addAttribute("price", price);
		model.addAttribute("buyername", dto.getDeliveryName());
		model.addAttribute("buyertel", dto.getPurchasePhone());
		model.addAttribute("buyeremail", buyerEmail);
		
	}
	
}
