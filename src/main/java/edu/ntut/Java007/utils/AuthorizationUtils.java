package edu.ntut.Java007.utils;

import edu.ntut.Java007.backend.persistence.po.StoreAuthorization;
import edu.ntut.Java007.backend.persistence.po.User;
import edu.ntut.Java007.web.vo.StoreAuthPayload;

public class AuthorizationUtils {
	
	private AuthorizationUtils() {};
	
	public static StoreAuthPayload fromDomainStoreAuthsToWebStoreAuthPayload(StoreAuthorization auth) {
		StoreAuthPayload payload = new StoreAuthPayload();
		payload.setStoreId(auth.getStoreAuthId());
		payload.setStoreUser(auth.getStoreAuthUser());
		return payload;
	}
	
	public static StoreAuthPayload fromDomainUserToWebStoreAuthPayload(User user, StoreAuthPayload payload) {
		payload.setStoreUserCellphone(user.getUserCellphone());
		payload.setStoreUserName(user.getUserName());
		return payload;
	}
	
	public static StoreAuthorization fromWebStoreAuthPayloadToDomainStoreAuth(StoreAuthPayload payload) {
		StoreAuthorization storeAuth = new StoreAuthorization();
		storeAuth.setStoreAuthId(payload.getStoreId());
		storeAuth.setStoreAuthUser(payload.getStoreUser());
		return storeAuth;
	}

}
