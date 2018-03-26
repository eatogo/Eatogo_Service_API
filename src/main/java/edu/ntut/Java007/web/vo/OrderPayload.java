package edu.ntut.Java007.web.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderPayload implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	private Integer orderId;
	
	private Integer orderUser;
	
	private String orderUserName;
	
	private String orderUserCellphone;
	
	private String orderNote;
	
	private Date orderTime;
	
	private Date orderConfirmTime;
	
	private Integer orderConfirmUser;
	
	private String orderConfirmUserName;
	
	private String orderTakeoutPeriod;
	
	private List<OrderDetailPayload> orderDetails;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(Integer orderUser) {
		this.orderUser = orderUser;
	}

	public String getOrderUserName() {
		return orderUserName;
	}

	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}

	public String getOrderUserCellphone() {
		return orderUserCellphone;
	}

	public void setOrderUserCellphone(String orderUserCellphone) {
		this.orderUserCellphone = orderUserCellphone;
	}

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getOrderConfirmTime() {
		return orderConfirmTime;
	}

	public void setOrderConfirmTime(Date orderConfirmTime) {
		this.orderConfirmTime = orderConfirmTime;
	}

	public Integer getOrderConfirmUser() {
		return orderConfirmUser;
	}

	public void setOrderConfirmUser(Integer orderConfirmUser) {
		this.orderConfirmUser = orderConfirmUser;
	}

	public String getOrderConfirmUserName() {
		return orderConfirmUserName;
	}

	public void setOrderConfirmUserName(String orderConfirmUserName) {
		this.orderConfirmUserName = orderConfirmUserName;
	}

	public String getOrderTakeoutPeriod() {
		return orderTakeoutPeriod;
	}

	public void setOrderTakeoutPeriod(String orderTakeoutPeriod) {
		this.orderTakeoutPeriod = orderTakeoutPeriod;
	}

	public List<OrderDetailPayload> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailPayload> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderPayload [orderId=").append(orderId).append(", orderUser=").append(orderUser)
				.append(", orderUserName=").append(orderUserName).append(", orderUserCellphone=")
				.append(orderUserCellphone).append(", orderNote=").append(orderNote).append(", orderTime=")
				.append(orderTime).append(", orderConfirmTime=").append(orderConfirmTime).append(", orderConfirmUser=")
				.append(orderConfirmUser).append(", orderConfirmUserName=").append(orderConfirmUserName)
				.append(", orderTakeoutPeriod=").append(orderTakeoutPeriod).append(", orderDetails=")
				.append(orderDetails).append("]");
		return builder.toString();
	}

}