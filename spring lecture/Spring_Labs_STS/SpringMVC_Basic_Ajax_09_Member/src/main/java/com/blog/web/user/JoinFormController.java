package com.blog.web.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinFormController {
	
	@RequestMapping("join.blog")
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView("main");
		mav.setViewName("user/joinForm");
		
		return mav; 
		
	}
}
