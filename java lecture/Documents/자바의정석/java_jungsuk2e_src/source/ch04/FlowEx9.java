class FlowEx9
{
	public static void main(String[] args) 
	{
		int score = (int)(Math.random() * 10) + 1;
		String msg ="";

		score *= 100;		// score = score * 100;

		msg = "����� ������ " + score + "�̰�, ��ǰ�� ";

	
		switch(score) {
			case 1000 :
				msg += "������, ";		// msg = msg + "������, ";
			case 900 :
				msg += "TV, ";			
			case 800 :
				msg += "��Ʈ��, ";			
			case 700 :
				msg += "������, ";			
			default :
				msg += "����";
		}

		System.out.println( msg + "�Դϴ�.");
	}
}