package com.gn.mapper;

import com.gn.dto.Member;


public interface MemberMapper {
	int insertMember(Member member);
	
	Member selectMember(Member member);
}
