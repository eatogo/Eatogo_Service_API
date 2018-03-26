package edu.ntut.Java007.backend.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.OrderDetail;

@Repository
@Transactional
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	public List<OrderDetail> findByOrderId(Integer OrderId);
}
