package exception_thread;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//�� �Ѹ���
public class Racer extends Canvas implements Runnable { //Canvas�� �����̳ʶ� �ƴ϶� ��ü���� �ȵ�, Frame�� �ٿ���� ��
						   								//���� ���뿡 ���� ũ�Ⱑ �ڵ����� ������
						                                //���̾ƿ��� �����ο�
	//6.�ʵ弱��													//Racers�� �����尡 �ǰ���� ĵ������
	private Image img;
	private String name;
	private int pos;
	private static int rank = 0;
	
	//7.�⺻�� ����
	public Racer(String name) {
		this.name = name;
		img = Toolkit.getDefaultToolkit().getImage("horse.gif");
		//setBackground(new Color((int)(Math.random()*255+1),(int)(Math.random()*255+1),(int)(Math.random()*255+1)));
	}
	
	//8.�׸� �����ϱ�
	@Override
	public void paint(Graphics g) {
		//g.drawLine(0, this.getSize().height-1, this.getSize().width, this.getSize().height-1); //-1 : ĵ������ ���� ���ļ� �Ⱥ���
		g.fillRect(0, this.getSize().height/50, this.getSize().width, this.getSize().height/50);
		g.drawImage(img, pos, 0, 25, this.getSize().height, this); //this = Canvas
	
	}

	@Override
	public void run() { //���⸦ � �����尡 ���������� �ü���� ����
		for(int i = 0; i < this.getSize().width; i += ((int)(Math.random()*10+1))) { //�̵��� ũ�⸦ ���⼭ ����(���׿�����)
			pos = i;
			RunRace rr = new RunRace();
			//System.out.println("�޷���");
			repaint();
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(pos < this.getSize().width) {
			for(int i = 0; i < this.getSize().width; i++) {
				//System.out.println("����");
				RunRace rr = new RunRace();
			}
			rank++;
			System.out.println(rank + "�� " + name);
		}
	}
}
