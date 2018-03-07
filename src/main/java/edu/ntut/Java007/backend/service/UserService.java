package edu.ntut.Java007.backend.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.pojo.User;
import edu.ntut.Java007.backend.persistence.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Returns a user by userCellphone or null if a user could not be found.
	 * @param userCellphone The userCellphone to be found
	 * @return A user by userCellphone or null if a user could not be found.
	 */
	public User findByUserCellphone(String userCellphone) {
		return userRepository.findByUserCellphone(userCellphone);
	}
	
	public User createUser(User user) {
		user.setUserCreateTime(new Date(System.currentTimeMillis()));
		user.setUserStatus("normal");
		user = userRepository.save(user);
		return user;
	}
}
