package hkdelivery.service.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.command.ShopCommand;
import hkdelivery.mapper.ShopMapper;

@Service
public class ShopInsertService {

	@Autowired
	ShopMapper shopMapper;
	public void execute (ShopCommand shopCommand) {
		shopMapper.shopInsert(shopCommand);
	};
}
