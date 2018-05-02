package ncontroller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	private NoticeDao noticedao;
	
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	@RequestMapping("notice.htm")
	public String listboard(@RequestParam(value="pg",defaultValue="1") String pg,
			@RequestParam (value="f",defaultValue="TITLE") String f,
			@RequestParam(value="q",defaultValue="%%") String q,
			Model model) throws ClassNotFoundException, SQLException {
		
				
		System.out.println(pg + ", " + f + ", " + q);
	
		List<Notice> list = noticedao.getNotices(Integer.parseInt(pg), f, q);
		
		model.addAttribute("list",list);
		
		
		return "notice.jsp";
		}
	   
		
		
	@RequestMapping("noticeDetail.htm")
	public String listdetail(String seq , Model model) throws Exception {
		
		//DB연동 ....getNotice() 함수
		Notice notice = noticedao.getNotice(seq);
			
		//View 페이지 : noticeDetail.jsp
		model.addAttribute("notice",notice);
			
		return "noticeDetail.jsp";
	}
	//1. 글쓰기 화면 처리 함수 (GET)
	@RequestMapping(value="noticeReg.htm" , method = RequestMethod.GET)
	public String noteiceRegview() {
		return "noticeReg.jsp";
	}
	//2. 글쓰기 처리함수 (POST) : 파일 업로드 가능
	@RequestMapping(value="noticeReg.htm",method = RequestMethod.POST)
	public String noticeReg(Notice notice , HttpServletRequest request) throws Exception {
		
		CommonsMultipartFile imagefile = notice.getFile();
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");
		
		String fpath = path + "\\" + filename;
		notice.setFileSrc(filename);
		
		FileOutputStream fs = new FileOutputStream(fpath);
		noticedao.insert(notice);
		fs.write(imagefile.getBytes());
		fs.close();
		return "notice.htm";
	}
	//3.글 삭제하기
	@RequestMapping("noticeDel.htm")
	public String noticedel(String seq) throws Exception {
		noticedao.delete(seq);
		return "notice.htm";
	}
	//4.글 수정하기
	//함수안에 model이 있다는 것은 데이터 담아서 forward 하려고 하는것이다.
	@RequestMapping(value="noticeEdit.htm",method = RequestMethod.GET)
	public String noticeeditview(String seq , Model model) throws ClassNotFoundException, SQLException {
		Notice notice = noticedao.getNotice(seq);
		model.addAttribute("notice",notice);
		return "noticeEdit.jsp";
	}
	@RequestMapping(value="noticeEdit.htm",method = RequestMethod.POST)
	public String noticeedit(Notice notice, HttpServletRequest request) throws ClassNotFoundException, SQLException, IOException {
		CommonsMultipartFile imagefile = notice.getFile();
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");
		
		String fpath = path + "\\" + filename;
		notice.setFileSrc(filename);
		
		FileOutputStream fs = new FileOutputStream(fpath);
		noticedao.update(notice);
		fs.write(imagefile.getBytes());
		fs.close();
		
		return "redirect:noticeDetail.htm?seq="+notice.getSeq();
	}
}
