package hkdelivery.service.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkdelivery.command.ShopCommand;
import hkdelivery.mapper.ShopMapper;

@Service
public class ShopInsertService {

	@Autowired
	ShopMapper shopMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public void execute (ShopCommand shopCommand) {
		//dto를 써야 하지만 커맨드랑 완전 동일해서 생략.
		String shopPw = passwordEncoder.encode(shopCommand.getShopPw());
		shopCommand.setShopPw(shopPw);
		shopMapper.shopInsert(shopCommand);
	};
}
