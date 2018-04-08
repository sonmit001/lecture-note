import java.util.*;
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
	final int SPEED = 7;

	int x;
	int y;
	boolean isPlaying = true;
	ArrayList balls = new ArrayList();

	BouncingBall(String title) {
		super(title);

		x = FRAME_WIDTH/2  - BALL_SIZE/2;
		y = FRAME_HEIGHT/2 - BALL_SIZE/2;

		setBounds(300,200, FRAME_WIDTH, FRAME_HEIGHT);
		setResizable(false);
		setVisible(true);
		
		Insets insets = getInsets();

		TOP    = insets.top;
		LEFT   = insets.left;
		BOTTOM = FRAME_HEIGHT - insets.bottom;
		RIGHT  = FRAME_WIDTH  - insets.right;

		registerEventHandler();
	}

	void registerEventHandler() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke){
				if(!isPlaying) return;

				int key = ke.getKeyCode();

				if(key==KeyEvent.VK_UP){
				   /*
				     (1) �˸��� �ڵ带 �����ÿ�.
				   */
				}else if(key==KeyEvent.VK_DOWN){
				   /*
				     (2) �˸��� �ڵ带 �����ÿ�.
				   */
				}else if(key==KeyEvent.VK_LEFT){
				   /*
				     (3) �˸��� �ڵ带 �����ÿ�.
				   */
				}else if(key==KeyEvent.VK_RIGHT){
				   /*
				     (4) �˸��� �ڵ带 �����ÿ�.
				   */
				}
			} // public void keyPressed(KeyEvent ke)
		});
	}

	void start() {
		new BallGenerator().start();

		while(isPlaying) {
			int size = balls.size();

			for(int i=0 ; i < size; i++) {
				Ball b = (Ball)balls.get(i);

				b.x +=b.xStep;
				b.y +=b.yStep;

			/*
			   (5) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
			  1. b.x�� ���� ���� �׵θ�(LEFT)���� �۰ų� ������
 			     b.x�� ���� LEFT�� �ٲٰ� x�� �̵�����(b.xStep)�� �ݴ�� �Ѵ�.
			  2. b.x�� ���� ������ �׵θ�(RIGHT-b.size)���� �۰ų� ������
 			     b.x�� ���� RIGHT-b.size�� �ٲٰ� x�� �̵�����(b.xStep)�� �ݴ�� �Ѵ�.
			  3. b.y�� ���� �� �� �׵θ�(TOP)���� �۰ų� ������
 			     b.y�� ���� TOP���� �ٲٰ� y�� �̵�����(b.yStep)�� �ݴ�� �Ѵ�.
			  4. b.y�� ���� �Ʒ� �� �׵θ�(BOTTON-b.size)���� �۰ų� ������
 			     b.y�� ���� BOTTON-b.size�� �ٲٰ� y�� �̵�����(b.yStep)�� �ݴ�� �Ѵ�.
			*/
			} // for

			repaint();

			try {
				Thread.sleep(100);
			} catch (Exception e) {}
		}
	} // start()

	boolean collisionCheck(Ball b) {
		/*
		   (6) �˸��� �ڵ带 �־� �ϼ��Ͻÿ�.
		  1. �Ķ����� �߽ɰ� �������� �߽ɰ��� �Ÿ�(distance)�� 
                         �Ķ����� ������(BALL_SIZE/2)�� �������� ������(b.size)���� ���ų� ������
		     true�� ��ȯ�ϰ� �׷��� ������ false�� ��ȯ�Ѵ�.
		     �Ķ����� ��ġ�� (x, y)�� ��, �߽� ��ǥ�� (x+BALL_SIZE/2, y+BALL_SIZE)�̴�.
                         �� �� (x1, y1)�� (x2, y2)���� �Ÿ��� �Ʒ��� �������� ���� �� �ִ�.
                         Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2))
		*/
	}

	public void paint(Graphics g) {
		g.drawString("Number of balls :"+balls.size(),20,50);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, BALL_SIZE, BALL_SIZE);

		g.setColor(Color.RED);

		int size = balls.size();

		for(int i=0 ; i < size; i++) {
			Ball b = (Ball)balls.get(i);
			g.fillOval(b.x, b.y, b.size, b.size);
		}
	}

	class BallGenerator extends Thread {
		public void run() {
			while(isPlaying) {
			   int x=(int)(Math.random()*(RIGHT-LEFT-Ball.MAX_SIZE))+LEFT;
			   int y=(int)(Math.random()*(BOTTOM-TOP-Ball.MAX_SIZE))+TOP;

			   balls.add(new Ball(x,y));

			   try {
				Thread.sleep(3*1000);			
			   } catch(Exception e) {}
			}
		} // run()
	}

	class Ball {
		int x = 100;
		int y = 100;
		int size = 30;

		static final int MAX_SIZE = 30;
		static final int MIN_SIZE = 10;

		final int SPEED = 5;
		int xStep = SPEED;
		int yStep = SPEED;

		Ball(int x, int y) {
			this(x, y,(int)(Math.random()*(MAX_SIZE-MIN_SIZE))+MIN_SIZE);
		}

		Ball(int x, int y, int size) {
			this.x = x;		
			this.y = y;		
			this.size = size;		
		}
	}
} // class BouncingBall

class Exercise13_11 {
	public static void main(String[] args) {
		new BouncingBall("Bouncing Ball").start();		
	}
}
