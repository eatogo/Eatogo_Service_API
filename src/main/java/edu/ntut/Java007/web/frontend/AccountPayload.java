package edu.ntut.Java007.web.frontend;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class AccountPayload implements Serializable {

	/** The Serial Version UID for Serializable classes. */
	private static final long serialVersionUID = 1L;

	@NotNull
	private String userName;

	@NotNull
	private String userCellphone;

	@NotNull
	private String userPassword;

	@Email
	@NotNull
	private String userEmail;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCellphone() {
		return userCellphone;
	}

	public void setUserCellphone(String userCellphone) {
		this.userCellphone = userCellphone;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userCellphone == null) ? 0 : userCellphone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountPayload other = (AccountPayload) obj;
		if (userCellphone == null) {
			if (other.userCellphone != null)
				return false;
		} else if (!userCellphone.equals(other.userCellphone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccountPayload [").append("userName=").append(userName).append(", userCellphone=")
				.append(userCellphone).append(", userPassword=").append(userPassword).append(", userEmail=")
				.append(userEmail).append("]");
		return builder.toString();
	}

}