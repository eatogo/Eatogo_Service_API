package edu.ntut.Java007.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ntut.Java007.backend.persistence.po.Store;
import edu.ntut.Java007.backend.service.StoreService;
import edu.ntut.Java007.utils.StoreUtils;
import edu.ntut.Java007.web.vo.StoreInfoPayload;

@RestController
@RequestMapping("/store/info")
public class StoreInfoController {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ObjectMapper mapper;
	
	private Map<String, Object> returnJson;

	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/{storeId}")
	public Map<String, Object> getStoreInfo(@PathVariable Integer storeId) throws JsonProcessingException {
		returnJson = new HashMap<String, Object>();
		StoreInfoPayload payload;
		Store store = storeService.findStoreByStoreId(storeId);
		payload = StoreUtils.fromDomainStoreToWebStoreInfo(store);
		
		if (payload != null) {
			String jsonInString = mapper.writeValueAsString(payload);
			returnJson.put("storePayload", jsonInString);
			returnJson.put("status", 200);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@PutMapping
	public Map<String, Object> updateStoreInfo(StoreInfoPayload payload) throws JsonProcessingException {
		returnJson = new HashMap<String, Object>();
		Store store = storeService.findStoreByStoreId(payload.getStoreId());
		if (store != null) {
			store = StoreUtils.fromWebStoreInfoPayloadToDomainStore(payload);
			store = storeService.updateStore(store);
			if (store != null) {
				payload = StoreUtils.fromDomainStoreToWebStoreInfo(store);
				String jsonInString = mapper.writeValueAsString(payload);
				returnJson.put("storePayload", jsonInString);
				returnJson.put("status", 200);
			} else {
				returnJson.put("status", 500);
			}
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
	
}
