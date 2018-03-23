package edu.ntut.Java007.utils;

import edu.ntut.Java007.backend.persistence.po.Review;
import edu.ntut.Java007.web.vo.ReviewPayload;

public class ReviewUtils {

	public static ReviewPayload fromDomainReviewToWebReviewPayload(Review review) {
		ReviewPayload payload = new ReviewPayload();
		payload.setReviewId(review.getReviewId());
		payload.setReviewUser(review.getReviewUser());
		payload.setReviewOrder(review.getReviewOrder());
		payload.setReviewFood(review.getReviewFood());
		payload.setReviewTime(review.getReviewTime());
		payload.setReviewComment(review.getReviewComment());
		return payload;
	}
}
