import java.io.*;
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class Exercise13_6 extends Frame {
	Panel  pDate	  = new Panel();
	Panel  pUp		  = new Panel();

	Button btnPrevMon = new Button("��");
	Button btnNextMon = new Button("��");
	Label  lblYearMon = new Label();

	Button[] btnArr = new Button[42]; 

	Calendar curMon = Calendar.getInstance();

	Exercise13_6(String title) {
		super(title);

		pUp.setBackground(Color.yellow);
		pUp.setLayout(new FlowLayout(FlowLayout.CENTER));
		pUp.add(btnPrevMon);
		pUp.add(lblYearMon);
		pUp.add(btnNextMon);


		pDate.setLayout(new GridLayout(6,7));
		for(int i=0; i < btnArr.length;i++) {
			btnArr[i] = new Button("");
			pDate.add(btnArr[i]);
		}

		btnPrevMon.addActionListener(new BtnEventHandler());
		btnNextMon.addActionListener(new BtnEventHandler());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				we.getWindow().setVisible(false);
				we.getWindow().dispose();
				System.exit(0);
			}
		});

		add(pUp,"North");
		add(pDate,"Center");
		setBounds(200,200,500,300);
		setDays(curMon);
		setVisible(true);
	} // MyScheduler

	void setDays(Calendar date) {
		int year  = date.get(Calendar.YEAR); 
		int month = date.get(Calendar.MONTH); 

		lblYearMon.setText(year+"�� "+(month+1)+"��");

		Calendar sDay = Calendar.getInstance(); // ������ 

		/*
		   (1) �˸��� �ڵ带 �����ÿ�.
		   1. ������(sDay)�� �ش���� 1���� ���Ե� �Ͽ��Ϸ� �����Ѵ�.
		   2. �ݺ����� ����ؼ� sDay�� ���� 1�� ������Ű�鼭 ��ư�� ��¥�� �ִ´�.
		   3. ���� ��¥�� �ش� ���� ���ϸ� ��ư�� ������ ���(Color.white)���� �ϰ�
                          �׷��� ������ ���� ȸ��(Color.lightGray)���� �����Ѵ�.
		*/
	} // setDays(Calendar date)

	class BtnEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			/*
				(2) �˸��� �ڵ带 �����ÿ�.
				1. ������ ��ư�� btnPrevMon�̸�, curMon�� �� �� �������� �����Ѵ�.
				2. ������ ��ư�� btnNextMon�̸�, curMon�� �� �� ���ķ� �����Ѵ�.
				3. setDays()�� ȣ���ؼ� ����� ������ ���̺� ���̰� �Ѵ�.
			*/
		}
	}

	public static void main(String[] args) {
		Exercise13_6 mainWin = new Exercise13_6("Scheduler");
	} // main
}
