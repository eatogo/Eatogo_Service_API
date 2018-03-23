package edu.ntut.Java007.web.vo;

import java.io.Serializable;
import java.util.Date;

public class ReviewPayload implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	private Integer reviewId;
	
	private Integer reviewUser;
	
	private Integer reviewOrder;
	
	private Integer reviewFood;
	
	private Date reviewTime;
	
	private String reviewComment;

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getReviewUser() {
		return reviewUser;
	}

	public void setReviewUser(Integer reviewUser) {
		this.reviewUser = reviewUser;
	}

	public Integer getReviewOrder() {
		return reviewOrder;
	}

	public void setReviewOrder(Integer reviewOrder) {
		this.reviewOrder = reviewOrder;
	}

	public Integer getReviewFood() {
		return reviewFood;
	}

	public void setReviewFood(Integer reviewFood) {
		this.reviewFood = reviewFood;
	}

	public Date getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	
}