class Excercise4_14 { 
      public static void main(String[] args) { 
            // 1~100������ ������ ���� �� answer�� �����Ѵ�. 
            int answer = /* (1) */; 
            int input = 0;             // ������Է��� ������ ���� 
            int count = 0;             // �õ�Ƚ���� �������� ���� 

   	    // ȭ������ ���� ������Է��� �ޱ� ���ؼ� ScannerŬ���� ���
	    java.util.Scanner s = new java.util.Scanner(System.in);

            do { 
		count++;
		System.out.print("1�� 100������ ���� �Է��ϼ��� :");
		input = s.nextInt(); // �Է¹��� ���� ���� input�� �����Ѵ�.

		/*
		   (2) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
		*/
	    } while(true);  // ���ѹݺ��� 
      }       // end of main 
}       // end of class HighLow 
