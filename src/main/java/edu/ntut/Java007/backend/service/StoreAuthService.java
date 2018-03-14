package edu.ntut.Java007.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.StoreAuth;
import edu.ntut.Java007.backend.persistence.repository.StoreAuthRepository;

@Service
@Transactional
public class StoreAuthService {
	
	@Autowired
	private StoreAuthRepository storeAuthRepository;
	
	public List<StoreAuth> findStoreAuthsByStoreAuthId(Integer storeAuthId) {
		return storeAuthRepository.findByStoreAuthId(storeAuthId);
	}
	
	public List<StoreAuth> findStoreAuthsByStoreAuthUser(Integer storeAuthUser) {
		return storeAuthRepository.findByStoreAuthUser(storeAuthUser);
	}
}
