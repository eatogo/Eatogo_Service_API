package edu.ntut.Java007.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ntut.Java007.backend.persistence.po.StoreAuthorization;
import edu.ntut.Java007.backend.persistence.po.User;
import edu.ntut.Java007.backend.service.StoreAuthService;
import edu.ntut.Java007.backend.service.UserService;
import edu.ntut.Java007.utils.AuthorizationUtils;
import edu.ntut.Java007.web.vo.StoreAuthPayload;

@RestController
@RequestMapping("/store/authorization")
public class StoreAuthorizationController {
	
	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(StoreAuthorizationController.class);
	
	@Autowired
	private StoreAuthService storeAuthService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ObjectMapper mapper;
	
	private Map<String, Object> returnJson;

	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/{storeId}")
	public Map<String, Object> getEmployee(@PathVariable Integer storeId) throws JsonProcessingException {
		returnJson = new HashMap<String, Object>();
		List<StoreAuthorization> employees = storeAuthService.findStoreAuthsByStoreAuthIdAndStoreAuth(storeId, "manager");
		List<StoreAuthPayload> payloads = new ArrayList<>();
		if (employees != null && employees.size() > 0) {
			for (StoreAuthorization auth : employees) {
				StoreAuthPayload payload = AuthorizationUtils.fromDomainStoreAuthsToWebStoreAuthPayload(auth);
				User authUser = userService.findByUserId(payload.getStoreUser());
				payload = AuthorizationUtils.fromDomainUserToWebStoreAuthPayload(authUser, payload);
				payloads.add(payload);
			}
			String jsonInString = mapper.writeValueAsString(payloads);
			returnJson.put("status", 200);
			returnJson.put("authPayload", jsonInString);
		} else {
			returnJson.put("status", 200);
			returnJson.put("authPayload", "null");
		}
		return returnJson;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@DeleteMapping("/{storeAuthId}/{storeAuthUser}")
	public Map<String, Object> deleteEmployee(@PathVariable Integer storeAuthId, @PathVariable Integer storeAuthUser) {
		returnJson = new HashMap<String, Object>();
		LOG.info("storeAuthId=" + storeAuthId + ", storeAuthUser=" + storeAuthUser);
		StoreAuthorization employee = storeAuthService.findStoreAuthByStoreAuthIdAndStoreAuthUser(storeAuthId, storeAuthUser);
		LOG.info(employee.toString());
		storeAuthService.deleteEmployee(employee);
		returnJson.put("status", 200);
		return returnJson;
	}
	
	@CrossOrigin(origins = "http://localhost:9000")
	@PostMapping
	public Map<String, Object> createEmployee(StoreAuthPayload payload) throws JsonProcessingException {
		returnJson = new HashMap<String, Object>();
		User user = userService.findByUserCellphone(payload.getStoreUserCellphone());
		StoreAuthorization employee = storeAuthService.findStoreAuthByStoreAuthIdAndStoreAuthUser(payload.getStoreId(), user.getUserId());
		List<StoreAuthPayload> payloads = new ArrayList<>();
		if (employee != null) {
			returnJson.put("status", 500);
		} else {
			employee = AuthorizationUtils.fromWebStoreAuthPayloadToDomainStoreAuth(payload);
			employee.setStoreAuthUser(user.getUserId());
			employee.setStoreAuth("manager");
			employee = storeAuthService.createStoreAuthorization(employee);
			if (employee != null) {
				List<StoreAuthorization> employees = storeAuthService.findStoreAuthsByStoreAuthIdAndStoreAuth(employee.getStoreAuthId(), "manager");
				for (StoreAuthorization auth : employees) {
					StoreAuthPayload emp = AuthorizationUtils.fromDomainStoreAuthsToWebStoreAuthPayload(auth);
					User authUser = userService.findByUserId(emp.getStoreUser());
					emp = AuthorizationUtils.fromDomainUserToWebStoreAuthPayload(authUser, emp);
					payloads.add(emp);
				}
				String jsonInString = mapper.writeValueAsString(payloads);
				returnJson.put("authPayload", jsonInString);
				returnJson.put("status", 200);
			} else {
				returnJson.put("status", 500);
			}
			returnJson.put("", payloads);
		}
		return returnJson;
	}
}
