package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IntroController implements Controller{
	
	public IntroController() {
		System.out.println("IntroController 객체 생성");
	}
	//handlerRequest > servlet(doGet , doPost) 역할
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","bituser"); //request.setAttribute()
		mav.setViewName("Intro"); // WEB-INF/views/board/intro.jsp
		
		return mav;
	}

}
