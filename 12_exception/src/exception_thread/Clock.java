package exception_thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends Frame implements Runnable {

	public Clock() {
		//1.������ ����
		//this.setFont(new Font("���", Font.BOLD, 24)); //PLAIN - ���� �۾�, BOLD - ����, ITALIC - ����̱� | ���� ���ڸ� ��������
		this.setFont(new Font("���", 1, 24)); //������ 1(BOLD)�� �������� �˱� �����Ƿ� ���� ������ �� ��ȣ
		this.setForeground(Color.RED); //this��������
		setBounds(700, 200, 300, 100);
		setVisible(true);
		
		//2.�����ư Ȱ��ȭ
		this.addWindowListener(new WindowAdapter() { 
			//WindowAdapter - �߻�Ŭ����(�߻�޼ҵ尡 ����-�ݵ�� �������̵� ���ص� ��), new���� �Ұ� -> �͸��� Ŭ������ �־ ���� ����
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		//�����ư�� �����ϴ� �ð����� ǥ��
		//6.������ ����
		Thread t  = new Thread(this); //���� ������� �������ּ���
		//7.������ ����(������ ���� - run())
		t.start();
	}
	
	
	//5.�������̵�, �ݹ� - start()����� �ڵ� ȣ���
	@Override
	public void run() {
		while(true) {
			repaint(); //�������� ������ ���� �׸�
			try {
				Thread.sleep(1000); //ó���ӵ��� ���� �۾��� �� �Ⱥ���. ���� ������� �����̴� �ð��� �׷��� ����
			} catch (InterruptedException e) {
			e.printStackTrace();
			} // �⺻�� 1000 = 1��
		}
	}
	
	
	//4.����ð� ���
	//SimpleDateFormat HH�� mm�� ss��
 	public void paint(Graphics g) {//CallBack�޼ҵ�
 		SimpleDateFormat sd = new SimpleDateFormat("HH�� mm�� ss��");
 		//while(true) {
 			Date date = new Date();
 			g.drawString(sd.format(date), 60, 65);
 		//}//�����ư�� �ȸ���
 	}
 	
 	
 	//3.����
	public static void main(String[] args) {
		new Clock();
		

	}

}

//Component(����)
//���� / ����
//Button, TextField, Panel

//Container(��������)
//����
//Frame(���������̳�), Dialog(�˾�â)
//��� ���̾�α� - �ش� �˾�â�� �߸� �ٸ� �κ��� ������ �� ����(�ٸ� �κ��� ����)
//��޸��� - �ٸ� �κе� ������