import java.awt.*;

class ButtonTest {
	public static void main(String args[]) {
		Frame f = new Frame("Login");
		f.setSize(300, 200);

		Button b = new Button("Ȯ ��");  // Button���� "Ȯ ��"�̶�� ���ڰ� ��Ÿ����.
		b.setSize(100, 50);				 // Button�� ũ�⸦ �����Ѵ�.

		f.add(b);				     // ������ Button�� Frame�� ���Խ�Ų��.
		f.setVisible(true);
	}
}