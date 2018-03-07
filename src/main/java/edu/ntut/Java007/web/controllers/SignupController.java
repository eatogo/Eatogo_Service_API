package edu.ntut.Java007.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ntut.Java007.backend.persistence.pojo.User;
import edu.ntut.Java007.backend.service.UserService;
import edu.ntut.Java007.utils.UserUtils;
import edu.ntut.Java007.web.frontend.AccountPayload;

@Controller
@RequestMapping("/member")
public class SignupController {
	
	/** The application logger */
	private static final Logger LOG = LoggerFactory.getLogger(SignupController.class);
	
	@Autowired
	private UserService userService;

	/**
	 * 將申請表格傳來的資料直接轉為代表前端資料的物件AccountPayload
	 * 再驗證手機是否重複，再存入資料庫
	 * @param userCellphone
	 * @param payload
	 * @param response
	 * @throws IOException
	 */
	@CrossOrigin(origins = "http://localhost:9000")
	@RequestMapping(value = "/signup", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public void signupPost(@RequestParam("userCellphone") String userCellphone,
			AccountPayload payload, HttpServletResponse response) throws IOException {
		// 確認接收到資料並相對應的存到payload中
		System.out.println(payload.toString());
		
		// 檢查申請資料(手機)是否重複
		if (!checkForDuplicates(payload)) {
			LOG.info("Data not duplicated");
			LOG.info("Transforming user payload into User domain object");
			User user = UserUtils.fromWebUserToDomainUser(payload);
			// 建立使用者
			if (userService.createUser(user) != null) {
				// 如果使用者成功建立
				LOG.info("User has been successfully created");
				PrintWriter out = response.getWriter();
				response.setContentType("text/plain"); 
				out.write("signup success");
				out.close();
			} else {
				LOG.warn("User creation failed");
				PrintWriter out = response.getWriter();
				response.setContentType("text/plain"); 
				out.write("signup failed");
				out.close();
			}
		};
	}

	private boolean checkForDuplicates(AccountPayload payload) {
		if (userService.findByUserCellphone(payload.getUserCellphone()) != null) {
			return true;
		}
		return false;
	}
}
