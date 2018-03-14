package edu.ntut.Java007.backend.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.Store;

@Repository
@Transactional
public interface StoreRepository extends JpaRepository<Store, Integer> {

	public Store findByStoreId(Integer storeId);
}
