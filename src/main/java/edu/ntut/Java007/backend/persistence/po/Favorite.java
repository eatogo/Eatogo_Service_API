package edu.ntut.Java007.backend.persistence.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FAVORITES")
public class Favorite implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "favorite_id")
	private Integer favoriteId;
	
	@Column(name = "favorite_food")
	private Integer favoriteFood;
	
	@Column(name = "favorite_user")
	private Integer favoriteUser;

	public Integer getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}

	public Integer getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(Integer favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Integer getFavoriteUser() {
		return favoriteUser;
	}

	public void setFavoriteUser(Integer favoriteUser) {
		this.favoriteUser = favoriteUser;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Favorite [favoriteId=").append(favoriteId).append(", favoriteFood=").append(favoriteFood)
				.append(", favoriteUser=").append(favoriteUser).append("]");
		return builder.toString();
	}

}
