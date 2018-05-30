package com.blog.web.user;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.blog.mybatis.UserDaoImpl;
import com.blog.util.Util;
import com.blog.vo.UserVo;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	UserVo userVo;

	@Resource(name="userDaoImpl")
	private UserDaoImpl userDaoImpl;
	
	@RequestMapping("login.blog")
	public ModelAndView main(HttpServletRequest request ) {
		
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		
		
		Map<String, String> map = new HashMap<String, String>();
		
		String id = Util.nullCheck(request.getParameter("id"), "");
		String password = Util.nullCheck(request.getParameter("password"), "");
		System.out.println(id + "/ " + password);
		map.put("id",id);
		map.put("password", password);
		
		int loginValue = 0;
		
		try {  loginValue = userDaoImpl.getLoginResult(map);  } catch (Exception e) { }
		
		
		if (loginValue == 1)
		{
			logger.info("로그인성공");
			mav.setViewName("blog/blogMain");
			userVo = userDaoImpl.getUserInfo(id);
			
			session.setAttribute("userId", userVo.getUserId());
			session.setAttribute("userPassword", userVo.getUserPassword());
			session.setAttribute("userEmail", userVo.getUserEmail());
			session.setAttribute("userName", userVo.getUserName());
			session.setAttribute("userSeq", userVo.getUserSeq());
		}
		else
		{
			logger.info("로그인실패");
			mav.setViewName("user/loginForm");
		}
		
		return mav; 
		
	}
}
