package edu.ntut.Java007.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.Favorite;
import edu.ntut.Java007.backend.persistence.repository.FavoriteRepository;

@Service
@Transactional
public class FavoriteService {

	@Autowired
	private FavoriteRepository favoriteRepository;
	
	public List<Favorite> findFavoriteByFavoriteFood(Integer foodId) {
		return favoriteRepository.findByFavoriteFood(foodId);
	}
}
