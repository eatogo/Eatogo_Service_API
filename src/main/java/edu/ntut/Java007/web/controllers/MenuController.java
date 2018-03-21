package edu.ntut.Java007.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ntut.Java007.backend.persistence.po.Food;
import edu.ntut.Java007.backend.service.FoodService;
import edu.ntut.Java007.utils.FoodUtils;
import edu.ntut.Java007.web.vo.MenuPayload;

@RestController
@RequestMapping("/store/menu")
public class MenuController {
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private ObjectMapper mapper;
	
	private Map<String, Object> returnJson;

	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/{storeId}")
	public Map<String, Object> getMenu(@PathVariable Integer storeId) throws JsonProcessingException {
		returnJson = new HashMap<String, Object>();
		List<Food> menu = foodService.findMenuByStoreId(storeId);
		List<MenuPayload> payloads = new ArrayList<>();
		
		if (menu != null) {
			for (Food food : menu) {
				MenuPayload payload = FoodUtils.fromDomainFoodToWebMenuPayload(food);
				payloads.add(payload);
			}
			String jsonInString = mapper.writeValueAsString(payloads);
			returnJson.put("menuPayload", jsonInString);
			returnJson.put("status", 200);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/food/{foodId}")
	public Map<String, Object> getFood(@PathVariable Integer foodId) throws JsonProcessingException {
		returnJson = new HashMap<String, Object>();
		Food food = foodService.findFoodByFoodId(foodId);
		if (food != null) {
			MenuPayload payload = FoodUtils.fromDomainFoodToWebMenuPayload(food);
			String jsonInString = mapper.writeValueAsString(payload);
			returnJson.put("foodPayload", jsonInString);
			returnJson.put("status", 200);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@PostMapping("/food/{storeId}")
	public Map<String, Object> createFood(@PathVariable Integer storeId, MenuPayload payload) throws JsonProcessingException {
		returnJson = new HashMap<String, Object>();
		Food food = FoodUtils.fromWebMenuPayloadToDomainFood(payload);
		food.setFoodStore(storeId);
		food = foodService.createFood(food);
		if (food != null) {
			payload = FoodUtils.fromDomainFoodToWebMenuPayload(food);
			String jsonInString = mapper.writeValueAsString(payload);
			returnJson.put("foodPayload", jsonInString);
			returnJson.put("status", 200);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@PutMapping("/food")
	public Map<String, Object> editFood(MenuPayload payload) throws JsonProcessingException {
		returnJson = new HashMap<String, Object>();
		Food food = foodService.findFoodByFoodId(payload.getFoodId());
		if (food != null) {
			food = FoodUtils.fromWebMenuEditPayloadToDomainFood(payload, food);
			food = foodService.updateFood(food);
			payload = FoodUtils.fromDomainFoodToWebMenuPayload(food);
			String jsonInString = mapper.writeValueAsString(payload);
			returnJson.put("foodPayload", jsonInString);
			returnJson.put("status", 200);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
}
