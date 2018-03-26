package edu.ntut.Java007.web.vo;

import java.io.Serializable;

public class OrderChangeStatePayload implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;
	
	private Integer orderId;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderChangeStatePayload [orderId=").append(orderId).append("]");
		return builder.toString();
	}

}