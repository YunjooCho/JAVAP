package nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//CardLayout
public class CardTest {
	//1.�ʵ� ����
	private Frame frame; //FrameŬ������ ��ӹ��� �ʰ� ������ �����ϱ�, BorderLayout
	private CardLayout card; //java�� �����ϴ� Ŭ���� - ������ ���� ī��� ���� ����� ���� ���̾ƿ��� ����
	
	//2.������
	public CardTest() {
		//3.������ â �����
		frame = new Frame();
		card = new CardLayout();
		
		frame.setLayout(card); //�޼ҵ�
							   //Layout�ٲٱ� BorderLayout -> CardLayout (Panel�� ���̾ƿ�(FlowLayout)�� GridLayout���� �ٲ� ��ó��)
							   //Layout���� �޼ҵ� ������ �ٸ�
		
		//Panel 6��
		Panel[] p = new Panel[6];
		Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN, Color.YELLOW};
		String[] title = {"����", "�ʷ�", "�Ķ�", "����", "�ϴ�", "���"}; 
		//���Ⱑ 1��, 2��, 3������ �̸��� �پ��־��ٸ� �Ʒ�  show�޼ҵ忡�� �ش� �� �̸��� ������ ��µ�
		
		for(int i = 0; i < p.length; i++) {
			p[i] = new Panel();
			p[i].setBackground(color[i]);
			
			frame.add(p[i], title[i]); //�����ӿ� ī��� ī���� �̸��� �ø���
			    					   //CardLayout�̱� ������ �������� ������ ����
			//�̺�Ʈ
			p[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//card.show(frame, "����"); //��� ������ �������� ����
					card.next(frame); //���� ī�带 ������(��� ������ ������ ����)
				}
			});	
		}
		
		
		

		frame.setBounds(600, 100, 300, 300);
		frame.setVisible(true);
		
		//5.�̺�Ʈ
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	public static void main(String[] args) {
		//4.����
		new CardTest();
	}

}
