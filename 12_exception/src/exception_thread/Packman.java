package exception_thread;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Packman extends Frame implements KeyListener, Runnable {

	
	private Image img; //null
	private Image foodImg; //null
	private int x = 225;
	private int y = 225;
	private int[] foodx = new int[5];
	private int[] foody = new int[5];
	private int mx, my;
	private int sel = 2;
	

	
	
	//1.���� �̹��� 20, 20 (o)
	//Image foodImg (o)
	//int[] foodx, foody -> 5���� ���̸� �Ѹ��� for�������� x, y�� ����ֱ� (o)
	//������ ��ǥ �߻� 0~500(o)
	//�Ѹ� ��ġ(x - 25, y - 25)  == ���� ��ġ(foodx[0], foody[0]) : ������ġ�� -100, -100���� ����
	//��Ȯ�� ��ġ�� �ƴ� �ٿ����(�ٻ�ġ)�� �����ϸ� �����ɷ� ��� - ������ ũ�⸦ �������� �� ũ�� ����(20,20���� ũ�� ���� - foodx[0] -5 , foody[0]-5, foodx[0] + 25, foody[0] + 25 )
	
	
	public Packman() {
		setBounds(700, 300, 500, 500);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.addKeyListener(this);
		
		//������ ����
		 Thread t = new Thread(this);
		//������ ����
		 t.start();
 
		 //���� �����
		 for(int i = 0; i < foodx.length; i++) {
			//���� -��ǻ�Ͱ� �������� �߻��ϴ� ��, 0 <= ���� < 1 (�Ǽ���)
			//a~b ������ ���� �߻� => (int)(math.random()*(b-a+1) + a);
			//������ ������ 50~450���� ����(���̰� �������� ©���� ���� ������)
			 foodx[i] = (int)(Math.random()*401) + 50;
			 foody[i] = (int)(Math.random()*401) + 50;	
			 
			 System.out.println("foodx[" + i + "] = " + foodx[i] + " foody[" + i + "] = " + foody[i]);

		
		 }
	}
 
	
	
	
	public void paint(Graphics g) {
		
		img = Toolkit.getDefaultToolkit().getImage("pacman.png"); //�ʵ�� ��Ƶ� ��, �� ��쿡�� �����ڿ��� ����
		g.drawImage(img, x, y, x+50, y+50, sel*50, 0, sel*50+50, 50, this); //�ڡ���ǥ ��Ģã��, ������ Ǯ�� �� ����ϱ�

		for(int i = 0; i < foodx.length; i++) {
			foodImg = Toolkit.getDefaultToolkit().getImage("food.jpg"); //�ʵ�� ��Ƶ� ��, �� ��쿡�� �����ڿ��� ����
			g.drawImage(foodImg, foodx[i], foody[i], this);	//����� x,y��ǥ�� �迭�� ���ؼ� �Է�(�Ѹ�ó�� ���� �Ķ���͸� �Է��� �ʿ� ����)
			g.drawString("-", foodx[i], foody[i]);
		}
		
		g.drawString("�����", x, y);
		
		
		//�ڡڡ��̺κ� ����ؼ� ��Ģã��
		//sel*50, 0, sel*50, 50
		//����         0, 0,  50, 50 sel = 0
		//       50, 0, 100, 50 sel = 1
		//������   100, 0, 150, 50 sel = 2
		//      150, 0, 200, 50 sel = 3
		
		/*
		Parameters:
		img the specified image to be drawn. This method doesnothing if img is null.
		dx1 the x coordinate of the first corner of thedestination rectangle.
		dy1 the y coordinate of the first corner of thedestination rectangle.
		dx2 the x coordinate of the second corner of thedestination rectangle.
		dy2 the y coordinate of the second corner of thedestination rectangle.
		sx1 the x coordinate of the first corner of thesource rectangle. //�׸��� ������  x
		sy1 the y coordinate of the first corner of thesource rectangle. //�׸��� ���� �� y
		sx2 the x coordinate of the second corner of thesource rectangle.//�׸��� ������ �Ʒ� x
		sy2 the y coordinate of the second corner of thesource rectangle.//�׸��� ������ �Ʒ� y
		observer object to be notified as more of the image isscaled and converted.
	    */

	}
	
	
    //�������̵�
	public void run() {
		while(true) {
			if(sel % 2 == 0) { //�ݺ��� + �����ư��鼭 �������� ����
				sel++;
			}else {
				sel--;
			}
			x += mx;
			y += my;
			if(x > 500) x = 0;
			else if(x < 0) x = 500;
			else if(y > 500) y = 0;
			else if(y < 0) y = 500;
			
//			System.out.println("x= " + x);
//			System.out.println("y= " + y);
			
			//�Ļ�
			//x,y�� ��� ������
			for(int i = 0; i < foodx.length; i++) { //����������� while�� �ȿ��� ������ ��
//				System.out.println("foodx[" + i + "] = " + foodx[i]);
//				System.out.println("foody[" + i + "] = " + foody[i]);
//				if(x + 25 >= foodx[i] - 5 && x + 25 <= foodx[i] + 25) {
//					for(int j = 0; j < foody.length; j++) {
//						if(y + 25 >= foody[j] - 5 && y + 25 <= foody[j]) {
//							foodx[i] = -100;
//							foody[j] = -100;
//							System.out.println("�Ծ���");
//						}
//					}
//				}
				if(x + 25 >= foodx[i] - 5 && x + 25 <= foodx[i] + 20 && y + 25 >= foody[i] - 5 && y + 25 <= foody[i] + 20) {
					foodx[i] = -100; //�ѹ� �׸� �׸��� ���� �� �����Ƿ� ��ǥ�� ������ �ʴ� ���� �ٽ� �׸����� ��
					foody[i] = -100;
//					System.out.println("�Ծ���");
				}
			}
			
			repaint();
			try {
				Thread.sleep(100); //ó���ӵ��� ���� �۾��� �� �Ⱥ���. ���� ������� �����̴� �ð��� �׷��� ����
			} catch (InterruptedException e) {
			e.printStackTrace();
			} // �⺻�� 1 / 1000��
		}
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {}


	//�̹����� ���� �����ϴ� ���� �ƴ� �ȿ� �ִ� ���� �����Ͽ� �ٸ� �׸��� ����ϵ�����
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			 sel = 0;
			 mx = -10; my = 0;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			 sel = 2;
			 mx = 10; my = 0;
		}else if(e.getKeyCode()== KeyEvent.VK_UP) {
			 sel = 4;
			  my = -10; mx = 0;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			 sel = 6;
			  my = 10; mx = 0;
		}else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		//repaint()��  run()���� �̵�
	}


	@Override
	public void keyReleased(KeyEvent e) {}

	
	public static void main(String[] args) {
		new Packman();
	}
}
