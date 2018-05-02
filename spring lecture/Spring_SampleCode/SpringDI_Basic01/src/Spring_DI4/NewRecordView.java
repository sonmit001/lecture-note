package Spring_DI4;

import java.util.Scanner;

public class NewRecordView implements RecordView {
	//점수 출력 (NewRecord 객체가 필요)
	private NewRecord record;

	//1. 생성자를 사용해서 필용한 객체 생성 , 주입
	//2. 함수(setter)를 통해서 필요한 객체의 주입 가능
	
	
	//Record 인터페이스 구현하는 모든 객체는 parameter 올 수 있다 
	//public void setRecord(NewRecord record) { //기존
	public void setRecord(Record record) { //다형성
		this.record = (NewRecord)record;
	}
	@Override
	public void print() {
		System.out.println(record.total() + " /" + record.avg());
	}

	@Override
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("kor :");
		record.setKor(scan.nextInt());
		
		System.out.println("eng :");
		record.setEng(scan.nextInt());
		
		System.out.println("math :");
		record.setMath(scan.nextInt());
		
	} 
}
