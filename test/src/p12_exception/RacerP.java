package p12_exception;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//�� �Ѹ���, ĵ���� ����
public class RacerP extends Canvas implements Runnable {

	//5.�ʵ� ����
	private Image img;
	private String name;
	private int pos;
	private static int rank = 0;
	
	//6.�⺻�� ����
	public RacerP(String name) {
		this.name = name;
		img = Toolkit.getDefaultToolkit().getImage("horse.gif");
		
		
	}
	
	//7.�׸� �����ϱ�
	public void paint(Graphics g) {
		g.drawImage(img, pos, 0, 25, this.getSize().height, this);
	}

	//11. �� �޸��� �ϱ�, ��ũ ���ϱ�
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
			System.out.println(rank + "��" + name);
		}
		}
		
	}
	

	


