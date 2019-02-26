package com.bjdvt.wx.controller.vo;

public class GamResult {

	private Integer  skimNum;
	private Integer  upvoteNum;
	private Integer  shareNum;
	private boolean  upvote;
	private Integer  messageNum;
	private	boolean isNew;
	
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public Integer getSkimNum() {
		return skimNum;
	}
	public void setSkimNum(Integer skimNum) {
		this.skimNum = skimNum;
	}
	public Integer getUpvoteNum() {
		return upvoteNum;
	}
	public void setUpvoteNum(Integer upvoteNum) {
		this.upvoteNum = upvoteNum;
	}
	public Integer getShareNum() {
		return shareNum;
	}
	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}
	public boolean isUpvote() {
		return upvote;
	}
	public void setUpvote(boolean upvote) {
		this.upvote = upvote;
	}
	public Integer getMessageNum() {
		return messageNum;
	}
	public void setMessageNum(Integer messageNum) {
		this.messageNum = messageNum;
	}
	
	
	
}
