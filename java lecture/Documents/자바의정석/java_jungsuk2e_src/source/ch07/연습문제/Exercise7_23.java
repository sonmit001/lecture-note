class Exercise7_23 
{
	/*
		(1) sumArea�޼��带 �ۼ��Ͻÿ�.
	*/

	public static void main(String[] args) 
	{
		Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1)};

		System.out.println("������ ��:"+sumArea(arr));
	}
}
