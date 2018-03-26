package edu.ntut.Java007.utils;

import java.util.List;

import edu.ntut.Java007.backend.persistence.po.Food;
import edu.ntut.Java007.backend.persistence.po.Order;
import edu.ntut.Java007.backend.persistence.po.OrderDetail;
import edu.ntut.Java007.backend.persistence.po.User;
import edu.ntut.Java007.web.vo.OrderDetailPayload;
import edu.ntut.Java007.web.vo.OrderPayload;

public class OrderUtils {

	public static OrderPayload fromDomainOrderToWebFinishedOrderPayload(Order order, User orderUser, User confirmOrderUser, List<OrderDetailPayload> orderDetails) {
		OrderPayload payload = new OrderPayload();
		payload.setOrderId(order.getOrderId());
		payload.setOrderUser(order.getOrderUser());
		payload.setOrderUserName(orderUser.getUserName());
		payload.setOrderUserCellphone(orderUser.getUserCellphone());
		payload.setOrderNote(order.getOrderNote());
		payload.setOrderTime(order.getOrderTime());
		payload.setOrderConfirmTime(order.getOrderConfirmTime());
		payload.setOrderConfirmUser(confirmOrderUser.getUserId());
		payload.setOrderConfirmUserName(confirmOrderUser.getUserName());
		payload.setOrderTakeoutPeriod(order.getOrderTakeoutPeriod());
		payload.setOrderDetails(orderDetails);
		return payload;
	}
	
	public static OrderPayload fromDomainOrderToWebUnfinishedOrderPayload(Order order, User orderUser, User confirmOrderUser, List<OrderDetailPayload> orderDetails) {
		OrderPayload payload = new OrderPayload();
		payload.setOrderId(order.getOrderId());
		payload.setOrderUser(order.getOrderUser());
		payload.setOrderUserName(orderUser.getUserName());
		payload.setOrderUserCellphone(orderUser.getUserCellphone());
		payload.setOrderNote(order.getOrderNote());
		payload.setOrderTime(order.getOrderTime());
		payload.setOrderConfirmTime(order.getOrderConfirmTime());
		payload.setOrderConfirmUser(confirmOrderUser.getUserId());
		payload.setOrderConfirmUserName(confirmOrderUser.getUserName());
		payload.setOrderTakeoutPeriod(order.getOrderTakeoutPeriod());
		payload.setOrderDetails(orderDetails);
		return payload;
	}
	
	public static OrderPayload fromDomainOrderToWebOrderedOrderPayload(Order order, User orderUser, List<OrderDetailPayload> orderDetails) {
		OrderPayload payload = new OrderPayload();
		payload.setOrderId(order.getOrderId());
		payload.setOrderUser(order.getOrderUser());
		payload.setOrderUserName(orderUser.getUserName());
		payload.setOrderUserCellphone(orderUser.getUserCellphone());
		payload.setOrderNote(order.getOrderNote());
		payload.setOrderTime(order.getOrderTime());
		payload.setOrderDetails(orderDetails);
		return payload;
	}
	
	public static OrderDetailPayload fromDomainOrderDetailToWebOrderDetailPayload(OrderDetail orderDetail, Food food) {
		OrderDetailPayload payload = new OrderDetailPayload();
		payload.setOrderDetailId(orderDetail.getOrderDetailId());
		payload.setOrderFood(orderDetail.getOrderFood());
		payload.setFoodName(food.getFoodName());
		payload.setOrderQuantity(orderDetail.getOrderQuantity());
		payload.setFoodPrice(food.getFoodPrice());
		return payload;
	}
	
}