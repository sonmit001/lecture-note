class FlowEx3 
{ 
      public static void main(String[] args) 
      { 
            int score = 45; 
            char grade =' ';  // ������ �����ϱ� ���� ����. �������� �ʱ�ȭ�Ѵ�.

            if (score >= 90) {          // score�� 90�� ���� ���ų� ũ�� A����
                   grade = 'A';             
            } else if (score >=80) {   // score�� 80�� ���� ���ų� ũ�� B���� 
                   grade = 'B'; 
            } else {                     // �������� C����
                   grade = 'C'; 
            }
            
            System.out.println("����� ������ " + grade + "�Դϴ�."); 
      } 
} 