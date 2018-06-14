package ncontroller;

import java.security.Principal;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dao.MemberDao;
import dao.NoticeDao;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {
	@Autowired
	private SqlSession sqlsession;
		@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="join.htm",method=RequestMethod.GET)
	public String join() {
		return "joinus.join";
	}
	@RequestMapping(value="join.htm",method=RequestMethod.POST)
	public String join(Member member) {
		//회원가입 처리 ... NewMemberDao
		int result = 0;
		String viewpage = "";
		System.out.println(member.toString());
		try {
			MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
			member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
			result = memberdao.insert(member);
			if (result > 0) {
				System.out.println("삽입 성공");
				viewpage = "redirect:/index.htm";
			} else {
				System.out.println("삽입 실패");
				viewpage = "join.htm";
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return viewpage;
	}
	//로그인 페이지
	@RequestMapping(value="login.htm",method=RequestMethod.GET)
	public String login() {
		System.out.println("login");
		//return "login.jsp";
		return "joinus.login";//폴더명.파일명
	}
	
	@RequestMapping(value="memberupdate.htm" , method=RequestMethod.GET)
	public String updateview(Model model  , Principal principal) throws ClassNotFoundException, SQLException {
		MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
		Member member = memberdao.getMember(principal.getName());
		model.addAttribute("member", member);
		return "joinus.memberupdate";
	}
	@RequestMapping(value="memberupdate.htm", method=RequestMethod.POST)
	public String updatemember(Member member , Model model , Principal principal) {
		MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
		//System.out.println("1");
		Member updatemember ;
		try {
		updatemember = memberdao.getMember(principal.getName());
		//System.out.println("2");
		updatemember.setName(member.getName());
		//System.out.println("3");
		updatemember.setEmail(member.getEmail());
		//System.out.println("4");
		updatemember.setPwd(bCryptPasswordEncoder.encode(member.getPwd()));
		//System.out.println("5");
		memberdao.updateMember(updatemember);
		//System.out.println("6");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/index.htm";
	}
}
