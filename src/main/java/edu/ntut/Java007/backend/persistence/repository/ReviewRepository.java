package edu.ntut.Java007.backend.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.Review;

@Repository
@Transactional
public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
	public List<Review> findByReviewUser(Integer reviewUser);
	
	public List<Review> findByReviewFood(Integer reviewFood);

}
