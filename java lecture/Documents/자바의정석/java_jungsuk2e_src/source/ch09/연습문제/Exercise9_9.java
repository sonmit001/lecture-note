class Exercise9_9 {
	/*
		(1) delChar�޼��带 �ۼ��Ͻÿ�.
	*/

	public static void main(String[] args) 	{
		System.out.println("(1!2@3^4~5)"+" -> " + delChar("(1!2@3^4~5)","~!@#$%^&*()"));
		System.out.println("(1 2    3   4\t5)"+" -> " + delChar("(1 2    3   4\t5)"," \t"));
	}
}

