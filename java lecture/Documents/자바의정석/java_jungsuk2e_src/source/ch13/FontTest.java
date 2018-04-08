import java.awt.*;

class FontTest {
	public static void main(String args[]) {
		Frame f = new Frame("Font Test");
		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// A ���� Z�� �������� ���� Label���� �����Ѵ�.
		Label abc1 = new Label(abc);
		Label abc2 = new Label(abc);
		Label abc3 = new Label(abc);
		Label abc4 = new Label(abc);
		Label abc5 = new Label(abc);

		// Serifü�̸�, ũ�Ⱑ 20�� Font
		Font f1 = new Font("Serif", Font.PLAIN, 20);	// ����ü
		Font f2 = new Font("Serif", Font.ITALIC, 20);	// �����ü
		Font f3 = new Font("Serif", Font.BOLD, 20);	        // ����ü
		Font f4 = new Font("Serif", Font.BOLD+Font.ITALIC, 20); // ���� �����ü

		abc1.setFont(f1);		// Label�� ���ο� Font�� �����Ѵ�.
		abc2.setFont(f2);
		abc3.setFont(f3);
		abc4.setFont(f4);

		f.setLayout(new FlowLayout());
		f.add(abc1);
		f.add(abc2);
		f.add(abc3);
		f.add(abc4);
		f.add(abc5);

		f.setSize(400, 200);
		f.setVisible(true);
	}
}