package edu.ntut.Java007.backend.persistence.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FOODS")
public class Food implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "food_id")
	private Integer foodId;
	
	@Column(name = "food_name")
	private String foodName;
	
	@Column(name = "food_price")
	private Integer foodPrice;
	
	@Column(name = "food_intro")
	private String foodIntro;
	
	@Column(name = "food_pic_hdpi")
	private String foodPicHdpi;
	
	@Column(name = "food_pic_ldpi")
	private String foodPicLdpi;
	
	@Column(name = "food_pic_mdpi")
	private String foodPicMdpi;
	
	@Column(name = "food_pic")
	private String foodPic;
	
	@Column(name = "food_limit")
	private Integer foodLimit;
	
	@Column(name = "food_type")
	private String foodType;
	
	@Column(name = "food_store")
	private Integer foodStore;
	
	@Column(name = "food_status")
	private String foodStatus;
	
	@Column(name = "food_review_count")
	private Long foodReviewCount;

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

	public String getFoodIntro() {
		return foodIntro;
	}

	public void setFoodIntro(String foodIntro) {
		this.foodIntro = foodIntro;
	}

	public String getFoodPicHdpi() {
		return foodPicHdpi;
	}

	public void setFoodPicHdpi(String foodPicHdpi) {
		this.foodPicHdpi = foodPicHdpi;
	}

	public String getFoodPicLdpi() {
		return foodPicLdpi;
	}

	public void setFoodPicLdpi(String foodPicLdpi) {
		this.foodPicLdpi = foodPicLdpi;
	}

	public String getFoodPicMdpi() {
		return foodPicMdpi;
	}

	public void setFoodPicMdpi(String foodPicMdpi) {
		this.foodPicMdpi = foodPicMdpi;
	}

	public String getFoodPic() {
		return foodPic;
	}

	public void setFoodPic(String foodPic) {
		this.foodPic = foodPic;
	}

	public Integer getFoodLimit() {
		return foodLimit;
	}

	public void setFoodLimit(Integer foodLimit) {
		this.foodLimit = foodLimit;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public Integer getFoodStore() {
		return foodStore;
	}

	public void setFoodStore(Integer foodStore) {
		this.foodStore = foodStore;
	}

	public String getFoodStatus() {
		return foodStatus;
	}

	public void setFoodStatus(String foodStatus) {
		this.foodStatus = foodStatus;
	}

	public Long getFoodReviewCount() {
		return foodReviewCount;
	}

	public void setFoodReviewCount(Long foodReviewCount) {
		this.foodReviewCount = foodReviewCount;
	}

}