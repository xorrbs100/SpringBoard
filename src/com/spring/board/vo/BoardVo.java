package com.spring.board.vo;

public class BoardVo {
	ComVo comvo=new ComVo();
	private String 	boardType;
	private int 	boardNum;
	private String 	boardTitle;
	private String 	boardComment;
	private String 	creator;
	private String	modifier;
	private String boardAsType;
	private int totalCnt;
	private String [] chk;
	
	
	
	
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
		if(boardType.equals(comvo.getCodeId())) {
			this.boardType=comvo.getCodeName();
		}
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardComment() {
		return boardComment;
	}
	public void setBoardComment(String boardComment) {
		this.boardComment = boardComment;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getModifier() {
		return modifier;
	}
	public void setModifier(String modifier) {
		this.modifier = modifier;
	}
	public String getBoardAsType() {
		return boardAsType;
	}
	public void setBoardAsType(String boardAsType) {
		this.boardAsType = boardAsType;
	}
	public String [] getChk() {
		return chk;
	}
	public void setChk(String [] chk) {
		this.chk = chk;
	}
	
	
	
	
}
