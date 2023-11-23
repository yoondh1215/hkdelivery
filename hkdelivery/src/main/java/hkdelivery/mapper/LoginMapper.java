package hkdelivery.mapper;

import org.apache.ibatis.annotations.Mapper;

import hkdelivery.domain.AuthInfoDTO;

@Mapper
public interface LoginMapper {

	public String selectIdCheck (String memberId);
	public AuthInfoDTO loginSelect(String shopNum);
	
}
