package ncontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import kr.or.spring.AsyncProcess;
import service.JoinService;
import service.MemberService;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

/*	@Autowired
	private MemberDao memberdao;*/
	
	@Autowired
	private AsyncProcess async;
	
	@Autowired
	private View jsonview;	
	
	@Autowired
	private JoinService service;
	
	@Autowired
	private MemberService logservice;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="join.htm",method=RequestMethod.GET)
	public String join() {
		//return "join.jsp";
		return "joinus.join"; //폴더명.파일명
	}
	
	@RequestMapping(value="join.htm",method=RequestMethod.POST)
	public String join(Member member) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		String viewpage="";
		
		member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
		result = service.insertMember(member);
		service.insertRoll(member.getUserid());
		
		if(result > 0) {
			System.out.println("가입성공");
			viewpage = "redirect:/index.htm";
		}else {
			System.out.println("가입실패");
			viewpage = "join.htm";
		}
		
		return viewpage; //주의 (website/index.htm
		
	}
	
	//로그인 페이지
	@RequestMapping(value="login.htm",method=RequestMethod.GET)
	public String login(HttpServletResponse response, HttpSession session) throws IOException {
		return "joinus.login";
	}
	
	//로그인 처리
	@RequestMapping(value="login.htm",method=RequestMethod.POST)
	public String logincheck(String userid, String pwd, HttpSession session) throws IOException {
		String view="";
		
		Member member = logservice.getMember(userid);
		
		boolean pwdresult = bCryptPasswordEncoder.matches(pwd, member.getPwd());
		
		if(pwdresult) {
			session.setAttribute("userid", userid);
			
			async.sampleAsync(session);
			
			view="redirect:/index.htm";
		}else {
			view="joinus.login";
		}
		return view;
	}
	
	
	
	@RequestMapping(value = "idcheck.htm", method = RequestMethod.POST)
	public View idCheck(String userid, Model model) {

		System.out.println("userid : " + userid);
		
		int result = service.idCheck(userid);
		
		if (result > 0) {
			System.out.println("아이디 중복");
			model.addAttribute("result", "사용 불가능한 아이디입니다.");
		} else {
			System.out.println("삽입 실패");
			model.addAttribute("result", "사용 가능합니다.");
		}
		return jsonview;		//{"result":"사용 불가능한 아이디입니다"}
	}
	
}
