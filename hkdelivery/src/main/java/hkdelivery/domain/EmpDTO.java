package hkdelivery.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias("emp")
public class EmpDTO {
	
	String empNum;
	String empId;
	String empPw;
	String empName;
	String empAddr;
	String empAddrDetail;
	Integer empPost;
	Date empRegiDate;
	String empPhone;
	String empEmail;
	String empJumin;
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpPw() {
		return empPw;
	}
	public void setEmpPw(String empPw) {
		this.empPw = empPw;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public String getEmpAddrDetail() {
		return empAddrDetail;
	}
	public void setEmpAddrDetail(String empAddrDetail) {
		this.empAddrDetail = empAddrDetail;
	}
	public Integer getEmpPost() {
		return empPost;
	}
	public void setEmpPost(Integer empPost) {
		this.empPost = empPost;
	}
	public Date getEmpRegiDate() {
		return empRegiDate;
	}
	public void setEmpRegiDate(Date empRegiDate) {
		this.empRegiDate = empRegiDate;
	}
	public String getEmpPhone() {
		return empPhone;
	}
	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpJumin() {
		return empJumin;
	}
	public void setEmpJumin(String empJumin) {
		this.empJumin = empJumin;
	}


}
