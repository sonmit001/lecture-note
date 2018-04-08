import java.awt.*;

class ScrollPaneTest {
	public static void main(String args[]) {
		Frame f = new Frame("ScrollPaneTest");
		f.setSize(300, 200);

		ScrollPane sp = new ScrollPane();
		Panel p = new Panel();
		p.setBackground(Color.green);	// Panel�� ����� green���� �Ѵ�.
		p.add(new Button("ù��°"));		// Button�� Panel�� ���Խ�Ų��.
		p.add(new Button("�ι�°"));
		p.add(new Button("����°"));
		p.add(new Button("�׹�°"));

		sp.add(p);		// Panel�� ScrollPane�� ���Խ�Ų��.
		f.add(sp);		// ScrollPane�� Frame�� ���Խ�Ų��.
		f.setVisible(true);
	}
}