package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.OrderCommand;
import com.model.OrderItem;

//주문화면, 주문 처리
//Forward방식 : 같은 URL이다. (method GET,POST로 나누어 화면처리)

//1.요청주소달리하기 : /order/order.do
//				 /order/orderok.do

//2.같은 요청 주소 : /order/order.do : 로 화면과 처리를 다르게한다.
@Controller
@RequestMapping("/order/Order.do")
public class OrderController {
	@RequestMapping(method = RequestMethod.GET) // 화면
	public String form() {
		return "order/OrderForm";
	}

	@RequestMapping(method = RequestMethod.POST) // 처리
	public String submit(OrderCommand ordercommand) {
		System.out.println("ordercommand 주소: " + ordercommand);
		System.out.println("ordercommand 크기 : " + ordercommand.getOrderItem().size());
		//검증 코드
		List<OrderItem> items = ordercommand.getOrderItem();//상품목록 List주소값 리턴
		for(OrderItem item : items) {
			System.out.println(item.toString());
		}
		return "order/OrderCommited";
	}
}
