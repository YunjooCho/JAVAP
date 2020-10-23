package nested;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame - BorderLayout(��������)
public class RGBTest extends Frame  {//ActionAdapter ����, implements ActionListener ��� ����
	//2-1. ��ư �ۼ�
	private Button redBtn, greenBtn, blueBtn; //null��
	private DrCanvas can;
	
	//������
	public RGBTest() {
		//1.������ ����
		setBounds(400, 100, 300, 400);
		setVisible(true);
		
		//2-2. ��ư �ۼ�
		redBtn = new Button("����"); //�ʱ�ȭ
		greenBtn = new Button("�ʷ�");
		blueBtn = new Button("�Ķ�");
		can = new DrCanvas();
		
		Panel p = new Panel(); //Panel - FlowLayout(������ġ - �߾�) - ���ڼ���ŭ �ڸ�����
		//p.setLayout(new GridLayout(1,3)); //GridLayout(�࿭��ġ, �յ�迭) - �յ��� ũ��� 1�� 3ĭ���� ������
		p.setLayout(new GridLayout(1, 3, 5, 0));   //new GridLayout(��, ��, ���ο���, ���ο���)
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);
		
		//�̺�Ʈ
		//2-3.��ư ����
		//implements ActionListener ��� ���� -> �͸� Ŭ���� ���
		this.add("North",p); //�ǳ��� ������ ���� �߰�
		add("Center", can);
		redBtn.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.RED);
			}
		});
		greenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.GREEN);
			}
		});
		blueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.BLUE);
			}
		});	
		
		
		//6.�����ư ����(�͸�Ŭ����)
		this.addWindowListener(new WindowAdapter() { //WindowAdapter�� ����, �߻�޼ҵ尡 ����
			public void windowClosing(WindowEvent e) { //����ڰ� ����ϰ� ���� ���븸 �������̵�
				System.exit(0);
			}
		});
	}
	
	//Canvas - null(Layout(��������)�� ����)
	class DrCanvas extends Canvas{ //������ ���� ĵ������ ����
		public DrCanvas() {
			this.setBackground(new Color(255,255,0));	
		}
		
		@Override
		public void paint(Graphics g) { 
			//�����ӿ� ����Ʈ ��� ���� - ������ ���� ĵ������ �ֱ� ������ DrCanvas Ŭ���� �ȿ� �����ؾ� ������ ����
			g.drawString("����� ĵ����", 100, 100);
		}
	}
	
	
	//ActionPerformance �������̵� - implements ActionListener ������
	//2-4. ��ư ����
//	@Override
//	public void actionPerformed(ActionEvent e) { //������ ���� ĵ������ �����Ƿ�, ĵ������ ������ ����
//		if(e.getSource() == redBtn) {
//			can.setBackground(new Color(255, 0, 0));
//		}else if(e.getSource() == greenBtn) {
//			can.setBackground(new Color(0,255,0));
//		}else if(e.getSource() == blueBtn) {
//			can.setBackground(new Color(0,0,255));
//		}
//	}
	
	
	//5.����
	public static void main(String[] args) {
		new RGBTest();
		
	}
	
}


//CanvasŬ������ ���(�Ϲ�Ŭ����)
//API�� Canvas�� ����ؼ� ����ϵ��� ��õǾ� �ִ�.
//�׷��� ���� FrameŬ������ ��ӹް� �ֱ⶧���� ���߻�� �Ұ��ϹǷ� Canvas�� ����� �Ұ�
//�ذ���1. ����Ŭ���� ��� - �� Ŭ����(�ܺ�Ŭ������ ��)�� ����� �ٷ� ����ϴ� ���� ���� (�̹��� ����� ���)
//�ذ���2. ���� Ŭ������ �����Ͽ� CanvasŬ���� ��� - setter/getter �ۼ��� �ʿ� 
//               ���ذ���2�� �ǹ����� ���� ���

//�߻�޼ҵ带 ������ ���� ��� ����� 2���� ����� ����
//1.�߻�Ŭ����
//2.�������̽�
//Ŭ������ ���ϻ���̱� ������ �������̽��� ���� ����ϴ� ���� ��ȣ��(�������̽��� ���� ���(...�� �ƴ�����)�� �����ϱ� ������