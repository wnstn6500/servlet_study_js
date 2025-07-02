package com.gn.mapper;

import java.util.List;

import com.gn.dto.Member;


public interface MemberMapper {
	List<Member> insertMember(Member member);
}
