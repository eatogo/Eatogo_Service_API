package edu.ntut.Java007.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ntut.Java007.backend.persistence.po.Favorite;
import edu.ntut.Java007.backend.persistence.po.Food;
import edu.ntut.Java007.backend.service.FavoriteService;
import edu.ntut.Java007.backend.service.FoodService;

@RestController
@RequestMapping("/store/statistic")
public class StoreStatisticController {
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private FavoriteService favoriteService;

	private Map<String, Object> returnJson;
	
	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/likes/{storeId}")
	public Map<String, Object> getLikes(@PathVariable Integer storeId) {
		returnJson = new HashMap<>();
		List<Food> menu = foodService.findMenuByStoreId(storeId);
		if (menu != null && menu.size() > 0) {
			Long likes = 0L;
			for (Food food : menu) {
				likes += food.getFoodReviewCount();
			}
			returnJson.put("likes", likes);
			returnJson.put("status", 200);
		} else {
			returnJson.put("likes", 0);
			returnJson.put("status", 200);
		}
		return returnJson;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/favorites/{storeId}")
	public Map<String, Object> getFavorites(@PathVariable Integer storeId) {
		returnJson = new HashMap<>();
		List<Food> menu = foodService.findMenuByStoreId(storeId);
		if (menu != null && menu.size() > 0) {
			Long favs = 0L;
			for (Food food : menu) {
				List<Favorite> favorites = favoriteService.findFavoriteByFavoriteFood(food.getFoodId());
				favs += favorites.size();
			}
			returnJson.put("likes", favs);
			returnJson.put("status", 200);
		} else {
			returnJson.put("favorites", 0);
			returnJson.put("status", 200);
		}
		return returnJson;
	}
}
