package edu.ntut.Java007.backend.persistence.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUTHENTICATIONS")
public class Auth {

	@Id
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_uuid")
	private String userUuid;

	public Auth() {
	}

	public Auth(Integer userId, String userUuid) {
		super();
		this.userId = userId;
		this.userUuid = userUuid;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserUuid() {
		return userUuid;
	}

	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}

}