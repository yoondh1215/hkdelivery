package hkdelivery.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface LoginMapper {

	public String selectIdCheck (String memberId);
}
