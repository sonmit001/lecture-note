import java.awt.*;

class LabelTest {
	public static void main(String args[]) {
		Frame f = new Frame("Login");
		f.setSize(300, 200);
		f.setLayout(null);

		Label id = new Label("ID :");	 // Label�� �����ϰ� ũ��� ��ġ�� �����Ѵ�.
		id.setBounds(50, 50, 30, 10);	 // 50, 50��ġ�� ũ�Ⱑ ���� 30, ���� 10

		Label pwd = new Label("Password :");
		pwd.setBounds(50, 65, 100, 10);

		f.add(id);	// ������ Label�� Frame�� ���Խ�Ų��.
		f.add(pwd);
		f.setVisible(true);
	}
}