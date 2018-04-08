import java.io.*; 
import java.util.*; 
import java.util.regex.*; 

class Exercise14_6 { 
	static String[] argArr;       // �Է��� �Ű������� ������� ���ڿ��迭 
	static File curDir; 	// ���� ���丮

	static { 
		try { 
			curDir = new File(System.getProperty("user.dir")); 
		} catch(Exception e) {} 
	} 

	public static void main(String[] args) { 
		Scanner s = new Scanner(System.in);

		while(true) { 
			try { 
				String prompt = curDir.getCanonicalPath() + ">>"; 
				System.out.print(prompt); 

				// ȭ�����κ��� ���δ����� �Է¹޴´�. 
				String input = s.nextLine(); 

				input = input.trim(); // �Է¹��� ������ ���ʿ��� �յ� ������ �����Ѵ�. 
				argArr = input.split(" +"); 

				String command = argArr[0].trim(); 

				if("".equals(command)) continue; 

				command = command.toLowerCase(); // ��ɾ �ҹ��ڷ� �ٲ۴�. 

				if(command.equals("q")) { // q �Ǵ� Q�� �Է��ϸ� ���������Ѵ�. 
					System.exit(0); 
				} else if(command.equals("cd")) { 
					cd(); 
				} else { 
					for(int i=0; i < argArr.length;i++) { 
						System.out.println(argArr[i]); 
					} 
				} 
			} catch(Exception e) { 
				e.printStackTrace(); 
				System.out.println("�Է¿����Դϴ�."); 
			}                   
		} // while(true) 
	} // main 

	public static void cd() { 
		if(argArr.length==1) { 
			System.out.println(curDir); 
			return; 
		} else if(argArr.length > 2) { 
			System.out.println("USAGE : cd directory"); 
			return; 
		} 

		String subDir = argArr[1]; 

		/*
	             ������ �ڵ带 �ϼ��ϼ���.
	            1. �Էµ� ���丮(subDir)�� ".."�̸�,
	                1.1  ���� ���丮�� ���� ���丮�� �� ���� ���丮�� �����Ѵ�.
	                     (FileŬ������ getParentFile()�� ���)
	            2. �Էµ� ���丮(subDir)�� "."�̸�, �ܼ��� ���� ���丮�� ��θ� ȭ�鿡 ����Ѵ�.
                      3. 1 �Ǵ� 2�� ��찡 �ƴϸ�, 
                           �Էµ� ���丮(subDir)�� ���� ���丮�� �������丮���� Ȯ���Ѵ�.
                     3.1 Ȯ�ΰ���� true�̸�, ���� ���丮(curDir)�� �Էµ� ���丮(subDir)�� �����Ѵ�.
                     3.2 Ȯ�ΰ���� false�̸�, "��ȿ���� ���� ���丮�Դϴ�."�� ȭ�鿡 ����Ѵ�.
		*/
	} // cd() 
}
