import java.awt.*;
import java.awt.event.*;

class TextFieldTest2 extends Frame {
	Label lid;
	Label lpwd;
	TextField tfId;
	TextField tfPwd;
	Button ok;

	TextFieldTest2(String title) {
		super(title); // Frame(String title)�� ȣ���Ѵ�.

		lid = new Label("ID :", Label.RIGHT); // Label�� text������ ����������.
		lpwd = new Label("Password :", Label.RIGHT);

        // �� 10���� ���ڸ� �Է��� �� �ִ� TextField ����.
		tfId = new TextField(10);	
		tfPwd = new TextField(10);
		tfPwd.setEchoChar('*'); // �Է��� �� ��� '*'�� ���̰� �Ѵ�.

		ok = new Button("OK");
		// OK��ư�� TextField�� �̺�Ʈó���� ���� Listener�� �߰����ش�.
		tfId.addActionListener(new EventHandler());
		tfPwd.addActionListener(new EventHandler());
		ok.addActionListener(new EventHandler());

		setLayout(new FlowLayout()); // LayoutManager�� FlowLayout����
		add(lid);	// ������ Component���� Frame�� ���Խ�Ų��.
		add(tfId);
		add(lpwd);
		add(tfPwd);
		add(ok);
		setSize(450, 65);
		setVisible(true); // Frame�� ȭ�鿡 ���̰� �Ѵ�.
	}

	public static void main(String args[]) {
		TextFieldTest2 f = new TextFieldTest2("Login");
	}

	class EventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String id = tfId.getText();	 // tfId�� �ԷµǾ��ִ� text�� ���´�.
			String password = tfPwd.getText();
			if (!id.equals("javachobo")){				
				System.out.println("�Է��Ͻ� id�� ��ȿ���� �ʽ��ϴ�. �ٽ� �Է��� �ּ���.");
				// id�� �ٽ� �Է��� �� �ֵ���, focus�� tfId�� �ű��.
				tfId.requestFocus();	      
				tfId.selectAll();    // tfId�� �Էµ� text�� ���õǰ� �Ѵ�.
			} else if (!password.equals("asdf")) {
				System.out.println("�Է��Ͻ� ��й�ȣ�� Ʋ�Ƚ��ϴ�. �ٽ� �Է��� �ֽñ� �ٶ��ϴ�.");
				
                             // id�� �ٽ� �Է��� �� �ֵ��� focus�� tfId�� �ű��.
				tfPwd.requestFocus();
				tfPwd.selectAll();
			} else {
				System.out.println( id + "��, ���������� �α��� �Ǿ����ϴ�.");
			}
		}
	} // class EventHandler
}