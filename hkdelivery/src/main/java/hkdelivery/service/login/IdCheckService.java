package hkdelivery.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkdelivery.mapper.LoginMapper;

@Service
public class IdCheckService {

	@Autowired
	LoginMapper loginMapper;
	public String execute (String memberId) {
		String resultId = loginMapper.selectIdCheck(memberId);
		return resultId;
	}
}
