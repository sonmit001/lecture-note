package ncontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dao.MemberDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {
	@Autowired //By type
	private MemberDao memberdao;
	
	@RequestMapping(value="join.htm",method=RequestMethod.GET)
	public String join() {
		return "joinus.join";
	}
	@RequestMapping(value="join.htm",method=RequestMethod.POST)
	public String join(Member member) {
		//회원가입 처리 ... NewMemberDao
		System.out.println(member.toString());
		try {
			memberdao.insert(member);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return "redirect:/index.htm";
	}
	//로그인 페이지
	@RequestMapping(value="login.htm",method=RequestMethod.GET)
	public String login() {
		//return "login.jsp";
		return "joinus.login";//폴더명.파일명
	}
}
