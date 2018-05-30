package controller;

import java.security.Principal;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.MemberDAO;
import dto.MemberDTO;

@Controller
public class JoinusController {

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="login.htm", method=RequestMethod.GET)
	public String login(){
		System.out.println("로그인페이지 이동");
		return "joinus.login";
	}

	
	
/*	@RequestMapping(value="login.htm", method=RequestMethod.POST)
	public String login(@RequestParam("password") String rawPassword, Principal principal){
		System.out.println(rawPassword);
		String viewpage="";
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		MemberDTO memberDTO = memberDAO.getMember(principal.getName());
		System.out.println(principal);
		String encodedPassword = memberDTO.getPassword();
		
		boolean result = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
		
		if(result){
			viewpage = "redirect:/index.htm";
		}else{
			viewpage = "joinus.login";
		}
		return viewpage;
	}*/
	
	@RequestMapping("/join.htm")
	public String join(){
		return "joinus.join";
	}
	
	@RequestMapping(value="join.htm" , method=RequestMethod.POST)
	public String join(MemberDTO memberDTO){
		memberDTO.setPassword(this.bCryptPasswordEncoder.encode(memberDTO.getPassword()));
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		memberDAO.insert(memberDTO);
		memberDAO.grant(memberDTO);
		return "redirect:/index.htm";
	}
	
}
