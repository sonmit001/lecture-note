import java.awt.*;

class DialogTest {
	public static void main(String args[]) {
		Frame f = new Frame("Parent");
		f.setSize(300, 200);
		
		// parent Frame�� f�� �ϰ�, modal�� true�� �ؼ� �ʼ����� Dialog�� ��.
		Dialog info = new Dialog(f, "Information", true);
		info.setSize(140, 90);
		info.setLocation(50, 50);	   // parent Frame�� �ƴ�, ȭ���� ��ġ�� ������ �ȴ�.
		info.setLayout(new FlowLayout());

		Label msg = new Label("This is modal Dialog", Label.CENTER);
		Button ok = new Button("OK");
		info.add(msg);
		info.add(ok);

		f.setVisible(true);
		info.setVisible(true);	// Dialog�� ȭ�鿡 ���̰� �Ѵ�.
	}
}