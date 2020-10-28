package p09_interface;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WindowTestP extends Frame implements ActionListener, MouseListener, MouseMotionListener{

	private Button exitBtn;
	
	public void init() {
		setBounds(900, 100, 300, 400);
		setVisible(true);
		
		exitBtn = new Button("종료");
		this.add("South",exitBtn);
		
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addWindowListener(new WindowExit());
		exitBtn.addActionListener(this);
	}

	//MouseMotionListener Overriding
	@Override
	public void mouseDragged(MouseEvent arg0) {
		System.out.println("마우스 드래그");
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	//MouseListener Overriding
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스 IN");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("마우스 OUT");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼으로 종료");
		System.exit(0);
		
	}
	
	public static void main(String[] args) {
		new WindowTestP().init();
	}
}
