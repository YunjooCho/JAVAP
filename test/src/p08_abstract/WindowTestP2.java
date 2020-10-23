package p08_abstract;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class WindowTestP2 extends Frame {

	public WindowTestP2() {
		setBounds(100, 100, 700, 700);
		setVisible(true);
		setTitle("¿ÃπÃ¡ˆ");
	}
	
	public void paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("taji2.jpg");
		//Toolkit t = Toolkit.getDefaultToolkit();
		//Image img = t.getImage
		g.drawImage(img, 50, 0, 650, 650, 0, 0, 1000, 1000, this);
	}
	
	public static void main(String[] args) {
		new WindowTestP2();

	}

}
