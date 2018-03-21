package edu.ntut.Java007.web.vo;

import java.io.Serializable;

public class MenuPayload implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	private Integer foodId;
	
	private String foodName;
	
	private Integer foodPrice;
	
	private Integer foodLimit;
	
	private String foodIntro;
	
	private String foodPicMdpi;

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Integer foodPrice) {
		this.foodPrice = foodPrice;
	}

	public Integer getFoodLimit() {
		return foodLimit;
	}

	public void setFoodLimit(Integer foodLimit) {
		this.foodLimit = foodLimit;
	}

	public String getFoodIntro() {
		return foodIntro;
	}

	public void setFoodIntro(String foodIntro) {
		this.foodIntro = foodIntro;
	}

	public String getFoodPicMdpi() {
		return foodPicMdpi;
	}

	public void setFoodPicMdpi(String foodPicMdpi) {
		this.foodPicMdpi = foodPicMdpi;
	}
	
}