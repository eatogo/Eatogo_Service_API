package edu.ntut.Java007.web.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ntut.Java007.backend.persistence.pojo.Auth;
import edu.ntut.Java007.backend.persistence.pojo.User;
import edu.ntut.Java007.backend.service.AuthService;
import edu.ntut.Java007.backend.service.UserService;
import edu.ntut.Java007.web.frontend.LoginPayload;

@RestController
@RequestMapping(value = "/member")
public class LoginController {

	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private AuthService authService;

	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Map<String, Object> loginGet(LoginPayload payload) {

		Map<String, Object> returnJson = new HashMap<String, Object>();
		Auth auth = new Auth();
		User user = new User();

		LOG.info("FormData received: {}", payload.toString());

		user = userService.findByUserCellphone(payload.getUserCellphone());
		
		if (!"".equals(user.getUserCellphone()) && 
				payload.getUserPassword().equals(user.getUserPassword())) {
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

}