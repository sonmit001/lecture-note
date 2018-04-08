import java.awt.*;
import java.awt.event.*;

class TextComponentEventTest extends Frame {
	TextField tf = new TextField();
	TextArea ta = new TextArea();

	TextComponentEventTest(String title) {
		super(title); // Frame(String title)�� ȣ���Ѵ�.
		
		tf = new TextField();
		ta = new TextArea();
		add(ta, "Center");
		add(tf, "South");

		tf.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			    // TextField���� Enter�� ġ��, tf�� �Էµ� text�� TextArea�� �߰��Ѵ�.
				ta.append(tf.getText() + "\n");
				tf.setText("");	    // tf�� text�� �����.
				tf.requestFocus();
			}
		});

		ta.setEditable(false);	// TextArea�� text�� �������� ���ϰ� �Ѵ�.
		setSize(300, 200);
		setVisible(true);
		tf.requestFocus();		// focus�� TextField�� ��ġ�ϵ��� �Ѵ�.
	}

	public static void main(String args[]) {
            TextComponentEventTest mainWin =
                                 new TextComponentEventTest("TextComponentEventTest");
	}     // main�޼����� ��
}