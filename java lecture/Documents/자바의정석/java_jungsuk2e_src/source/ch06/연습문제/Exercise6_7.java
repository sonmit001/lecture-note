class MyPoint {
	int x;
	int y;

	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/*
		(1) �ν��Ͻ��޼��� getDistance�� �ۼ��Ͻÿ�.
	*/
}

class Exercise6_7 {
	public static void main(String args[]) {
		MyPoint p = new MyPoint(1,1);

        	// MyPoint�� (2,2)�� �Ÿ��� ���Ѵ�.
		System.out.println(p.getDistance(2,2)); 
	}
}
