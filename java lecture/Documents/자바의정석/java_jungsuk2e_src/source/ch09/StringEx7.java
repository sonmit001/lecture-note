class StringEx7
{
	public static void main(String[] args) 
	{
		int value = 100;
		String strValue = String.valueOf(value);	// int�� String���� ��ȯ�Ѵ�.
		
		int value2 = 100;
		String strValue2 = value2 + "";	// int�� String���� ��ȯ�ϴ� �� �ٸ� ���

		System.out.println(strValue);
		System.out.println(strValue2);
	}
}