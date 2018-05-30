package inter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class loginsessionInterception extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			String userid = request.getParameter("UserName");
			System.out.println("userid" + userid);
			request.getSession().setAttribute("userid", userid);
			long start = System.currentTimeMillis();
			request.getSession().setAttribute("start", start);
			System.out.println("sess : "+request.getSession().getAttribute("userid"));
			System.out.println("오케이");
	}

	
	
}
