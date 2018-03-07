package edu.ntut.Java007.backend.persistence.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {
	
	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_cellphone")
	private String userCellphone;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_email")
	private String userEmail;
	
	@Column(name = "user_avatar")
	private String userAvatar;
	
	@Column(name = "user_create_time")
	private Date userCreateTime;
	
	@Column(name = "user_status")
	private String userStatus;
	
	public User() {
	}

	public User(Integer userId, String userPassword, String userCellphone, String userName, String userEmail,
			String userAvatar, Date userCreateTime, String userStatus) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userCellphone = userCellphone;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAvatar = userAvatar;
		this.userCreateTime = userCreateTime;
		this.userStatus = userStatus;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCellphone() {
		return userCellphone;
	}

	public void setUserCellphone(String userCellphone) {
		this.userCellphone = userCellphone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAvatar() {
		return userAvatar;
	}

	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}

	public Date getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}