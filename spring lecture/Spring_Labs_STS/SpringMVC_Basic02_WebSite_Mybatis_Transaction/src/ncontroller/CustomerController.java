package ncontroller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CustomerService;
import vo.Notice;

// >/customer/notice.htm
// >/customer/noticeDetail.htm


@Controller
@RequestMapping("/customer/")
public class CustomerController {

	@Autowired
	private CustomerService customerservice;
	
	//글 목록보기
	@RequestMapping("notice.htm")
	public String notices(String pg , String f , String q , Model model) throws ClassNotFoundException, SQLException {
		
		List<Notice> list = customerservice.notices(pg, f, q);
		model.addAttribute("list", list);
		return "customer.notice";
	}
	
	//글 상세보기
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq , Model model) throws ClassNotFoundException, SQLException {
			
		Notice	notice = customerservice.noticeDetail(seq);
		model.addAttribute("notice", notice);
		return "customer.noticeDetail";
	}

	//글쓰기 화면 
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.GET)
	public String noticeReg() {
			return "customer.noticeReg";
		}
	
	//글쓰기 (처리)
	@RequestMapping(value="noticeReg.htm",method=RequestMethod.POST)
	public String noticeReg(Notice notice, HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
		String url = "redirect:notice.htm";	
		try {
			url = customerservice.noticeReg(notice, request);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		//예외 발생에 상관없이 목록페이지 요청 처리
		return url;
		
		
	}

	//글삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticeDel(String seq) throws ClassNotFoundException, SQLException {
			   
			return customerservice.noticeDel(seq);
		}

	
	//글수정하기 (수정하기 화면)
	@RequestMapping(value="noticeEdit.htm",method=RequestMethod.GET)	
	public String noticeEdit(String seq, Model model) throws ClassNotFoundException, SQLException {
		
		Notice notice =  customerservice.noticeEdit(seq);
		model.addAttribute("notice", notice);
	    return "customer.noticeEdit";
	  }
	
	//글수정하기(수정 처리)
	@RequestMapping(value="noticeEdit.htm",method=RequestMethod.POST )
	public String noticeEdit(Notice n , HttpServletRequest request) throws IOException, ClassNotFoundException, SQLException {
		
		   return customerservice.noticeEdit(n, request);
		 
    }
	@RequestMapping("download.htm")
	public void download(String p, String f, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		customerservice.download(p, f, request, response);
	}
}
