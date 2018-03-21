package edu.ntut.Java007.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
