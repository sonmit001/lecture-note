package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Program {

	public static void main(String[] args) {
		//NewRecordView view = new NewRecordView(100, 70, 80);
		//view.print();
		/*
		NewRecord record = new NewRecord();
		NewRecordView view = new NewRecordView();

		view.setRecord(record);//객체 주입


		view.input();
		view.print();
		*
		위에서 했던 작업을 Spring 에게 맡기고 작업하기
		Spring 의 IOC 안에 : 2개의 객체를 만들고 setter 주입 작업을 xml 파일을 통해서...

		:DIConfig.xml (객체 생성 ,주입) END
		:Spring 컨테이턴 생성하고 -> DIConfig.xml read (파싱)-> 생성된 Spring container(IOC)안에 객체를 생성, 주입
		*/

		ApplicationContext context =
				new ClassPathXmlApplicationContext("DIConfig.xml");
		//위 코드가 실행되면 IOC 컨테이너 생성되고 -> DIConfig.xml read > 객체생성, 의존 설정 > END

		RecordView view =  (RecordView)context.getBean("view");
		view.input();
		view.print();
	}

}
