package edu.ntut.Java007.backend.persistence.po;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "order_id")
	private Integer orderId;
	
	@Column(name = "order_user")
	private Integer orderUser;
	
	@Column(name = "order_note")
	private String orderNote;
	
	@Column(name = "order_time")
	private Date orderTime;
	
	@Column(name = "order_reserve_date")
	private java.sql.Date orderReserveDate;
	
	@Column(name = "order_store")
	private Integer orderStore;
	
	@Column(name = "order_confirm_user")
	private Integer orderConfirmUser;
	
	@Column(name = "order_confirm_time")
	private Date orderConfirmTime;
	
	@Column(name = "order_takeout_period")
	private String orderTakeoutPeriod;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@Column(name = "order_finished_time")
	private Date orderFinishedTime;
	
	@Column(name = "order_serial_no")
	private String orderSerialNo;

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

	public java.sql.Date getOrderReserveDate() {
		return orderReserveDate;
	}

	public void setOrderReserveDate(java.sql.Date orderReserveDate) {
		this.orderReserveDate = orderReserveDate;
	}

	public Integer getOrderStore() {
		return orderStore;
	}

	public void setOrderStore(Integer orderStore) {
		this.orderStore = orderStore;
	}

	public Integer getOrderConfirmUser() {
		return orderConfirmUser;
	}

	public void setOrderConfirmUser(Integer orderConfirmUser) {
		this.orderConfirmUser = orderConfirmUser;
	}

	public Date getOrderConfirmTime() {
		return orderConfirmTime;
	}

	public void setOrderConfirmTime(Date orderConfirmTime) {
		this.orderConfirmTime = orderConfirmTime;
	}

	public String getOrderTakeoutPeriod() {
		return orderTakeoutPeriod;
	}

	public void setOrderTakeoutPeriod(String orderTakeoutPeriod) {
		this.orderTakeoutPeriod = orderTakeoutPeriod;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderFinishedTime() {
		return orderFinishedTime;
	}

	public void setOrderFinishedTime(Date orderFinishedTime) {
		this.orderFinishedTime = orderFinishedTime;
	}

	public String getOrderSerialNo() {
		return orderSerialNo;
	}

	public void setOrderSerialNo(String orderSerialNo) {
		this.orderSerialNo = orderSerialNo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=").append(orderId).append(", orderUser=").append(orderUser)
				.append(", orderNote=").append(orderNote).append(", orderTime=").append(orderTime)
				.append(", orderReserveDate=").append(orderReserveDate).append(", orderStore=").append(orderStore)
				.append(", orderConfirmUser=").append(orderConfirmUser).append(", orderConfirmTime=")
				.append(orderConfirmTime).append(", orderTakeoutPeriod=").append(orderTakeoutPeriod)
				.append(", orderStatus=").append(orderStatus).append(", orderFinishedTime=").append(orderFinishedTime)
				.append(", orderSerialNo=").append(orderSerialNo).append("]");
		return builder.toString();
	}
	
}