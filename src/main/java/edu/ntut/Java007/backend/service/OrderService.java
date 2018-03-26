package edu.ntut.Java007.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ntut.Java007.backend.persistence.po.Order;
import edu.ntut.Java007.backend.persistence.po.OrderDetail;
import edu.ntut.Java007.backend.persistence.repository.OrderDetailRepository;
import edu.ntut.Java007.backend.persistence.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	public List<Order> findOrdersByOrderStoreAndOrderStatusAndOrderTimeBetweenOrderByOrderTimeDesc(Integer storeId, String orderStatus, Date beginTime, Date endTime) {
		return orderRepository.findByOrderStoreAndOrderStatusAndOrderTimeBetweenOrderByOrderTimeDesc(storeId, orderStatus, beginTime, endTime);
	};

	public List<OrderDetail> findOrderDetailsByOrderId(Integer orderId) {
		return orderDetailRepository.findByOrderId(orderId);
	};
	
	public Order isOrderExistsBetweenOrderTime(Integer storeId, Date beginTime, Date endTime) {
		return orderRepository.findTop1ByOrderStoreAndOrderTimeBetween(storeId, beginTime, endTime);
	}
}
