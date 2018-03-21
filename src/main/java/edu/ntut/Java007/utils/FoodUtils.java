package edu.ntut.Java007.utils;

import edu.ntut.Java007.backend.persistence.po.Food;
import edu.ntut.Java007.web.vo.MenuPayload;

public class FoodUtils {
	
	private FoodUtils() {};
	
	public static MenuPayload fromDomainFoodToWebMenuPayload(Food food) {
		MenuPayload payload = new MenuPayload();
		payload.setFoodId(food.getFoodId());
		payload.setFoodName(food.getFoodName());
		payload.setFoodPrice(food.getFoodPrice());
		payload.setFoodLimit(food.getFoodLimit());
		payload.setFoodIntro(food.getFoodIntro());
		payload.setFoodPicMdpi(food.getFoodPicMdpi());
		payload.setFoodType(food.getFoodType());
		return payload;
	}

	public static Food fromWebMenuPayloadToDomainFood(MenuPayload payload) {
		Food food = new Food();
		food.setFoodName(payload.getFoodName());
		food.setFoodPrice(payload.getFoodPrice());
		food.setFoodLimit(payload.getFoodLimit());
		food.setFoodType(payload.getFoodType());
		food.setFoodIntro(payload.getFoodIntro());
		return food;
	}
	
	public static Food fromWebMenuEditPayloadToDomainFood(MenuPayload payload, Food food) {
		food.setFoodName(payload.getFoodName());
		food.setFoodPrice(payload.getFoodPrice());
		food.setFoodLimit(payload.getFoodLimit());
		food.setFoodType(payload.getFoodType());
		food.setFoodIntro(payload.getFoodIntro());
		return food;
	}
}
