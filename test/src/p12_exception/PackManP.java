package p12_exception;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//1.상속
public class PackManP extends Frame {

	//2.필드 선언
	private Image img, foodImg;
	private int x = 225;
	private int y = 225;
	private int[] foodX = new int[5];
	private int[] foodY = new int[5];
	private int mx, my;

	
	public PackManP() {
		
		//3.프레임 생성
		setBounds(700, 300, 500, 500);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
	}
	
	public void paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("pacman.png");
		
		//★★좌표 규칙찾기, 선생님 풀이 식 계산하기
		//g.drawImage(img, x, y, x+50, y+50, sel*50, sy1, sx2, sy2, observer)
	}
	
	public static void main(String[] args) {
		new PackManP();

	}

}
