import java.awt.*;

class TextFieldTest {
	public static void main(String args[]) {
		Frame f = new Frame("Login");
		f.setSize(400, 65);
		f.setLayout(new FlowLayout()); // LayoutManager�� FlowLayout���� �Ѵ�.

		Label lid = new Label("ID :", Label.RIGHT);	// ������ ����������.
		Label lpwd = new Label("Password :", Label.RIGHT);

		TextField id = new TextField(10); //�� 10���� ���ڸ� �Է��� �� �ִ� TextField ����
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');	// �Է��� �� ��� '*'�� ���̵��� �Ѵ�.

		f.add(lid);	// ������ ������Ʈ���� Frame�� ���Խ�Ų��.
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.setVisible(true);
	}
}