package com.spring.board.vo;

public class PageVo {
	
	private int pageNo = 0;

	private String boardType="";
	private String [] chk;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String [] getChk() {
		return chk;
	}

	public void setChk(String [] chk) {
		this.chk = chk;
	}

	

	
	
}
