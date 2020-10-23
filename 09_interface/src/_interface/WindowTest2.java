package _interface;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//1. ��� �� ���ø���Ʈ
//Frame�� BorderLayout(��������)
public class WindowTest2 extends Frame implements ActionListener, MouseListener, WindowListener {
	private Button redBtn, greenBtn, blueBtn, exitBtn;
	private int x, y;
	public static void main(String[] args)  {
		new WindowTest2().init();
	}
	
	//2. ������ ����
	public void init() {
		redBtn = new Button("   ����   ");
		greenBtn = new Button("   �ʷ�   ");
		blueBtn = new Button("   �Ķ�   ");
		exitBtn = new Button("   ����   ");
		
		Panel p = new Panel(); //Panel�� FlowLayOut(������ġ - �߾��� �߽����� ������ ��ġ)
		p.setBackground(new Color(119,200,250));
		p.add(redBtn); //�ǳڿ� ��ü �߰�
		p.add(greenBtn);
		p.add(blueBtn);
		p.add(exitBtn);
		
		this.add("North",p); //�������� ���κп� Panel�� ����. Panel ���� ��ư 3���� ����
							 //���ڼ��� ���� ��ư�� ũ�Ⱑ ���� ����
//		this.add("North", redBtn);
//		this.add("South", greenBtn);
//		this.add("Center", blueBtn);
		
		
		setBounds(900, 100, 300, 400);
		setVisible(true);
		
		//4.�̺�Ʈ
		this.addWindowListener(this); 
		//this - FrameŬ����(WindowTest2���� ���), Frameâ
		//addWindowListener() - �޼ҵ��
		//()�����θ� ���� ���� �ִ���
		//redBtn.addActionListener(arg0);
		redBtn.addActionListener(this);
		greenBtn.addActionListener(this);
		blueBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		this.addMouseListener(this);
	}
	
	//5.������ �ȿ� �۾� ǥ��
	public void paint(Graphics g) {//WindowŬ����
								   //setVisible(true)�� ����Ǹ� �ٷ� ����� ���⶧���� �Ѵ� 0���� ����
								   //x = 0, y = 0�� ��
								   //�ݹ�޼ҵ�� ȣ���� �ȵ�
		g.drawString("X : " + x + " \tY : " + y, x, y); //�ڿ� x,y�� ���� ��µǴ� ���� ����
		
	}

	
	//3.�������̵�
	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) { //ActionEvent e : EventObjectŬ����
		if(e.getActionCommand() == "   ����   ") {//Ÿ��Ʋ������ ��&ȣ��
		//if(e.getSource() == redBtn) {//��ü������ ��&ȣ��
			this.setBackground(new Color(255,0,0));
		}else if(e.getSource() == greenBtn) {
			this.setBackground(new Color(0,255,0));
		}else if(e.getSource() == blueBtn) {
			this.setBackground(new Color(0,0,255));
		}else if(e.getSource() == exitBtn) {
			System.exit(0);
		}
		
	}
	
	//MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("���콺 Ŭ��");
		this.x = e.getX();
		this.y = e.getY();
		System.out.println("X : " + x + "\tY : " + y);//�ܼ�â�� ����
	
		repaint(); //JVM�� ���ؼ� paint()�� ȣ���
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	
	//WindowListener
	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); //���α׷� ���� ����
	}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

	
	

}
