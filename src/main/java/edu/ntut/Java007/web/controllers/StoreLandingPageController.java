package edu.ntut.Java007.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ntut.Java007.backend.persistence.po.Store;
import edu.ntut.Java007.backend.persistence.po.StoreAuthorization;
import edu.ntut.Java007.backend.service.StoreAuthService;
import edu.ntut.Java007.backend.service.StoreService;
import edu.ntut.Java007.utils.StoreUtils;
import edu.ntut.Java007.web.vo.LandingPayload;
import edu.ntut.Java007.web.vo.StoreInfoPayload;

@RestController
@RequestMapping("/store/landing")
public class StoreLandingPageController {
	
	@Autowired
	private StoreAuthService storeAuthService;
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ObjectMapper mapper;
	
	private Map<String, Object> returnJson;
	
	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping(value = "/{userId}")
	public Map<String, Object> getStores(@PathVariable(value = "userId") Integer userId) throws JsonProcessingException {
		returnJson = new HashMap<String, Object>();
		List<LandingPayload> payloads = new ArrayList<>();
		
		List<StoreAuthorization> storeAuths = storeAuthService.findStoreAuthsByStoreAuthUser(userId);
		
		if (storeAuths != null) {
			for (StoreAuthorization storeAuth : storeAuths) {
				Store store = storeService.findStoreByStoreId(storeAuth.getStoreAuthId());
				LandingPayload payload = StoreUtils.fromDomainStoreToWebStorePayload(store);
				payloads.add(payload);
			}
			
			String jsonInString = mapper.writeValueAsString(payloads);
			returnJson.put("landing", jsonInString);
			
			returnJson.put("status", 200);
		} else {
			returnJson.put("status", 500);
		}
		
		return returnJson;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@PostMapping(value = "/{userId}")
	public Map<String, Object> createStore(@PathVariable(value = "userId") Integer userId, StoreInfoPayload payload) {
		returnJson = new HashMap<String, Object>();
		
		Store store = StoreUtils.fromWebStoreInfoPayloadToDomainStore(payload);
		store = storeService.createStore(store);
		
		StoreAuthorization storeAuthorization = StoreUtils.fromWebStoreInfoToDomainStoreAuth(store.getStoreId(), userId, "owner");
		storeAuthorization = storeAuthService.createStoreAuthorization(storeAuthorization);
		
		if (store != null && storeAuthorization != null) {
			returnJson.put("status", 200);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
}
