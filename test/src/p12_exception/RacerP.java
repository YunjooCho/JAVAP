package p12_exception;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//말 한마리, 캔버스 역할
public class RacerP extends Canvas implements Runnable {

	//5.필드 선언
	private Image img;
	private String name;
	private int pos;
	private static int rank = 0;
	
	//6.기본자 생성
	public RacerP(String name) {
		this.name = name;
		img = Toolkit.getDefaultToolkit().getImage("horse.gif");
		
		
	}
	
	//7.그림 생성하기
	public void paint(Graphics g) {
		g.drawImage(img, pos, 0, 25, this.getSize().height, this);
	}

	//11. 말 달리게 하기, 랭크 구하기
	@Override
	public void run() {
		for(int i = 0; i < this.getSize().width; i += ((int)(Math.random()*10 + 1))) {
			pos = i;
			RunRaceP rr = new RunRaceP();
			repaint();
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
		if(pos < this.getSize().width) {
			for(int i = 0; i< this.getSize().width; i++) {
				RunRaceP rr = new RunRaceP();
			}
			rank++;
			System.out.println(rank + "등" + name);
		}
		}
		
	}
	

	


