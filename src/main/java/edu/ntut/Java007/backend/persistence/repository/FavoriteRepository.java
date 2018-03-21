package edu.ntut.Java007.backend.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ntut.Java007.backend.persistence.po.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

	public List<Favorite> findByFavoriteFood(Integer favoriteFood);
}
