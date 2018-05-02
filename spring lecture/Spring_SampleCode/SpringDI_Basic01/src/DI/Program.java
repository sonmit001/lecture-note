package DI;

public class Program {

	public static void main(String[] args) {
		//NewRecordView view = new NewRecordView(100, 70, 80); DI1
		NewRecordView view = new NewRecordView();
		//필요하다면
		NewRecord record = new NewRecord(100,70,80);
		view.setRecord(record);
		view.print();
		
		
	}

}

