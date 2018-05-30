package com.blog.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFormController {

	private static final Logger logger = LoggerFactory.getLogger(LoginFormController.class);
	
	@RequestMapping("loginForm.blog")
	public ModelAndView main() {
		
		logger.info("LoginController INIT");
		
		ModelAndView mav = new ModelAndView("main");
		mav.setViewName("user/loginForm");
		
		return mav; 
		
	}
}
