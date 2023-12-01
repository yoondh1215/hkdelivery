package hkdelivery.mapper;

import org.apache.ibatis.annotations.Mapper;

import hkdelivery.domain.EmpDTO;

@Mapper
public interface EmployeeMapper {

	//직원 생성
	public String empAutoNum();
	public void empRegist(EmpDTO dto);
	
	
	//직원 읽기
	public String getEmpNum(String empId);
	public EmpDTO empRead(String empNum);
	
	//직원 업데이트
	
}
