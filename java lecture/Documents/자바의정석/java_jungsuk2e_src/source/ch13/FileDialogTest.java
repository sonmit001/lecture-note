import java.awt.*;
import java.awt.event.*;

class FileDialogTest {
	public static void main(String args[]) {
		Frame f = new Frame("Parent");
		f.setSize(300, 200);

		FileDialog fileOpen = new FileDialog(f, "���Ͽ���", FileDialog.LOAD);
		
		f.setVisible(true);
		fileOpen.setDirectory("c:\\jdk1.5");
		fileOpen.setVisible(true);

		//������ ������ ����, FileDialog�� �����ư�� ������,
		// getFile()�� getDirectory()�� �̿��ؼ� �����̸��� ��ġ�� ���丮�� ���� �� �ִ�.
		System.out.println(fileOpen.getDirectory() + fileOpen.getFile());
	}
}