package p12_exception;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//1.���
public class PackManP extends Frame {

	//2.�ʵ� ����
	private Image img, foodImg;
	private int x = 225;
	private int y = 225;
	private int[] foodX = new int[5];
	private int[] foodY = new int[5];
	private int mx, my;

	
	public PackManP() {
		
		//3.������ ����
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
		
		//�ڡ���ǥ ��Ģã��, ������ Ǯ�� �� ����ϱ�
		//g.drawImage(img, x, y, x+50, y+50, sel*50, sy1, sx2, sy2, observer)
	}
	
	public static void main(String[] args) {
		new PackManP();

	}

}
