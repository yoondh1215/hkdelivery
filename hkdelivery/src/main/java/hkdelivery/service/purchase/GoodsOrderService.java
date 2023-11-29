package hkdelivery.service.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.command.PurchaseCommand;
import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.CartDTO;
import hkdelivery.domain.PurchaseDTO;
import hkdelivery.domain.PurchaseListDTO;
import hkdelivery.mapper.CartMapper;
import hkdelivery.mapper.MemberMapper;
import hkdelivery.mapper.PurchaseMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsOrderService {

	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PurchaseMapper purchaseMapper;
	@Autowired
	CartMapper cartMapper;
	public String execute (PurchaseCommand purchaseCommand, HttpSession session, Model model) {
		
		AuthInfoDTO authInfo = (AuthInfoDTO)session.getAttribute("auth");
		String memberNum = memberMapper.getMemberNum(authInfo.getId()); 
		
		//purchaseNum은 AutoNum을 따로 만들지 않고 바로 여기서 selectNum 할 때 mapper에서 만들어 주겠음.
		String purchaseNum = purchaseMapper.selectNum();
		
		//command의 상품번호를 split()해서 배열로 받아온다.
		String [] goodsNums = purchaseCommand.getGoodsNums().split("-");
		 
		//각각의 정보들을 구매dto제 저장
		PurchaseDTO dto = new PurchaseDTO();
		dto.setPurchaseNum(purchaseNum);
		dto.setPurchaseName(purchaseNum);
		dto.setDeliveryName(purchaseCommand.getDeliveryName());
		dto.setMemberNum(memberNum);
		dto.setPurchaseAddr(purchaseCommand.getDeliveryAddr());
		dto.setPurchaseAddrDetail(purchaseCommand.getDeliveryAddrDetail());
		dto.setPurchasePhone(purchaseCommand.getDeliveryPhone());
		dto.setPurchasePost(purchaseCommand.getDeliveryPost());
		dto.setPurchaseMessage(purchaseCommand.getMessage());
		dto.setPurchasePrice(purchaseCommand.getSumPrice());
		dto.setPurchaseStatus("입금 대기중");
		
		//구매정보를 테이블에 저장
		purchaseMapper.purchaseInsert(dto);
		
		//구매한 상품의 정보를 입력
		PurchaseListDTO plDto = new PurchaseListDTO();
		plDto.setGoodsNums(goodsNums);
		plDto.setMemberNum(memberNum);
		plDto.setPurchaseNum(purchaseNum);
		
		purchaseMapper.purchaseListInsert(plDto);
		
		//cart의 정보가 purchaseList로 이동했으면 cart의 기존 정보는 삭제
		CartDTO cartDto = new CartDTO();
		cartDto.setMemberNum(memberNum);
		cartDto.setGoodsNums(goodsNums);
		cartMapper.cartGoodsDeletes(cartDto);
		
		return purchaseNum;
	}
}
