package AOP_Basic_Spring_08;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import unit.*;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:AOP_Basic_Spring_08/ApplicationContext.xml");
	
		Tank tank = ctx.getBean("tankmech", Tank.class);
		System.out.println(tank.repair(120));
		System.out.println("-------------------------------");
		
		
		Battle battle = ctx.getBean("battlemech", Battle.class);
		System.out.println(battle.repair(280));
		System.out.println("-------------------------------");
		
		Command command = ctx.getBean("commandmech", Command.class);
		System.out.println(command.repair(1475));
		System.out.println("-------------------------------");
		
		Marine marine = ctx.getBean("marine", Marine.class);
		System.out.println(marine.repair(10));
		
		ctx.close();
	}
}
