package edu.ntut.Java007.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.Review;
import edu.ntut.Java007.backend.persistence.repository.ReviewRepository;

@Service
@Transactional
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	public List<Review> findByReviewUser(Integer userId) {
		return reviewRepository.findByReviewUser(userId);
	}
	
	public List<Review> findByReviewFood(Integer foodId) {
		return reviewRepository.findByReviewFood(foodId);
	}

}
