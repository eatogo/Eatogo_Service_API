package edu.ntut.Java007.utils;

import edu.ntut.Java007.backend.persistence.pojo.User;
import edu.ntut.Java007.web.frontend.AccountPayload;

public class UserUtils {

	public UserUtils() {
	}

	public static <T extends AccountPayload> User fromWebUserToDomainUser(T frontendPayload) {
		User user = new User();
		
		user.setUserName(frontendPayload.getUserName());
		user.setUserCellphone(frontendPayload.getUserCellphone());
		user.setUserPassword(frontendPayload.getUserPassword());
		user.setUserEmail(frontendPayload.getUserEmail());
		
		return user;
	}
	
}
