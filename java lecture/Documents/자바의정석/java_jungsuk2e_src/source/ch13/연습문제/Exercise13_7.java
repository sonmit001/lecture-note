import java.awt.*;
import java.awt.event.*;

class Exercise13_7 extends Frame implements MouseListener  {
	final int LINE_NUM   = 9;   // ������ �� �� 
	final int LINE_WIDTH = 30; // ������ �� ����
	final int BOARD_SIZE = LINE_WIDTH * (LINE_NUM-1); // �������� ũ��
	final int STONE_SIZE = (int)(LINE_WIDTH * 0.8);	  // ���� ũ��
	
	final int X0; // ������ ������ġ x��ǥ
	final int Y0; // ������ ������ġ y��ǥ

	final int FRAME_WIDTH;   // Frame�� ��
	final int FRAME_HEIGHT;  // Frame�� ����

	Image img = null;
	Graphics gImg = null;

	public Exercise13_7(String title) {
		super(title);

		// Event Handler�� ����Ѵ�.
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		setVisible(true);	// Frame�� ȭ�鿡 ���̰� �Ѵ�.
		Insets insets = getInsets(); // ȭ�鿡 ���̱� ������ Insets�� ���� ���� �� ����.

		// ������ �׷��� ��ġ(LEFT, TOP)�� ��ǥ X0, Y0�� �����Ѵ�.
		X0 = insets.left + LINE_WIDTH;
		Y0 = insets.top  + LINE_WIDTH;

		// Frame�� ũ�⸦ ����Ѵ�.
  	        FRAME_WIDTH   = BOARD_SIZE+LINE_WIDTH*2+insets.left+insets.right;
 	        FRAME_HEIGHT = BOARD_SIZE+LINE_WIDTH*2+insets.top+insets.bottom;

		// Frame�� ȭ���� (100,100)�� ��ġ�� ���� ũ��� ���̰� �Ѵ�.
		setBounds(100,100, FRAME_WIDTH, FRAME_HEIGHT);

		img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
		gImg = img.getGraphics();

		setResizable(false);	// Frame�� ũ�⸦ �������� ���ϰ� �Ѵ�.
		drawBoard(gImg);
	} // Exercise13_7(String title)

	public void drawBoard(Graphics g) {
		for(int i=0; i<LINE_NUM;i++) {
		      g.drawLine(X0,Y0+i*LINE_WIDTH,X0+BOARD_SIZE, Y0+i*LINE_WIDTH);
		      g.drawLine(X0+i*LINE_WIDTH,Y0, X0+i*LINE_WIDTH, Y0+BOARD_SIZE);
		}
	}

	public void paint(Graphics g) {
		if(img==null) return;

		g.drawImage(img,0,0,this); // ����ȭ�鿡 �׷��� �׸��� Frame�� ����
	}

	public void mousePressed(MouseEvent e) {		// MouseListener
		int x = e.getX();	// ���콺 �������� x��ǥ
		int y = e.getY();	// ���콺 �������� y��ǥ
		
		/*
		   (1) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
		    1. x�� y�� ���� Ŭ���� ������ ���� ����� ���������� �����Ѵ�.(�ݿø�)
		    2. x�� y�� ������ ���� ũ��(STONE_SIZE)�� ������ ���� Ŭ���� ���� ���� �׷�����.
		    3. x�� y�� ���� �������� ���� ��� ���̸� ���� �׸��� �ʴ´�.
		    4. ������ ��ư�� ���콺 ���� ��ư�̸�, (x,y)�� ��ġ�� ���� ���� �׸���
		       ������ ��ư�� ���콺 ������ ��ư�̸�, (x,y)�� ��ġ�� �� ���� �׸���.
		       (�� ���� �׸� �� ���� �� �׵θ��� ���� �׸���.)
		    5. repaint()�� ȣ���Ѵ�.
		*/
	}

	public void mouseClicked(MouseEvent e) {}	// MouseListener
	public void mouseEntered(MouseEvent e) {}	// MouseListener
	public void mouseExited(MouseEvent e) {}	// MouseListener
	public void mouseReleased(MouseEvent e) {}	// MouseListener

	public static void main(String[] args) {
		new Exercise13_7("OmokTest");
	}
}
