class Outer {
	int value=10;

	class Inner {
		int value=20;
		void method1() {
			int value=30;

			System.out.println(/* (1) */);
			System.out.println(/* (2) */);
			System.out.println(/* (3) */);
		}
	} // InnerŬ������ ��
} // OuterŬ������ ��

class Exercise10_3 {
	public static void main(String args[]) {
		/*
			(4) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
		*/

		inner.method1();
	}
}
