package nested;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowTest extends Frame {
	//���θ޼ҵ�
	public static void main(String[] args) {
		new WindowTest();
	}
	
	//������
	public WindowTest() {
		setBounds(100, 100, 300, 400);
		setVisible(true);
		
		//�̺�Ʈ
		this.addWindowListener(new WindowAdapter() { //WindowAdapter�� API���� ã����
													 //WindowAdapter�� �߻�Ŭ����, ������ new�ȵ�
													 
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//WindowListener�������̽��� ��G�ϴ� ���,
		//WindowListener�� ������ �ִ� ��� �޼ҵ带 Override�ؾ� ��
		//�͸� Ŭ������ ����ϴ� ��� �ʿ��� �޼ҵ常 ������ ����� �� ����
		
		this.addMouseListener(new MouseAdapter() { //MouseAdapter�� �߻�Ŭ����, ������ new�ȵ�
												   //MouseAdapter�� 5���� �߻�޼ҵ� Override - �� body
												   //������ 2���� �� body�� �ƴ� �������̵� ����
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("���콺IN");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("���콺OUT");
			}
		});
	}

}
