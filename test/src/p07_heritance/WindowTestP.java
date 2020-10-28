package p07_heritance;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTestP extends Frame {
	
	public WindowTestP() {
		super("내가 만든 윈도우");//생성자로 다른 생성자(부모클래스 생성자) 호출, 제일 첫줄에 와야함
		setBounds(700, 100, 300, 400);
		setVisible(true);
		this.setBackground(new Color(255, 220, 193));
		setForeground(Color.YELLOW);
	}
	
	public void paint(Graphics g) {
		g.drawString("도형", 100, 100);
		g.drawLine(70, 120, 200, 300);
		g.drawLine(200, 120, 70, 300);
		g.drawRect(70, 120, 120, 180);
		g.drawOval(70, 120, 120, 180);
		
	}
	
	public static void main(String[] args) {
		WindowTestP aa = new WindowTestP();

	}

}
