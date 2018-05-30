package kr.or.kosta.servlet;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kosta.dao.EmpDAO;
import kr.or.kosta.dto.emp;
import kr.or.kosta.service.EmpService;
import kr.or.kosta.service.EmpValidator;
import kr.or.kosta.service.JoinCommandValidator;
/*
 * redirect : 원래 리턴값은 Tiles.xml로 가는데 redirect:를 쓰면 바로 controller로 와서 mapping을 찾는다!
 */
@Controller
public class EmpController {
	@Autowired
	private SqlSession sqlsession;
	@Autowired
	private EmpService empservice;
	
	
	@RequestMapping("login.htm")
	public String getLogin(String id,String pw, HttpServletRequest request) {
		System.out.println("로그인처리");
		emp e = empservice.getLogin(id,pw);
		String result="";
		if(e!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("nickname", e.getEname());
			System.out.println(e.getEname());
			System.out.println("get:"+session.getAttribute("nickname"));
			result="redirect:index.htm";
		}else {
			result="login.jsp";
		}
		return result;
	}
	
	
	//회원 리스트
	@RequestMapping("index.htm")
	public String getEmpList(String cpage, String pagesize, Model model){
		
		//null체크
		System.out.println("컨트롤러시작");
		List<emp> list=null;
		try {
			list = empservice.getEmpList(cpage, pagesize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EmpDAO empdao = sqlsession.getMapper(EmpDAO.class);
		
		
		int totalemplist = empdao.totalboardCount();
		int pagecount =0;
		if(totalemplist % 5 == 0){
			   pagecount = totalemplist/5;
		}else{
			   pagecount = (totalemplist/5) +1;
		}
		
		if(cpage==null){
			   cpage="1";
		}
		
		model.addAttribute("list",list);
		model.addAttribute("cpage",cpage);
		model.addAttribute("pagecount",pagecount);
		
		return "emp.index";
	}
	//회원등록
	@RequestMapping(value="joinEmp.htm", method=RequestMethod.GET)
	public String joinEmpForm() {
		return "emp.empinsert";
	}
	//회원등록
	@RequestMapping(value="joinEmp.htm", method=RequestMethod.POST)
	public String joinEmp(@Valid emp e,Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("여기는 EmpController 에러있음!! empinsert로 복귀~");
			return "emp.empinsert";
		}
		System.out.println("여기는 EmpController 에러없음!! insert하러 service로 이동전");
		empservice.joinEmp(e);
		System.out.println("여기는 EmpController 에러없음!! service에서 insert끝! index.htm으로 복귀");
		return "redirect:index.htm";
	}
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		System.out.println("JoinCommandValidator로 이동하기 위한 @IntiBinder");
		binder.setValidator(new JoinCommandValidator());
	}
	
	//회원수정
	   @RequestMapping(value="editEmp.htm", method=RequestMethod.POST)
	   public String editEmp(@ModelAttribute("emp") emp e,BindingResult bindingResult) {
	      new EmpValidator().validate(e, bindingResult);
	      if(bindingResult.hasErrors()) {
	         return "emp.empupdate";
	      }
	      empservice.editEmp(e);
	      return "redirect:index.htm";
	   }
	   //회원수정
	   @RequestMapping(value="editEmp.htm", method=RequestMethod.GET)
	   public String editEmpForm(@ModelAttribute("emp") emp e) {
	      return "emp.empupdate";
	   }
	//회원삭제
	@RequestMapping("delEmp.htm")
	public String delEmp(String empno) {
		empservice.delEmp(empno);
		return "redirect:index.htm";
	}
	//회원검색
	@RequestMapping(value="searchEmp.htm",method=RequestMethod.GET)
	public String empSearch() {
		return "emp.search";
	}
	
	//회원검색
	@RequestMapping(value="searchEmp.htm",method=RequestMethod.POST)
	public String empSearch(String searchtype,String search,Model model) {
		System.out.println(searchtype+","+search);
		List<emp> list = empservice.getSearch(searchtype, search);
		model.addAttribute("list",list);
		return "emp.search";
	}
	@RequestMapping(value="multiSearchEmp.htm",method=RequestMethod.POST)
	public String multiEmpSearch(String ename, String deptno, String empno, String keyvalue,Model model) {
		System.out.println(ename+"//"+deptno+"//"+empno+"//"+keyvalue);
		List<emp> list = empservice.multiEmpSearch(ename, deptno, empno, keyvalue);
		model.addAttribute("list",list);
		return "emp.search";
		
	}
}
