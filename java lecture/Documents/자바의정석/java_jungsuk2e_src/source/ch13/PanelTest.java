import java.awt.*;

class PanelTest {
	public static void main(String args[]) {
		Frame f = new Frame("Panel");
		f.setSize(300, 200);
		f.setLayout(null);		// Frame�� Layout Manager�� ������� �ʵ��� �Ѵ�.

		Panel p = new Panel();
		p.setBackground(Color.green);	// Panel�� ����� ������� �Ѵ�.
		p.setSize(100, 100);
		p.setLocation(50, 50);

		Button ok = new Button("OK");

		p.add(ok);		// Button�� Panel�� ���Խ�Ų��.
		f.add(p);		// Panel�� Frame�� ���Խ�Ų��.
		f.setVisible(true);
	}
}