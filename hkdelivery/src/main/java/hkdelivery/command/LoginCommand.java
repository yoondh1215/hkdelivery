package hkdelivery.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginCommand {

	@NotBlank(message = "아이디를 입력해주세요")
	String id; 
	@NotEmpty(message = "비밀번호를 입력해주세요")
	@Size(min = 5, max = 20)
	String password;
	
	

	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
