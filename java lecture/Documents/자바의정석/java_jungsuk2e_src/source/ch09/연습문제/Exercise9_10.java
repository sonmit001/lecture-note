class Exercise9_10
{
	static String format(String str, int length, int alignment) { 
		/*	
			(1) format�޼��带 �ۼ��Ͻÿ�.
			1. length�� ���� str�� ���̺��� ������ length��ŭ�� �߶� ��ȯ�Ѵ�.
			2. 1�� ��찡 �ƴϸ�, lengthũ���� char�迭�� �����ϰ� �������� ä���.
			3. ��������(alignment)�� ���� ���� ���ڿ�(str)�� ������ ��ġ�� �����Ѵ�.
			   (System.arraycopy()���)
			4. 2���� ������ char�迭�� ���ڿ��� ���� ��ȯ�Ѵ�.
		*/
	}

	public static void main(String[] args) {
		String str = "������";

		System.out.println(format(str,7,0)); // ���� ����
		System.out.println(format(str,7,1)); // ��� ����
		System.out.println(format(str,7,2)); // ������ ����
	}
}
