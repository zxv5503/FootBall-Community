package com.fbc.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.fbc.dto.Member;

@Mapper
public interface MemberMapper {
	
	List<Member> selectMemberList();
	
	void insertMember(Member member);
	
	Member memberByEmail(String email);
	
	int updateMember(Member member);

}
