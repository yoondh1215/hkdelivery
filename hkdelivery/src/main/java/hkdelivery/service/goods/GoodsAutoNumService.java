package hkdelivery.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkdelivery.command.GoodsCommand;
import hkdelivery.mapper.GoodsMapper;

@Service
public class GoodsAutoNumService {

	@Autowired
	GoodsMapper goodsMapper;
	public void execute (Model model) {
		GoodsCommand goodsCommand = new GoodsCommand();
		String goodsNum = goodsMapper.goodsAutoNum();
		goodsCommand.setGoodsNum(goodsNum);
		model.addAttribute("goodsCommand", goodsCommand);
	}
}
