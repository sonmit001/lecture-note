class Exercise6_20
{
	/*
		(1) shuffle�޼��带 �ۼ��Ͻÿ�.
	*/

	public static void main(String[] args) 
	{
		int[] original = {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));

		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}

