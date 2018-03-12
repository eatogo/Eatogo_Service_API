package edu.ntut.Java007.web.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

	private Map<String, Object> returnJson;

	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping(value = "/auth/{userUuid}")
	public Map<String, Object> authGet(@PathVariable(value = "userUuid") String userUuid) {
		returnJson = new HashMap<String, Object>();

		// 檢查授權
		Auth auth = authService.findByUserUuid(userUuid);
		// 確認授權及uuid存在
		if (auth != null && !"".equals(auth.getUserUuid())) {
			User user = userService.findByUserId(auth.getUserId());
			returnJson.put("status", 200);
			returnJson.put("auth", auth);
			returnJson.put("user", user);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}

	@CrossOrigin(origins = "http://localhost:9000")
	@DeleteMapping(value = "/auth/{userUuid}")
	public Map<String, Object> authDelete(@PathVariable(value = "userUuid") String userUuid) {
		returnJson = new HashMap<String, Object>();
		
		// 刪除授權紀錄
		authService.deleteAuth(authService.findByUserUuid(userUuid));	
		returnJson.put("status", 200);
		return returnJson;
	}

	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping(value = "/login/{userCellphone}/{userPassword}")
	public Map<String, Object> login(@PathVariable("userCellphone") String userCellphone,
			@PathVariable("userPassword") String userPassword) {
		returnJson = new HashMap<String, Object>();
		Auth auth = new Auth();

		// 查詢註冊紀錄
		User user = userService.findByUserCellphone(userCellphone);
		// 確認紀錄是否存在以及密碼是否正確
		if (user != null && userPassword.equals(user.getUserPassword())) {
			auth.setUserId(user.getUserId());
			auth = generateUuid(auth);

			returnJson.put("status", 200);
			returnJson.put("auth", auth);
			returnJson.put("user", user);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}

	@CrossOrigin(origins = "http://localhost:9000")
	@PostMapping(value = "/signup")
	public Map<String, Object> signup(AccountPayload payload) {
		returnJson = new HashMap<String, Object>();
		Auth auth = new Auth();
		User user = new User();

		// 檢查註冊紀錄
		user = userService.findByUserCellphone(payload.getUserCellphone());

		// 檢查申請資料(手機號碼)是否重複
		if (user == null || null == user.getUserCellphone()) {
			LOG.info("Data not duplicated");
			// 將payload資料map進user
			user = UserUtils.fromWebUserToDomainUser(payload);
			// 建立使用者
			user = userService.createUser(user);

			if (user != null && !"".equals(user.getUserStatus())) {
				// 使用者成功建立
				LOG.info("User has been successfully created");
				auth.setUserId(user.getUserId());
				auth = generateUuid(auth);

				returnJson.put("status", 200);
				returnJson.put("auth", auth);
				returnJson.put("user", user);
			} else {
				// 使用者建立失敗
				LOG.warn("Fail to create new user");
				returnJson.put("status", 500);
			}
		}

		return returnJson;
	}

	private Auth generateUuid(Auth auth) {
		Integer userId = auth.getUserId();
		auth = authService.findByUserId(auth.getUserId());
		if (auth == null || auth.getUserUuid().isEmpty()) {
			UUID uid = UUID.randomUUID();
			LOG.info("New UUID: {}", uid.toString());
			auth = new Auth();
			auth.setUserId(userId);
			auth.setUserUuid(uid.toString());
			auth = authService.createAuth(auth);
		}
		return auth;
	}

}