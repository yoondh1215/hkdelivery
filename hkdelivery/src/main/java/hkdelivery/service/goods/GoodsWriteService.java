package hkdelivery.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.command.GoodsCommand;
import hkdelivery.domain.AuthInfoDTO;
import hkdelivery.domain.GoodsDTO;
import hkdelivery.mapper.GoodsMapper;
import hkdelivery.mapper.ShopMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsWriteService {

	@Autowired
	ShopMapper shopMapper;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute (GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsImage(goodsCommand.getGoodsImage());
		dto.setGoodsImageOrg(goodsCommand.getGoodsImageOrg());
		dto.setGoodsMain(goodsCommand.getGoodsMain());
		dto.setGoodsMainOrg(goodsCommand.getGoodsMainOrg());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		
		AuthInfoDTO auth = (AuthInfoDTO)session.getAttribute("auth");
		//auth에는 id pw grade 뿐이라 shopNum을 가져오기 위해 shopMapper에 추가.
		String shopNum = shopMapper.getShopNum(auth.getId());
		dto.setShopNum(shopNum);
		
		goodsMapper.goodsInsert(dto);
		
	
	}
}
