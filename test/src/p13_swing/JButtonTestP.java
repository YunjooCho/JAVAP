package p13_swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JButtonTestP extends JFrame {
	
	//1.필드선언
	private Icon icon1 = new ImageIcon("image/jindo.jpg");
	private Icon icon2 = new ImageIcon("image/liver.jpg");
	private Icon icon3 = new ImageIcon("image/poodle.jpg");
	private Icon icon4 = new ImageIcon("image/shizu.jpg");
	
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();
	
	public JButtonTestP() {
		super("Test");
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(2,2));
		for(int i = 0; i < jb.length; i++) {
			jb[i] = new JRadioButton(i + 1 + "번 버튼", icon1);
			container.add(jb[i]);
			jb[i].setToolTipText(i + 1 + "번째 버튼이다. 눌러....");
			jb[i].setMnemonic(i+49);
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3);
			jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]);
		}
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JButtonTestP();

	}

}
