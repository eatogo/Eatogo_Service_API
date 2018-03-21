package edu.ntut.Java007.backend.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ntut.Java007.backend.persistence.po.Food;

public interface FoodRepository extends JpaRepository<Food, Integer> {

	public List<Food> findByFoodStore(Integer foodStore);
}
