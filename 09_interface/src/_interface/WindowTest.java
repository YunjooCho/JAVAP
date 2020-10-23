package _interface;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//1.FrameŬ���� ���
//3.�������̽�
public class WindowTest extends Frame 
	implements ActionListener, MouseListener, MouseMotionListener {
	//�ڹ� Ŭ������ ���� ���
	//�ٸ� Ŭ�����κ��� ���� �ް� ������ interface
	
	//7-1.��ư ����
	private Button exitBtn; //null��, ������ �ݵ�� �ʿ�
	
	//2.�޼ҵ� �ۼ�
	public void init() {
		//7-2.
		exitBtn = new Button("����");
		//��ġ
		this.add("North", exitBtn);
		
		
		//2-1. ������ ����
		setBounds(900, 100, 300, 400);
		setVisible(true);
		
		//8.�̺�Ʈ
		this.addMouseListener(this);
		//(this) : ��ġ�� ��Ÿ��, this�� WindowTestŬ�������� ������ �������� ����Ŵ
		this.addMouseMotionListener(this);
		this.addWindowListener(new WindowExit());//�ٸ� Ŭ���� ȣ��
		exitBtn.addActionListener(this); 
		//�����ư�� ������ JVM�� this(�� Ŭ����)��
		//ActionListener�� actionPerformed�� ã�ư�->System.exit(0)�� ���� ����
	}

	//7-3.ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư���� ����");
		System.exit(0);	
	}
	
	//4. MouseListener Overriding, CallBack�޼ҵ�
	@Override
	public void mouseClicked(MouseEvent e) {//����
		System.out.println("���콺 Ŭ��");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("���콺 IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("���콺 OUT");
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	
	//5. MouseMotionListener Overriding
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("���콺 �巡��");
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	
	//9.ȣ��
	public static void main(String[] args) {
		new WindowTest().init(); //���� + ������ + �޼ҵ� ȣ��
	}

	
	
}
