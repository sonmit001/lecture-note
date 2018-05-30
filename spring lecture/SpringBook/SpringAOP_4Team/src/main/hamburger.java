package main;

import java.util.Scanner;
import java.util.Stack;

public class hamburger {
	Stack gilbertBurger = new Stack();
	public void make() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("(1번) MR.프레지던트  (2번) 길버트  (3번) 길버트JR");
		int number = sc.nextInt();
		
		switch (number) {
		case 1:
			gilbertBurger=mrpresdent();
			break;
		case 2:
			gilbertBurger=gburger();
			break;
		case 3:
			gilbertBurger=gburgerjr();
			break;
		}
		while(!gilbertBurger.isEmpty()) {
			System.out.println("(   "+gilbertBurger.pop()+"    )");
		}
		
	}
	private Stack gburgerjr() {
		Stack<String> one = new Stack<>();
		one.push("밑빵");
		one.push("케챱");
		one.push("치킨");
		one.push("상추");
		one.push("윗빵");
		return one;
	}
	private Stack gburger() {
		Stack<String> one = new Stack<>();
		one.push("밑빵");
		one.push("치즈");
		one.push("패티");
		one.push("양파");
		one.push("윗빵");
		return one;
	}
	public Stack<String> mrpresdent() {
		Stack<String> one = new Stack<>();
		one.push("밑빵");
		one.push("에그");
		one.push("패티");
		one.push("상추");
		one.push("메요");
		one.push("윗빵");
		
		return one;
	}
	
}
