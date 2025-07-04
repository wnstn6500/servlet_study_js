package com.gn.dto;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class Attach {
	private int attachNo;
	private int boardNo;
	private String oriName;
	private String reName;
	private String regDate;
}
