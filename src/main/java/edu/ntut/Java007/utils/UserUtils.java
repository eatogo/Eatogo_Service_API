package edu.ntut.Java007.utils;

import edu.ntut.Java007.backend.persistence.po.User;
import edu.ntut.Java007.web.vo.AccountPayload;

public class UserUtils {
	
	private UserUtils() {};

	public static <T extends AccountPayload> User fromWebUserToDomainUser(T payload) {
		User user = new User();
		
		user.setUserName(payload.getUserName());
		user.setUserCellphone(payload.getUserCellphone());
		user.setUserPassword(payload.getUserPassword());
		user.setUserEmail(payload.getUserEmail());
		
		return user;
	}
	
}
