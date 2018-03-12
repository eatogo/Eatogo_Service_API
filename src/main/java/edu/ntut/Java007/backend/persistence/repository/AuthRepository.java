package edu.ntut.Java007.backend.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.pojo.Auth;

@Repository
@Transactional
public interface AuthRepository extends CrudRepository<Auth, Integer> {

	Auth findByUserUuid(String userUuid);
	
	Auth findByUserId(Integer userId);
}
