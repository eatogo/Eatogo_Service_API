package edu.ntut.Java007.backend.persistence.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetail implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "order_detail_id")
	private Integer orderDetailId;
	
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "order_food")
	private Integer orderFood;
	
	@Column(name = "order_quantity")
	private Integer orderQuantity;

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderFood() {
		return orderFood;
	}

	public void setOrderFood(Integer orderFood) {
		this.orderFood = orderFood;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetail [orderDetailId=").append(orderDetailId).append(", orderId=").append(orderId)
				.append(", orderFood=").append(orderFood).append(", orderQuantity=").append(orderQuantity).append("]");
		return builder.toString();
	}
	
}