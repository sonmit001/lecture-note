package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.NewArticleCommand;
import com.service.ArticleService;

@Controller
@RequestMapping("/article/newArticle.do") //GET방식 요청, POST방식 요청
public class NewArticleController {
	
	private ArticleService articleservice;
	//**하나의 요청 주소로 : 2가지 판단 (GET, POST) > method=GET , method=POST
	//글쓰기(GET) , 글쓰기 완료(POST)
	//GET방식 요청(사용자에게 화면만 제공)
	
	@Autowired
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		System.out.println("GET방식에 대한 요청");
		return "article/newArticleForm";
		//ViewResolver에 의해서 
	}
	
	//동작 원리 : JSP (UseBean Action 태그 사용 : setProperty...)
	//전제 조건 : Form tag가 가지는 name속성의 이름이 DTO객체의 member field명과 같아야한다.
	//함수의 parameter로 DTO 타입을 사용
	//넘어오는 parameter가 DTO type의 member field명과 같다면
	//1.자동으로 DTO 객체가 생성된다 : NewArticleCommand newArticleCommand = new NewArticleCommand가 자동으로 일어난다. 
	//2.자동으로 넘어온 parameter 값을 setter함수를 이용하여 자동 주입
	//2.1 NewArticleCommand 객체가 IOC 컨테이너에 id="newArticleCommand" 자동 생성.
	//원칙 : ModelAndView mv = new ModelAndView(); mv.addObject("command",command); return mv;
	//3. 위 원칙이 없어도 view 페이지에 DTO 객체(NewArticleCommand)의 주소가 자동 forward된다. 
	/*
		1. submit(NewArticleCommand command)
		>자동 객체 생성되고 객체 변수명이(key) : newArticleCommand
	 	
	 	2. 이름이 자동으로 생성되는 것이 싫다. @ModelAttribute("Articledata")
	 	>>자동으로 생성되는 객체 변수명을 제어한다. >> Articledata으로 강제 >>key : Articledata
	 	
	 	3. Model.addAttribute("Articledata",new NewArticleCommand()); 이 작업이 자동으로 된다.
	 	
	 	
	 	
	*/
	
	
	
	
	
	
	//POST 방식 요청(DB단 처리 Insert처리)
	@RequestMapping(method=RequestMethod.POST)
	/*public String submit(NewArticleCommand command) {*/
	public String submit(@ModelAttribute("Articledata")NewArticleCommand command) {
		System.out.println("POST방식에 대한 요청");
		//1. parameter받기
		//2. Service객체 생성하기 ArticleService service = new ArticleService()
		//3. Service객체 함수 호출하기
		//4. 결과 받아서 return하기
		articleservice.writeArticle(command);
		return "article/newArticleSubmitted";
	}
	/* Spring에서 더이상 사용 안함
	 @RequestMapping(method=RequestMethod.POST)
	public String submit(HttpServletRequest request) {
		
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		articleservice.writeArticle(article);
			
		return "article/newArticleSubmitted";
	}
	
	 */
}
