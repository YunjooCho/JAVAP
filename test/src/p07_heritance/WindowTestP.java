package p07_heritance;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTestP extends Frame {
	
	public WindowTestP() {
		super("���� ���� ������");//�����ڷ� �ٸ� ������(�θ�Ŭ���� ������) ȣ��, ���� ù�ٿ� �;���
		setBounds(700, 100, 300, 400);
		setVisible(true);
		this.setBackground(new Color(255, 220, 193));
		setForeground(Color.YELLOW);
	}
	
	public void paint(Graphics g) {
		g.drawString("����", 100, 100);
		g.drawLine(70, 120, 200, 300);
		g.drawLine(200, 120, 70, 300);
		g.drawRect(70, 120, 120, 180);
		g.drawOval(70, 120, 120, 180);
		
	}
	
	public static void main(String[] args) {
		WindowTestP aa = new WindowTestP();

	}

}
