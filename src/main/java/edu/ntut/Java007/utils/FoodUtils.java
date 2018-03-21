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
		return payload;
	}

}
