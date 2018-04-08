import java.util.*;
import java.awt.*;
import java.awt.event.*;

class BouncingBall extends Frame {
	final int FRAME_WIDTH  = 400;
	final int FRAME_HEIGHT = 300;

	final int TOP;
	final int BOTTOM;
	final int LEFT;
	final int RIGHT;

	ArrayList balls = new ArrayList();

	BouncingBall(String title) {
		super(title);

		setBounds(300,200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);
		
		Insets insets = getInsets();

		TOP    = insets.top;
		LEFT   = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT  = FRAME_WIDTH  - insets.right;

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	void start() {
		new BallGenerator().start();

		while(true) {
			int size = balls.size();

			for(int i=0 ; i < size; i++) {
				Ball b = (Ball)balls.get(i);

				b.x +=b.xStep;
				b.y +=b.yStep;

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
			}

			repaint();

			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	} // start()

	public void paint(Graphics g) {
		g.drawString("Number of balls :"+balls.size(),20,50);
		g.setColor(Color.RED);

		int size = balls.size();

		for(int i=0 ; i < size; i++) {
			Ball b = (Ball)balls.get(i);
			g.fillOval(b.x, b.y, Ball.SIZE, Ball.SIZE);
		}
	}

	class BallGenerator extends Thread {
		public void run() {
			/*
			   (2) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
			  1. 3�� ���� Frame�� ������ ��ġ�� ���� �����ؼ� balls�� �߰��Ѵ�.
			*/			
		} // run()
	}

	class Ball {
		int x = 100;
		int y = 100;

		static final int SIZE = 30;

		final int SPEED = 5;
		int xStep = SPEED;
		int yStep = SPEED;

		Ball(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
} // class BouncingBall

class Exercise13_9 {
	public static void main(String[] args) {
		new BouncingBall("Bouncing Ball").start();		
	}
}
