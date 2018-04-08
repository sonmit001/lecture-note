import java.awt.*;
import java.awt.event.*;


class BouncingBall extends Frame {
	final int BALL_SIZE = 20;
	final int FRAME_WIDTH  = 400;
	final int FRAME_HEIGHT = 300;

	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;
	final int SPEED = 3;
	
	int x = 100;
	int y = 100;

	int xStep = SPEED;
	int yStep = SPEED;

	BouncingBall(String title) {
		super(title);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setBounds(300,200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);		

		Insets insets = getInsets(); // Frame�� �׵θ��� �β��� ���´�.

		TOP    = insets.top;
		LEFT   = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom ;
		RIGHT  = FRAME_WIDTH  - insets.right;
	}

	void start() {
		while(true) {
			x +=xStep;
			y +=yStep;
			
			/*
			   (1) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
			  1. x�� ���� ���� �׵θ�(LEFT)���� �۰ų� ������
 			     x�� ���� LEFT�� �ٲٰ� x�� �̵�����(xStep)�� �ݴ�� �Ѵ�.
			  2. x�� ���� ������ �׵θ�(RIGHT-BALL_SIZE)���� �۰ų� ������
 			     x�� ���� RIGHT-BALL_SIZE�� �ٲٰ� x�� �̵�����(xStep)�� �ݴ�� �Ѵ�.
			  3. y�� ���� �� �� �׵θ�(TOP)���� �۰ų� ������
 			     y�� ���� TOP���� �ٲٰ� y�� �̵�����(yStep)�� �ݴ�� �Ѵ�.
			  4. y�� ���� �Ʒ� �� �׵θ�(BOTTON-BALL_SIZE)���� �۰ų� ������
 			     y�� ���� BOTTON-BALL_SIZE�� �ٲٰ� y�� �̵�����(yStep)�� �ݴ�� �Ѵ�.
			*/

			repaint();

			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	} // start()

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);
	}
}

class Exercise13_8 {
	public static void main(String[] args) {
		new BouncingBall("Bouncing Ball").start();		
	}
}
