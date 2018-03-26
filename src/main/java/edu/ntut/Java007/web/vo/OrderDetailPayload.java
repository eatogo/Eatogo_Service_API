package edu.ntut.Java007.web.vo;

import java.io.Serializable;

public class OrderDetailPayload implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	private Integer orderDetailId;
	
	private Integer orderFood;
	
	private String foodName;
	
	private Integer orderQuantity;
	
	private Integer foodPrice;

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getOrderFood() {
		return orderFood;
	}

	public void setOrderFood(Integer orderFood) {
		this.orderFood = orderFood;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Integer getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetailPayload [orderDetailId=").append(orderDetailId).append(", orderFood=")
				.append(orderFood).append(", foodName=").append(foodName).append(", orderQuantity=")
				.append(orderQuantity).append(", foodPrice=").append(foodPrice).append("]");
		return builder.toString();
	}
	
}