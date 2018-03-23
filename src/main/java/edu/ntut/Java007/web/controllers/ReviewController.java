package edu.ntut.Java007.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ntut.Java007.backend.persistence.po.Food;
import edu.ntut.Java007.backend.persistence.po.Review;
import edu.ntut.Java007.backend.persistence.po.User;
import edu.ntut.Java007.backend.service.FoodService;
import edu.ntut.Java007.backend.service.ReviewService;
import edu.ntut.Java007.backend.service.UserService;
import edu.ntut.Java007.utils.ReviewUtils;
import edu.ntut.Java007.web.vo.ReviewPayload;

@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private ObjectMapper mapper;

	private Map<String, Object> returnJson;
	
	@GetMapping("/user/{userId}")
	public Map<String, Object> getReviewByUser(@PathVariable Integer userId) throws JsonProcessingException {
		returnJson = new HashMap<>();
		User user = userService.findByUserId(userId);
		if (user != null) {
			List<Review> reviewList = reviewService.findByReviewUser(userId);
			List<ReviewPayload> reviews = new ArrayList<>();
			for (Review review : reviewList) {
				ReviewPayload payload = ReviewUtils.fromDomainReviewToWebReviewPayload(review);
				reviews.add(payload);
			}
			String jsonInString = mapper.writeValueAsString(reviews);
			returnJson.put("status", 200);
			returnJson.put("reviewPayload", jsonInString);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
	
	@GetMapping("/food/{foodId}")
	public Map<String, Object> getReviewByFood(@PathVariable Integer foodId) throws JsonProcessingException {
		returnJson = new HashMap<>();
		Food food = foodService.findFoodByFoodId(foodId);
		if (food != null) {
			List<Review> reviewList = reviewService.findByReviewFood(foodId);
			List<ReviewPayload> reviews = new ArrayList<>();
			for (Review review : reviewList) {
				ReviewPayload payload = ReviewUtils.fromDomainReviewToWebReviewPayload(review);
				reviews.add(payload);
			}
			String jsonInString = mapper.writeValueAsString(reviews);
			returnJson.put("status", 200);
			returnJson.put("reviewPayload", jsonInString);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
}
