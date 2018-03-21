package edu.ntut.Java007.backend.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.StoreAuthorization;

@Repository
@Transactional
public interface StoreAuthRepository extends JpaRepository<StoreAuthorization, Integer> {
	
	public List<StoreAuthorization> findByStoreAuthId(Integer storeAuthId);
	
	public List<StoreAuthorization> findByStoreAuthUser(Integer storeAuthUser);
	
	public List<StoreAuthorization> findByStoreAuthIdAndStoreAuth(Integer storeAuthId, String storeAuth);
	
	public StoreAuthorization findByStoreAuthIdAndStoreAuthUser(Integer storeAuthId, Integer storeAuthUser);
	
}
