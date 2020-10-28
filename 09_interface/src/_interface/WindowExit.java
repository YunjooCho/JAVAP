package _interface;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


//6.x를 누르면 종료하는 클래스 설계
public class WindowExit implements WindowListener {//창의 활성화, 비활성화

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {} //사후처리

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("프로그램 강제 종료");
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {}

	@Override
	public void windowDeiconified(WindowEvent arg0) {}

	@Override
	public void windowIconified(WindowEvent arg0) {}

	@Override
	public void windowOpened(WindowEvent arg0) {}
	
}
