package edu.ntut.Java007.backend.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, String> {

	User findByUserCellphone(String userCellphone);
	
	User findByUserId(Integer userId);
	
}
