package _interface;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


//6.x�� ������ �����ϴ� Ŭ���� ����
public class WindowExit implements WindowListener {//â�� Ȱ��ȭ, ��Ȱ��ȭ

	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {} //����ó��

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.out.println("���α׷� ���� ����");
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
