package edu.ntut.Java007.web.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ntut.Java007.backend.persistence.pojo.Auth;
import edu.ntut.Java007.backend.persistence.pojo.User;
import edu.ntut.Java007.backend.service.AuthService;
import edu.ntut.Java007.backend.service.UserService;
import edu.ntut.Java007.utils.UserUtils;
import edu.ntut.Java007.web.frontend.AccountPayload;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private AuthService authService;

	@Autowired
	private UserService userService;
	
	/**
	 * Authenticate through userUuid or return null if no userUuid is found.
	 * @param userUuid The given userUuid from client.
	 * @return Json string containing status and an Auth object with userId and userUuid
	 */
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "auth/{userUuid}", method = RequestMethod.GET)
	public Map<String, Object> auth(@PathVariable(value = "userUuid") String userUuid) {
		
		Map<String, Object> returnJson = new HashMap<String, Object>();
		Auth auth = new Auth();
		
		auth = authService.findByUserUuid(userUuid);
		
		if (!"".equals(auth.getUserUuid())) {
			returnJson.put("status", 200);
			returnJson.put("auth", auth);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
	
	/**
	 * Login with given userCellphone and userPassword or null if not found or not matched.
	 * @param userCellphone The given userCellphone from client.
	 * @param userPassword The given userPassword from client.
	 * @return Json string containing status and an Auth object with userId and userUuid or null if not found or not matched
	 */
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "/login/{userCellphone}/{userPassword}", method = RequestMethod.GET)
	public Map<String, Object> login(
			@PathVariable("userCellphone") String userCellphone, 
			@PathVariable("userPassword") String userPassword) {
		
		Map<String, Object> returnJson = new HashMap<String, Object>();
		Auth auth = new Auth();
		User user = new User();
		
		LOG.info("Login data received: userCellphone={}, userPassword={}", userCellphone, userPassword);
		
		user = userService.findByUserCellphone(userCellphone);
		
		// 檢查手機號碼是否重複
		if (!"".equals(user.getUserCellphone()) && 
				userPassword.equals(user.getUserPassword())) {
			auth.setUserId(user.getUserId());
			
			UUID uid = UUID.randomUUID();
			LOG.info("New UUID: {}", uid.toString());
			auth.setUserUuid(uid.toString());
			auth = authService.createAuth(auth);

			returnJson.put("status", 200);
			returnJson.put("auth", auth);
		} else {
			returnJson.put("status", 500);
		}
		
		return returnJson;
	}
	
	/**
	 * Create an user if userCellphone is not found or return null if user already exists
	 * @param payload The signup info from client
	 * @return Json string containing status and an Auth object with userId and userUuid or null if user already exists
	 */
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public Map<String, Object> signupPost(AccountPayload payload) {
		
		Map<String, Object> returnJson = new HashMap<String, Object>();
		Auth auth = new Auth();
		User user = new User();
		System.out.println(auth.toString() + user.toString());
		
		LOG.info("Signup form data received: {}", payload.toString());
		
		user = userService.findByUserCellphone(payload.getUserCellphone());
		
		// 檢查申請資料(手機)是否重複
		if (user == null || null == user.getUserCellphone()) {
			LOG.info("Data not duplicated");
			LOG.info("Transforming user payload into User domain object");
			// 將payload資料map進user
			user = UserUtils.fromWebUserToDomainUser(payload);
			// 建立使用者
			user = userService.createUser(user);
			
			if (!"".equals(user.getUserStatus())) {
				// 如果使用者成功建立
				LOG.info("User has been successfully created");
				auth.setUserId(user.getUserId());
				
				UUID uid = UUID.randomUUID();
				LOG.info("New UUID: {}", uid.toString());
				auth.setUserUuid(uid.toString());
				auth = authService.createAuth(auth);

				returnJson.put("status", 200);
				returnJson.put("auth", auth);
			} else {
				LOG.warn("User creation failed");
				returnJson.put("status", 500);
			}
		}
		
		return returnJson;
	}
	
}