package hkdelivery.service.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.mapper.ShopMapper;

@Service
public class ShopAutoNumService {

	@Autowired
	ShopMapper shopMapper;
	public String execute () {
		String shopNum = shopMapper.shopAutoNum();
		return shopNum;
	}
}
