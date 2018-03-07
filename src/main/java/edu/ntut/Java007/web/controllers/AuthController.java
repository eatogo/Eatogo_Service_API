package edu.ntut.Java007.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ntut.Java007.backend.persistence.pojo.Auth;
import edu.ntut.Java007.backend.service.AuthService;

@Controller
@RequestMapping("/member")
public class AuthController {
	
	@Autowired
	private AuthService authService;

	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "auth", method = RequestMethod.GET)
	public Map<String, Object> authGet(@RequestParam(value = "auth") String uuid) {
		
		Map<String, Object> returnJson = new HashMap<String, Object>();
		Auth auth = new Auth();
		
		auth = authService.findByUserUuid(uuid);
		
		if (!"".equals(auth.getUserUuid())) {
			returnJson.put("status", 200);
			returnJson.put("auth", auth);
		} else {
			returnJson.put("status", 500);
		}
		return returnJson;
	}
}
