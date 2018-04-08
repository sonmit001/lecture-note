import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 

class TextEditor extends Frame { 
	String fileName; 
	TextArea content; 
	MenuBar mb; 
	Menu mFile; 
	MenuItem miNew, miOpen, miSaveAs, miExit; 

	TextEditor(String title) { 
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
		FileReader fr; 
		BufferedReader br; 
		StringWriter sw; 

		try { 
			fr = new FileReader(fileName); 
			br= new BufferedReader(fr); 
			sw = new StringWriter(); 

			int ch = 0; 
			while ((ch=br.read())!=-1) { 
				sw.write(ch);                   
			} 
			br.close(); 
			content.setText(sw.toString()); 
		} catch(IOException e) { 
			e.printStackTrace();             
		} 
	} // fileOpen�޼����� �� 

	// TextArea�� ������ ������ ���Ͽ� �����ϴ� �޼��� 
	void saveAs(String fileName) { 
		FileWriter fw; 
		BufferedWriter bw; 
		try { 
			fw = new FileWriter(fileName); 
			bw= new BufferedWriter(fw); 
			bw.write(content.getText());       // TextArea�� ������ ���Ͽ� �����Ѵ�. 
			bw.close(); 
		} catch (IOException ie) { 
			ie.printStackTrace(); 
		} // try 
	} // saveAs�޼����� �� 

	public static void main(String args[]) { 
		TextEditor mainWin = new TextEditor("Text Editor"); 
	}       // main�޼����� �� 

	// �޴��� Ŭ������ �� �޴��� ó���ڵ� 
	class MyHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e) { 
			String command = e.getActionCommand(); 

			if(command.equals("New")) { 
				content.setText(""); 
			} else if(command.equals("Open")) { 
				FileDialog fileOpen = new FileDialog(TextEditor.this, "���Ͽ���"); 
				fileOpen.setVisible(true); 
				fileName = fileOpen.getDirectory() + fileOpen.getFile(); 
				System.out.println(fileName); 
				// ���õ� ������ ������ TextArea�� �����ش�. 
				fileOpen(fileName);
			} else if(command.equals("Save As...")) { 
				FileDialog fileSave = new FileDialog(TextEditor.this,"��������",FileDialog.SAVE); 
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
}       // TextEditorŬ������ �� 
