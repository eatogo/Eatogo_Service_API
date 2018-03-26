package edu.ntut.Java007.backend.persistence.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.Order;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	public Order findTop1ByOrderStoreAndOrderTimeBetween(Integer orderStore, Date beginTime, Date endTime);

	public List<Order> findByOrderStoreAndOrderStatusAndOrderTimeBetweenOrderByOrderTimeDesc(Integer storeId, String orderStatus, Date beginTime, Date endTime);
}
