import java.util.*;

class Exercise12_9 {
	Vector words = new Vector();
	String[] data = {"�¿�","����","����","ȿ��","����","����","Ƽ�Ĵ�","���","����ī"};		
	int interval = 2 * 1000;  // 2��

	WordGenerator wg = new WordGenerator();

	public static void main(String args[]) {
		Exercise12_9 game = new Exercise12_9();

		game.wg.start();

		Vector words = game.words;

		while(true) { 
			System.out.println(words);

			String prompt = ">>"; 
			System.out.print(prompt); 

			// ȭ�����κ��� ���δ����� �Է¹޴´�. 
			Scanner s = new Scanner(System.in); 
			String input = s.nextLine().trim(); 

			int index = words.indexOf(input);

			if(index!=-1) {
				words.remove(index);
			}
		}
	} // main

	class WordGenerator extends Thread {
		public void run() {
			/*
				(1) �˸��� �ڵ带 �����ÿ�.
				1. interval(2��)���� �迭 data�� �� �� �ϳ��� ���Ƿ� �����ؼ�
				2. words�� �����Ѵ�.
			*/
		} // end of run()
	} // class WordGenerator
} // Exercise12_9
