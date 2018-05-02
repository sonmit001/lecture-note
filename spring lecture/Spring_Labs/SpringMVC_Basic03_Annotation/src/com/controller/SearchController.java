package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	/*
	 WEB : 클라이언트가 전송한 데이터 를 받기 (회원가입 데이터 , 게시판 입력 데이터등)
	 
	 방법 1: 전통 (request 객체)
	 void searchInternal(HttpServletRequest request){
	 	String id = request.getParameter("id")
	 }
	 방법 2 : DTO 객체를 통해서 받기 
	  : 선행조건 사용자가 보낸 값의 parameter명과 DTO의 member field명과 같아야한다.
	 void searchInternal(MemberDto member){
	 	IOC컨테이너 자동으로 객체가 생성되고 
	 	자동으로 주입되고(값이)
	 	View Page까지 자동으로 간다.(memberDto key 만들어져 전달)
	 }
	 방법 3 : Spring Annotation > @RequestParam
	  	방법1과 2의 단점은 유효성 체크가 되지 않는다. 
	  	3은 간단한 유효성 처리, 기본값에 대한 설정이 가능하다.
	  	
	방법 4 : 편하게 객체단위로 받지 않는 값들
	void searchInternal(int page , int number)
	**넘어오는 parameter 이름이 함수의 parameter명과 같으면 
	internal.do?page=100&number=1000 이면 자동으로 들어간다. 
	
	방법 5 : @PathVariable /member/{memberid}
	게시판 : http://cafe.naver.com/bitcamp104/1358
	 */
	
	//방법 3 : Spring Annotation > @RequestParam
	@RequestMapping("search/internal.do")
  	public ModelAndView searchInternal(@RequestParam("query") String query ,
  										@RequestParam("p") int p) {
		System.out.println("param query : " + query);
		System.out.println("param p : " + p);
		System.out.println("search/internal");
		
		return new ModelAndView("search/internal");
  		
  	}
	
	//default 활용한다면 게시판 List 페이지에 (기본값 설정시..)
	/*@RequestMapping("search/external.do")
  	public ModelAndView searchExternal(@RequestParam(value="query",defaultValue="default",required=false) String query ,
  										@RequestParam(value="p",defaultValue="1111") int p) {
		System.out.println("param query : " + query);
		System.out.println("param p : " + p);
		System.out.println("search/external");
		
		return new ModelAndView("search/internal");
  		
  	}*/
	
	//방법4(편하게 : 객체단위로 받지 않는 값들)
	//넘어오는 값의 이름과 parameter이름이 같아야한다.
	@	RequestMapping("search/external.do")
  	public ModelAndView searchExternal(String query ,int p) {
		System.out.println("param query : " + query);
		System.out.println("param p : " + p);
		System.out.println("search/external");
		
		return new ModelAndView("search/internal");
  		
  	}
  	
}
