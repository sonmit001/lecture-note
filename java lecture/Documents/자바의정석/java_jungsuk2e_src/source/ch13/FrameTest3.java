import java.awt.*;
import java.awt.event.*;

class FrameTest3 {
	public static void main(String args[]) {
		Frame f = new Frame("Login");	// Frame��ü�� �����Ѵ�.
		f.setSize(300, 200);			// Frame�� ũ�⸦ �����Ѵ�.

		// EventHandlerŬ������ ��ü�� �����ؼ� Frame�� WindowListener�� ����Ѵ�.
		f.addWindowListener(new EventHandler());
		f.setVisible(true);				// ������ Frame�� ȭ�鿡 ���̵��� �Ѵ�.
	}
}

class EventHandler implements WindowListener
{
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) {	// Frame�� �ݱ� ��ư�� ������ �� ȣ��ȴ�.
		e.getWindow().setVisible(false);		// Frame�� ȭ�鿡�� ������ �ʵ��� �ϰ�
		e.getWindow().dispose();				// �޸𸮿��� �����Ѵ�.
		System.exit(0);							// ���α׷��� �����Ѵ�.
	}
	public void windowClosed(WindowEvent e) {}	// �ƹ����뵵 ���� �޼��� ����
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}