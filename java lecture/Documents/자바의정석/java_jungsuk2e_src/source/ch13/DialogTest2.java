import java.awt.*;
import java.awt.event.*;	// �̺�Ʈó���� ���ؼ� �߰��ؾ��Ѵ�.

class DialogTest2 {
	public static void main(String args[]) {
		Frame f = new Frame("Parent");
		f.setSize(300, 200);
		
		// parent Frame�� f�� �ϰ�, modal�� true�� �ؼ� �ʼ����� Dialog�� ��.
		final Dialog info = new Dialog(f, "Information", true);
		info.setSize(140, 90);
		info.setLocation(50, 50);	// parent Frame�� �ƴ�, ȭ������� ��ġ
		info.setLayout(new FlowLayout());

		Label msg = new Label("This is modal Dialog", Label.CENTER);
		Button ok = new Button("OK");

        ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //OK��ư�� ������ �����.
//				info.setVisible(false);	// Dialog�� �Ⱥ��̰� �Ѵ�.
				info.dispose();	 	// Dialog�� �޸𸮿��� ���ش�.
			}
		});
		info.add(msg);
		info.add(ok);
		f.setVisible(true);
		info.setVisible(true);	// Dialog�� ȭ�鿡 ���̰� �Ѵ�.
	}
} 