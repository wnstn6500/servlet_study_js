package com.gn.dto;

import com.gn.common.vo.Paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor

@AllArgsConstructor
@Data
public class Board extends Paging{
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	
	private String regDate;
	private String modDate;
	
	private String memberId;
	private String keyword;
}
