package com.gn.service;


import java.util.List;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MemberService {
	
	private MemberDao dao = new MemberDao();
	
	public int insertMember(String id, String pw) {
		Member member = new Member();
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		return dao.insert(member);
	}
	
	public Member selectMember(String memberId, String memberPw) {
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		Member result = dao.login(member);
		return result;
	}

}
