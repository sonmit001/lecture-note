class Exercise6_23
{
	/*
		(1) max�޼��带 �ۼ��Ͻÿ�.
	*/

	public static void main(String[] args) 
	{
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("�ִ밪:"+max(data));
		System.out.println("�ִ밪:"+max(null));
		System.out.println("�ִ밪:"+max(new int[]{})); // ũ�Ⱑ 0�� �迭
	}
}
