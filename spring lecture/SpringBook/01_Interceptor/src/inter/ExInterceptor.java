package inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ExInterceptor implements HandlerInterceptor {

	@Override //무조건 실행
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		try {
			System.out.println("Exception : " + ex.getMessage());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		long start = System.currentTimeMillis();
		request.getSession().setAttribute("start", start);
		System.out.println("start : " + start);
	}

	@Override // 오류나면 실행 안함
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv)
			throws Exception {
		System.out.println("postHandle");
	}
	
	@Override //오류나면 실행 안함
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle");
		System.out.println(">" + request.getSession().getAttribute("userid") + "<");
		boolean result = false;
		
		if (request.getSession().getAttribute("userid") == null) {
			System.out.println("여기");
			response.sendRedirect(request.getContextPath() + "/index.htm");
		} else {
			long start = (long) request.getSession().getAttribute("start");
			long end = System.currentTimeMillis();
			int gap = (int) (end - start) / 1000;
			if (gap > 6) {
				request.getSession().invalidate();
				response.getWriter().println("<script>alert('LOG OUT.'); location.href='" + request.getContextPath()
						+ "/index.htm';</script>");
			} else {
				result = true;
			}

		}

		return result;
	}

}
