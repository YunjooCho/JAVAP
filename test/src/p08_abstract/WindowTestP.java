package p08_abstract;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics;

public class WindowTestP extends Frame {

	public WindowTestP() {
		//1.프레임 만들기
		setTitle("이미지");
		setBounds(900, 100, 700, 700);
		setVisible(true);//callback
	}
	
	public void paint(Graphics g) {//Window클래스의 메소드 오버라이드
		//Image img = Toolkit.getDefaultToolkit().getImage("C:\\java_se\\workspace\\08_abstract\\taji.jpg");
		Image img = Toolkit.getDefaultToolkit().getImage("taji2.jpg");
		g.drawImage(img, 50, 0, 650, 650, 0, 0, 1000, 1000, this);
		//거꾸로
		//g.drawImage(img, 50, 0, 650, 650, 1000, 1000, 0, 0, this);
	}
	
	public static void main(String[] args) {
		new WindowTestP();
		

	}

}
