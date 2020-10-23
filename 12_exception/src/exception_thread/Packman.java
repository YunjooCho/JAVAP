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
	

	
	
	//1.먹이 이미지 20, 20 (o)
	//Image foodImg (o)
	//int[] foodx, foody -> 5개의 먹이를 뿌린다 for문돌려서 x, y에 집어넣기 (o)
	//난수로 좌표 발생 0~500(o)
	//팩맨 위치(x - 25, y - 25)  == 음식 위치(foodx[0], foody[0]) : 음식위치를 -100, -100으로 지움
	//정확한 위치가 아닌 바운더리(근사치)에 접근하면 먹은걸로 취급 - 먹이의 크기를 가상으로 더 크게 잡음(20,20보다 크게 생각 - foodx[0] -5 , foody[0]-5, foodx[0] + 25, foody[0] + 25 )
	
	
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
		
		//스레드 생성
		 Thread t = new Thread(this);
		//스레드 실행
		 t.start();
 
		 //먹이 만들기
		 for(int i = 0; i < foodx.length; i++) {
			//난수 -컴퓨터가 무작위로 발생하는 수, 0 <= 난수 < 1 (실수형)
			//a~b 사이의 난수 발생 => (int)(math.random()*(b-a+1) + a);
			//영역의 범위는 50~450으로 잡음(먹이가 공간에서 짤리는 일이 없도록)
			 foodx[i] = (int)(Math.random()*401) + 50;
			 foody[i] = (int)(Math.random()*401) + 50;	
			 
			 System.out.println("foodx[" + i + "] = " + foodx[i] + " foody[" + i + "] = " + foody[i]);

		
		 }
	}
 
	
	
	
	public void paint(Graphics g) {
		
		img = Toolkit.getDefaultToolkit().getImage("pacman.png"); //필드로 잡아도 됨, 이 경우에는 생성자에서 생성
		g.drawImage(img, x, y, x+50, y+50, sel*50, 0, sel*50+50, 50, this); //★★좌표 규칙찾기, 선생님 풀이 식 계산하기

		for(int i = 0; i < foodx.length; i++) {
			foodImg = Toolkit.getDefaultToolkit().getImage("food.jpg"); //필드로 잡아도 됨, 이 경우에는 생성자에서 생성
			g.drawImage(foodImg, foodx[i], foody[i], this);	//여기는 x,y좌표만 배열을 통해서 입력(팩맨처럼 여러 파라미터를 입력할 필요 없음)
			g.drawString("-", foodx[i], foody[i]);
		}
		
		g.drawString("배고파", x, y);
		
		
		//★★★이부분 계산해서 규칙찾기
		//sel*50, 0, sel*50, 50
		//왼쪽         0, 0,  50, 50 sel = 0
		//       50, 0, 100, 50 sel = 1
		//오른쪽   100, 0, 150, 50 sel = 2
		//      150, 0, 200, 50 sel = 3
		
		/*
		Parameters:
		img the specified image to be drawn. This method doesnothing if img is null.
		dx1 the x coordinate of the first corner of thedestination rectangle.
		dy1 the y coordinate of the first corner of thedestination rectangle.
		dx2 the x coordinate of the second corner of thedestination rectangle.
		dy2 the y coordinate of the second corner of thedestination rectangle.
		sx1 the x coordinate of the first corner of thesource rectangle. //그림의 왼쪽위  x
		sy1 the y coordinate of the first corner of thesource rectangle. //그림의 왼쪽 위 y
		sx2 the x coordinate of the second corner of thesource rectangle.//그림의 오른쪽 아래 x
		sy2 the y coordinate of the second corner of thesource rectangle.//그림의 오른쪽 아래 y
		observer object to be notified as more of the image isscaled and converted.
	    */

	}
	
	
    //오버라이드
	public void run() {
		while(true) {
			if(sel % 2 == 0) { //반복문 + 번갈아가면서 나오도록 변경
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
			
			//식사
			//x,y는 계속 움직임
			for(int i = 0; i < foodx.length; i++) { //순서상관없이 while문 안에만 있으면 됨
//				System.out.println("foodx[" + i + "] = " + foodx[i]);
//				System.out.println("foody[" + i + "] = " + foody[i]);
//				if(x + 25 >= foodx[i] - 5 && x + 25 <= foodx[i] + 25) {
//					for(int j = 0; j < foody.length; j++) {
//						if(y + 25 >= foody[j] - 5 && y + 25 <= foody[j]) {
//							foodx[i] = -100;
//							foody[j] = -100;
//							System.out.println("먹었다");
//						}
//					}
//				}
				if(x + 25 >= foodx[i] - 5 && x + 25 <= foodx[i] + 20 && y + 25 >= foody[i] - 5 && y + 25 <= foody[i] + 20) {
					foodx[i] = -100; //한번 그린 그림은 지울 수 없으므로 좌표를 보이지 않는 곳에 다시 그리도록 함
					foody[i] = -100;
//					System.out.println("먹었다");
				}
			}
			
			repaint();
			try {
				Thread.sleep(100); //처리속도가 빨라 글씨가 잘 안보임. 지금 명령으로 움직이는 시간이 그래도 찍힘
			} catch (InterruptedException e) {
			e.printStackTrace();
			} // 기본이 1 / 1000초
		}
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {}


	//이미지를 새로 생성하는 것이 아닌 안에 있는 값을 변경하여 다른 그림을 출력하도록함
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
		//repaint()를  run()으로 이동
	}


	@Override
	public void keyReleased(KeyEvent e) {}

	
	public static void main(String[] args) {
		new Packman();
	}
}
