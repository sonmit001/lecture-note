package com.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//HelloController가 controller역할을 하기 위해서는 controller interface를 구현했다.
//단점 : controller하나가 기능 한가지이다.

//@Controller는 함수단위로 기능을 넣을 수 있게 한다. controller하나로 여러 기능을 할 수 있다.
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		System.out.println("[hello do start]");
		ModelAndView mv = new ModelAndView();
		mv.addObject("greeting",getGreeting());
		mv.setViewName("Hello");
		return mv;
	}
	//필요하다면 일반함수 만들어서 사용가능
	public String getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String data="";
		if(hour >= 6 && hour <= 10) {
			data = "학습시간";
		}else if(hour >= 11 && hour <=15) {
			data = "배고픈 시간";
		}else if(hour >= 16 && hour <=18) {
			data = "졸려운 시간";
		}else {
			data = "go home";
		}
		return data;
	}
}
