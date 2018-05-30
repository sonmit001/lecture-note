package com.blog.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "main.blog", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		logger.info("WelCome MY BLOG!!!!");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		
		return mv;
	}
	
}
