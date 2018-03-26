package edu.ntut.Java007.backend.persistence.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEWS")
public class Review implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "review_id")
	private Integer reviewId;
	
	@Column(name = "review_user")
	private Integer reviewUser;
	
	@Column(name = "review_order")
	private Integer reviewOrder;
	
	@Column(name = "review_food")
	private Integer reviewFood;
	
	@Column(name = "review_time")
	private Date reviewTime;
	
	@Column(name = "review_comment")
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Review [reviewId=").append(reviewId).append(", reviewUser=").append(reviewUser)
				.append(", reviewOrder=").append(reviewOrder).append(", reviewFood=").append(reviewFood)
				.append(", reviewTime=").append(reviewTime).append(", reviewComment=").append(reviewComment)
				.append("]");
		return builder.toString();
	}

}