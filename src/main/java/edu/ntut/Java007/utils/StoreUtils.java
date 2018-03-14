package edu.ntut.Java007.utils;

import edu.ntut.Java007.backend.persistence.po.Store;
import edu.ntut.Java007.web.vo.LandingPayload;

public class StoreUtils {
	
	public static LandingPayload fromDomainStoreToWebStorePayload(Store store) {
		LandingPayload payload = new LandingPayload();
		payload.setStoreId(store.getStoreId());
		payload.setStoreName(store.getStoreName());
		payload.setStoreLogo(store.getStoreLogo());
		return payload;
	}

}
