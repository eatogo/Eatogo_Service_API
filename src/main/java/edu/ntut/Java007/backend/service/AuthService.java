package edu.ntut.Java007.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.Auth;
import edu.ntut.Java007.backend.persistence.repository.AuthRepository;

@Service
@Transactional
public class AuthService {
	
	@Autowired
	private AuthRepository authRepository;
	
	public Auth findByUserUuid(String userUuid) {
		return authRepository.findByUserUuid(userUuid);
	}
	
	public Auth findByUserId(Integer userId) {
		return authRepository.findByUserId(userId);
	}
	
	public Auth createAuth(Auth auth) {
		return authRepository.save(auth);
	}
	
	public void deleteAuth(Auth auth) {
		authRepository.delete(auth);
	}

}
