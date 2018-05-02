package DI;

public class NewRecordView {
	//점수 출력 (NewRecord 객체가 필요)
	private NewRecord record;
	//1. 생성자를 통해서 필요한 객체 생성 , 주입 >> DI1
	/*public NewRecordView(int kor , int eng , int math) {
		record = new NewRecord(kor, eng, math);
	}*/
	//2. 함수(setter)를 통해서 필요한 객체를 주입 >> DI2
	/*public NewRecord getRecord() {
	return record;
	}*/
	
	public void setRecord(NewRecord record) { // 필수의 parameter로 NewRecord 객체의 주소
		this.record = record;
	}
	public void print() {
		System.out.println(record.total() + " /" + record.avg());
	}

	
}
