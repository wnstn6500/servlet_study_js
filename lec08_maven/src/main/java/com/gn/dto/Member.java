package com.gn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Member {
	private int memberNo;
	private String memberId;
	private String memberPw;
	
}
