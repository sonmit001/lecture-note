package kr.or.bit;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;



public class HelloController implements Controller{

	public HelloController() {
		System.out.println("HelloController 객체 생성");
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 요청 실행 : handleRequest");
    //ModelAndView > 데이터를 담을 것을 만들고 , view 지정 처리
    ModelAndView mav = new ModelAndView();
    mav.addObject("name","kang");
    mav.setViewName("Hello");
    return mav;
	}


}
