package hkdelivery.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


public class MemberCommand {

	//Validation을 커맨드에서 해주기로 했다.
	//String 자료형에선 @NotEmpty, @NotBlank를 사용한다.
	//String 외 모든 자료형은 @NotNull 을 사용한다.
	//BingdingResult 로 전달할 오류메시지도 작성해준다.
	String memberNum;
	@NotEmpty(message = "아이디를 입력해 주세요")
	String memberId;
	//비밀번호는 패턴을 사용해야 한다. 영문, 특수문자, 숫자의 6글자 이상으로 설정하겠다.
	@Pattern (regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#!@$%^&*-+?~]).{6,}$",
			message = "영문, 특수문자, 숫자를 포함한 6글자 이상만 가능합니다")
	String memberPw;
	@NotBlank(message = "비밀번호 확인을 입력해주세요")
	String memberPwCheck;
	@NotBlank(message = "이름을 입력하여 주세요.")
	String memberName;
	String memberAddr;
	String memberAddrDetail;
	String memberPost;
	String memberGender;
	String memberPhone;
	String memberEmail;
	//문자형 날짜를 형변환하기
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "생년월일을 입력해주세요")
	Date memberBirth;
	//나중에 사용할 수 있으니 가입일 메서도드 추가
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberRegiDate;
	
	//비밀번호 확인과 비밀번호가 일치하는지 확인하기 위한 메서드
		public boolean isMemberPwEqualsMemberPwCheck() {
			return memberPw.equals(memberPwCheck);
		}
	
	
	public Date getMemberRegiDate() {
		return memberRegiDate;
	}
	public void setMemberRegiDate(Date memberRegiDate) {
		this.memberRegiDate = memberRegiDate;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberPwCheck() {
		return memberPwCheck;
	}
	public void setMemberPwCheck(String memberPwCheck) {
		this.memberPwCheck = memberPwCheck;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberAddrDetail() {
		return memberAddrDetail;
	}
	public void setMemberAddrDetail(String memberAddrDetail) {
		this.memberAddrDetail = memberAddrDetail;
	}
	public String getMemberPost() {
		return memberPost;
	}
	public void setMemberPost(String memberPost) {
		this.memberPost = memberPost;
	}
	public String getMemberGender() {
		return memberGender;
	}
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public Date getMemberBirth() {
		return memberBirth;
	}
	public void setMemberBirth(Date memberBirth) {
		this.memberBirth = memberBirth;
	}
	
	
	
}
