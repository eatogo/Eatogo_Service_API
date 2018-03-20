package edu.ntut.Java007.utils;

import edu.ntut.Java007.backend.persistence.po.Store;
import edu.ntut.Java007.backend.persistence.po.StoreAuthorization;
import edu.ntut.Java007.web.vo.LandingPayload;
import edu.ntut.Java007.web.vo.StoreInfoPayload;

public class StoreUtils {
	
	private StoreUtils() {};
	
	public static LandingPayload fromDomainStoreToWebStorePayload(Store store) {
		LandingPayload payload = new LandingPayload();
		payload.setStoreId(store.getStoreId());
		payload.setStoreName(store.getStoreName());
		payload.setStoreLogo(store.getStoreLogo());
		return payload;
	}
	
	public static Store fromWebStoreInfoPayloadToDomainStore(StoreInfoPayload payload) {
		Store store = new Store();
		store.setStoreName(payload.getStoreName());
		store.setStoreAddress(payload.getStoreAddress());
		store.setStorePhone(payload.getStorePhone());
		store.setStoreEmail(payload.getStoreEmail());
		store.setStoreOpenHour(payload.getStoreOpenHour());
		store.setStoreIntro(payload.getStoreIntro());
		store.setStoreLatitude(payload.getStoreLatitude());
		store.setStoreLongitude(payload.getStoreLongitude());
		store.setStoreArea(payload.getStoreArea());
		store.setStoreOperateType(payload.getStoreOperateType());
		store.setStoreLogo("");
		store.setStoreStatus("rest");
		return store;
	}

	public static StoreAuthorization fromWebStoreInfoToDomainStoreAuth(Integer storeId, Integer userId, String storeAuth) {
		StoreAuthorization auth = new StoreAuthorization();
		auth.setStoreAuthId(storeId);
		auth.setStoreAuthUser(userId);
		auth.setStoreAuth(storeAuth);
		return auth;
	}
	
	public static StoreInfoPayload fromDomainStoreToWebStoreInfo(Store store) {
		StoreInfoPayload payload = new StoreInfoPayload();
		payload.setStoreId(store.getStoreId());
		payload.setStoreName(store.getStoreName());
		payload.setStoreAddress(store.getStoreAddress());
		payload.setStoreLatitude(store.getStoreLatitude());
		payload.setStoreLongitude(store.getStoreLongitude());
		payload.setStorePhone(store.getStorePhone());
		payload.setStoreEmail(store.getStoreEmail());
		payload.setStoreOpenHour(store.getStoreOpenHour());
		payload.setStoreIntro(store.getStoreIntro());
		payload.setStoreArea(store.getStoreArea());
		payload.setStoreOperateType(store.getStoreOperateType());
		return payload;
	}
}
