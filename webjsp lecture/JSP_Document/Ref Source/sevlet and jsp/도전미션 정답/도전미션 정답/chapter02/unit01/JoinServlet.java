package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		String name = request.getParameter("name");
		out.println("�̸� : <b>");
		out.print(name);		
		
		String jumin = request.getParameter("jumin_1")
				+ "-"+ request.getParameter("jumin_2");
		out.println("</b><br>�ֹι�ȣ : <b>");
		out.print(jumin);
		
		String id = request.getParameter("id");
		out.println("</b><br>�� �� �� : <b>");
		out.print(id);
		
		String pwd = request.getParameter("pwd");
		out.println("</b><br>��й�ȣ : <b>");
		out.print(pwd);
		
		String email = request.getParameter("email");
		if (request.getParameter("email_dns").trim() == "") {
			email += "@" + request.getParameter("emailaddr");
		} else {
			email += "@" + request.getParameter("email_dns");
		}
		out.println("</b><br>�� �� �� : <b>");
		out.print(email);
		
		String zip = request.getParameter("zip");
		out.println("</b><br>�����ȣ : <b>");
		out.print(zip);
				
		String addr = request.getParameter("addr1")+request.getParameter("addr2");
		out.println("</b><br>�ּ� : <b>");
		out.print(addr);

		String phone = request.getParameter("phone");
		out.println("</b><br> �ڵ�����ȣ : <b>");
		out.print(phone);

		String job = request.getParameter("job");			
		out.println("</b><br>���� : <b>");
		out.print(job);
		
		out.println("</b><br>���ɺо� : <b>");
		String interests[] = request.getParameterValues("interest");
		if (interests == null) {
			out.print("������ �׸��� �����ϴ�.");
		} else {
			for (String interest : interests) {
				out.print(interest + " ");
			}
		}
		// �ڹ� ��ũ��Ʈ�� ���� �������� �̵��ϴ� ��ũ�� ����� ��
		out.println("</b><br><br><a href='javascript:history.go(-1)'>�ٽ�</a>");
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		doGet(request, response);
	}
}
