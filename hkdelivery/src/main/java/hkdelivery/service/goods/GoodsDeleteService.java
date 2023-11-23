package hkdelivery.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.mapper.GoodsMapper;

@Service
public class GoodsDeleteService {

	@Autowired
	GoodsMapper goodsMapper;
	public void execute (String checkBox[]) {
		goodsMapper.goodsDelete(checkBox);
		
	}
}
