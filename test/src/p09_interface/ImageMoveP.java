package p09_interface;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ImageMoveP extends Frame implements ActionListener, KeyListener, WindowListener {
	public static void main(String[] args) {
		new ImageMoveP().init();
	}

	//2-1.��ư�����
	private Button resetBtn, leftBtn, upBtn, downBtn, rightBtn;
	private int x = 100; int y = 100;
	
	public void init() {
		
		//1.������ �����
		setBounds(300, 300, 500, 500);
		setVisible(true);
		setResizable(true);
		
		//2-2.��ư �����
		resetBtn = new Button("�ʱ�ȭ");
		leftBtn = new Button("����");
		upBtn = new Button("����");
		downBtn = new Button("�Ʒ���");
		rightBtn = new Button("������");
		
		Panel p = new Panel();
		p.add(resetBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);
		
		add("North",p);
		
		resetBtn.setFocusable(false);
		leftBtn.setFocusable(false);
		upBtn.setFocusable(false);
		downBtn.setFocusable(false);
		rightBtn.setFocusable(false);
		
		//3.�̺�Ʈ
		resetBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		
		this.addWindowListener(this);
		
	}
	
	//4-1.ActionListener�������̵�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == resetBtn) {
			x = 100;
			y = 100;
		}else if(e.getSource() == leftBtn) {
			x -= 10;
		}else if(e.getSource() == upBtn) {
			y -= 10;
		}else if(e.getSource() == downBtn) {
			y += 10;
		}else if(e.getSource() == rightBtn){
			x += 10;
		}
		repaint();
	}
	

	//4-2.WindowListener �������̵�
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	
	//6.KeyListener �������̵�
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			y -= 10;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 10;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	
	
	//5.�̹��� ����
	public void paint(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("puppy.jpg");
		g.drawImage(img, x, y, this);
	}

	
	
	

}
