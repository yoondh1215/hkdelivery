package hkdelivery.mapper;

import org.apache.ibatis.annotations.Mapper;

import hkdelivery.domain.MemberDTO;

@Mapper
public interface MemberMapper {

	public void memberInsert(MemberDTO dto);
	public String memberAutoNum();
	public String getMemberNum(String id);
	public MemberDTO selectMemberInfo(String memberNum);
}
