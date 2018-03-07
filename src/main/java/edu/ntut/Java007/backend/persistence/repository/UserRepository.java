package edu.ntut.Java007.backend.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.pojo.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, String> {

	/**
	 * Returns a User given a cellphone or null if not found.
	 * @param user_cellphone The user's cellphone
	 * @return a User given a cellphone or null if not found.
	 */
	User findByUserCellphone(String userCellphone);
	
}
