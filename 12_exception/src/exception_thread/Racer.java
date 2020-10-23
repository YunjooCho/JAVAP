package exception_thread;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//말 한마리
public class Racer extends Canvas implements Runnable { //Canvas는 컨테이너라 아니라 자체실행 안됨, Frame에 붙여줘야 함
						   								//들어가는 내용에 따라 크기가 자동으로 조절됨
						                                //레이아웃이 자유로움
	//6.필드선언													//Racers는 스레드가 되고싶은 캔버스임
	private Image img;
	private String name;
	private int pos;
	private static int rank = 0;
	
	//7.기본자 생성
	public Racer(String name) {
		this.name = name;
		img = Toolkit.getDefaultToolkit().getImage("horse.gif");
		//setBackground(new Color((int)(Math.random()*255+1),(int)(Math.random()*255+1),(int)(Math.random()*255+1)));
	}
	
	//8.그림 생성하기
	@Override
	public void paint(Graphics g) {
		//g.drawLine(0, this.getSize().height-1, this.getSize().width, this.getSize().height-1); //-1 : 캔버스와 선이 겹쳐서 안보임
		g.fillRect(0, this.getSize().height/50, this.getSize().width, this.getSize().height/50);
		g.drawImage(img, pos, 0, 25, this.getSize().height, this); //this = Canvas
	
	}

	@Override
	public void run() { //여기를 어떤 스레드가 실행할지는 운영체제가 관리
		for(int i = 0; i < this.getSize().width; i += ((int)(Math.random()*10+1))) { //이동할 크기를 여기서 결정(단항연산자)
			pos = i;
			RunRace rr = new RunRace();
			//System.out.println("달려라");
			repaint();
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(pos < this.getSize().width) {
			for(int i = 0; i < this.getSize().width; i++) {
				//System.out.println("도착");
				RunRace rr = new RunRace();
			}
			rank++;
			System.out.println(rank + "등 " + name);
		}
	}
}
