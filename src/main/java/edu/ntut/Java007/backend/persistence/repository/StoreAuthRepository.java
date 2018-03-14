package edu.ntut.Java007.backend.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.StoreAuth;

@Repository
@Transactional
public interface StoreAuthRepository extends JpaRepository<StoreAuth, Integer> {
	
	public List<StoreAuth> findByStoreAuthId(Integer storeAuthId);
	
	public List<StoreAuth> findByStoreAuthUser(Integer storeAuthUser);
}
