import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 

class Exercise14_9 extends Frame { 
	String fileName; 
	TextArea content; 
	MenuBar mb; 
	Menu mFile; 
	MenuItem miNew, miOpen, miSaveAs, miExit; 

	Exercise14_9(String title) { 
		super(title); 
		content = new TextArea(); 
		add(content); 

		mb		= new MenuBar(); 
		mFile	= new Menu("File"); 

		miNew   = new MenuItem("New"); 
		miOpen  = new MenuItem("Open"); 
		miSaveAs = new MenuItem("Save As..."); 
		miExit   = new MenuItem("Exit"); 

		mFile.add(miNew); 
		mFile.add(miOpen); 
		mFile.add(miSaveAs); 
		mFile.addSeparator(); // �޴� �и���(separator)�� �ִ´�. 
		mFile.add(miExit); 

		mb.add(mFile);             // MenuBar�� Menu�� �߰��Ѵ�. 
		setMenuBar(mb);            // Frame�� MenuBar�� ���Խ�Ų��. 

		// �޴��� �̺�Ʈ �ڵ鷯�� ����Ѵ�. 
		MyHandler handler = new MyHandler(); 
		miNew.addActionListener(handler); 
		miOpen.addActionListener(handler); 
		miSaveAs.addActionListener(handler); 
		miExit.addActionListener(handler); 

		setSize(300, 200); 
		setVisible(true); 
	} 

	// ���õ� ������ ������ �о TextArea�� �����ִ� �޼��� 
	void fileOpen(String fileName) { 
		/*
		   (1) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
		   1. BuffredReader�� FileReader�� �̿��ؼ� ������ ������ ���δ����� �д´�.
		   2. StringWriter�� ����Ѵ�.
		   3. StringWriter�� ������ content(TextArea)�� �����ش�.
		*/
	} // fileOpen�޼����� �� 

	// TextArea�� ������ ������ ���Ͽ� �����ϴ� �޼��� 
	void saveAs(String fileName) { 
		/*
		   (2) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
		   1. BuffredWriter�� FileWriter�� �����Ѵ�.
		   2. content�� �ִ� ������ �����ͼ� BufferedWriter�� ����Ѵ�.
		   3. BufferedWriter�� �ݴ´�.
		*/
	} // saveAs�޼����� �� 

	public static void main(String args[]) { 
		Exercise14_9 mainWin = new Exercise14_9("Text Editor"); 
	}       // main�޼����� �� 

	// �޴��� Ŭ������ �� �޴��� ó���ڵ� 
	class MyHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) { 
			String command = e.getActionCommand(); 

			if(command.equals("New")) { 
				content.setText(""); 
			} else if(command.equals("Open")) { 
				FileDialog fileOpen = new FileDialog(Exercise14_9.this, "���Ͽ���"); 
				fileOpen.setVisible(true); 
				fileName = fileOpen.getDirectory() + fileOpen.getFile(); 
				System.out.println(fileName); 
				// ���õ� ������ ������ TextArea�� �����ش�. 
				fileOpen(fileName);
			} else if(command.equals("Save As...")) { 
				FileDialog fileSave = new FileDialog(Exercise14_9.this,"��������",FileDialog.SAVE); 
				fileSave.setVisible(true); 
				fileName = fileSave.getDirectory() + fileSave.getFile(); 
				System.out.println(fileName); 
				// ���� TextArea�� ������ ���õ� ���Ͽ� �����Ѵ�. 
				saveAs(fileName); 
			} else if(command.equals("Exit")) { 
				System.exit(0);       // ���α׷��� �����Ų��. 
			} 
		} 
	} // class MyHandler 
} // Exercise14_9Ŭ������ �� 
