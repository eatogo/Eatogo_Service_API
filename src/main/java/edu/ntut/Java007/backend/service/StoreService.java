package edu.ntut.Java007.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.Store;
import edu.ntut.Java007.backend.persistence.repository.StoreRepository;

@Service
@Transactional
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepository;
	
	public Store findStoreByStoreId(Integer storeId) {
		return storeRepository.findByStoreId(storeId);
	}

}