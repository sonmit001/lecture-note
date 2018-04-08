class Point implements Cloneable { // Cloneable�������̽��� ������ Ŭ���������� clone()�� ȣ���� �� �ִ�. �� �������̽��� �������� �ʰ� clone()�� ȣ���ϸ� ���ܰ� �߻��Ѵ�.
	int x;
	int y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "x="+x +", y="+y;
	}

	public Point clone() {
		Object obj=null;
		try {
			obj = super.clone();
		} catch(CloneNotSupportedException e) {} // clone�޼��忡�� CloneNotSupportedException�� ����Ǿ� �����Ƿ� �� �޼��带 ȣ���� ���� try-catch���� ����ؾ��Ѵ�.
		return (Point)obj;
	}
}

class CloneTest {
	public static void main(String[] args){
		Point original = new Point(3, 5);
		Point copy = original.clone(); // ��ü�� �����ؼ� ���ο� ��ü�� �����.
		System.out.println(original);
		System.out.println(copy);
	}
}




