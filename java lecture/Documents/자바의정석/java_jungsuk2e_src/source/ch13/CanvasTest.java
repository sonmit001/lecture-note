import java.awt.*;

class CanvasTest {
	public static void main(String args[]) {
		Frame f = new Frame("CanvasTest");
		f.setSize(300, 200);
		f.setLayout(null);		// Frame�� Layout Manager������ �����Ѵ�.

		Canvas c = new Canvas();
		c.setBackground(Color.pink);	// Canvas�� ����� ��ȫ��(pink)���� �Ѵ�.
		c.setBounds(50, 50, 150, 100);

		f.add(c);		// Canvas�� Frame�� ���Խ�Ų��.
		f.setVisible(true);
	}
}