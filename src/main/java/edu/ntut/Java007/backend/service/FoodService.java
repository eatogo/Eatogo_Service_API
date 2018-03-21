package edu.ntut.Java007.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.Food;
import edu.ntut.Java007.backend.persistence.repository.FoodRepository;

@Service
@Transactional
public class FoodService {

	@Autowired
	private FoodRepository foodRepository;
	
	public List<Food> findMenuByStoreId(Integer storeId) {
		return foodRepository.findByFoodStore(storeId);
	}
}
