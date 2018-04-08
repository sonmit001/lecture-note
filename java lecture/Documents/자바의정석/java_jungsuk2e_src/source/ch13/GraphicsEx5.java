import java.awt.*;
import java.awt.event.*;

class GraphicsEx5 extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;

	Image img = null;
	Graphics gImg = null;

	public static void main(String[] args) {
		new GraphicsEx5("GraphicsEx5");
	}
	
	public GraphicsEx5(String title) {
		super(title);
		addMouseMotionListener(this);
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

	    // Frame�� (100, 100)�� ��ġ�� width 500, height 500 ũ��� ���̰� �Ѵ�.
		setBounds(100,100, 500,500);
		setVisible(true);

		img = createImage(500, 500);
		gImg = img.getGraphics();
		gImg.drawString("���ʹ�ư�� ���� ä�� ���콺�� ������������." ,10, 50);
		repaint();
	}

	public void paint(Graphics g) {
		if(img==null) return;
		g.drawImage(img,0,0,this); 	// ����ȭ�鿡 �׷��� �׸��� Frame�� ����
	}

	public void mouseMoved(MouseEvent me) {
		x = me.getX();
		y = me.getY();
	}
	public void mouseDragged(MouseEvent me) {
		if (me.getModifiersEx()!=MouseEvent.BUTTON1_DOWN_MASK ) return;

		gImg.drawLine(x,y, me.getX(),me.getY());
		x = me.getX();
		y = me.getY();

		repaint();
	}
} // class