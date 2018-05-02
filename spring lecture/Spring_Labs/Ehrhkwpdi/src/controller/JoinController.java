package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class JoinController {
	
	@RequestMapping(value="join.htm",method=RequestMethod.GET)
	public String join() {
		return "joinus.join";
	}
	
	//로그인 페이지
	@RequestMapping(value="login.htm",method=RequestMethod.GET)
	public String login() {
		//return "login.jsp";
		return "joinus.login";//폴더명.파일명
	}
}
