package edu.ntut.Java007.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.pojo.Auth;
import edu.ntut.Java007.backend.persistence.repository.AuthRepository;

@Service
@Transactional
public class AuthService {
	
	@Autowired
	AuthRepository authRepository;
	
	public Auth findByUserUuid(String userUuid) {
		return authRepository.findByUserUuid(userUuid);
	}
	
	public Auth createAuth(Auth auth) {
		return authRepository.save(auth);
	}

}
