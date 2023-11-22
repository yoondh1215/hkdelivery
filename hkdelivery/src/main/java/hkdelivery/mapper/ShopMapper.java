package hkdelivery.mapper;

import org.apache.ibatis.annotations.Mapper;

import hkdelivery.command.ShopCommand;

@Mapper
public interface ShopMapper {

	public void shopInsert(ShopCommand shopCommand);
	public String shopAutoNum ();
}
