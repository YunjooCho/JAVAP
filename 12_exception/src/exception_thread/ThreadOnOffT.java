package exception_thread;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ThreadOnOffT extends Frame implements Runnable {
	
		//0.�ʵ弱��
		//���۹�ư ������ ���ڼ��ٰ� �ն��� ���߱�
		private Label label; //���� ǥ�ÿ�
		private Button pushBtn; //���۹�ư
		private int num = 0; //�� ����
		//private Thread thread = new Thread(this); //�ٴٸ���
		
		//6. ���ڸ��߱�
		private boolean stopCount = true;
		
		public ThreadOnOffT() {
			
			//2.�� �����ϱ�
			//setLayout(null); //�ٴٸ���
			label = new Label("0", Label.CENTER);
			label.setFont(new Font("���ü", Font.BOLD, 70));
			label.setForeground(Color.BLUE);
			//label.setBounds(50, 50, 100, 100); //�ٴٸ���
			add("Center",label);
			
			//3.��ư �����ϱ�
			Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT)); //�ٴٸ���, ��ư�� ���������� ����
			pushBtn = new Button("������");
			//pushBtn.setBounds(220, 150, 40, 20); //�ٴٸ���
			p.add(pushBtn);
			add("South",p);
			
			
			//1.�����ӻ���
			setBounds(800, 250, 300, 200);
			setVisible(true);
			setResizable(false);
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			
			//4.�̺�Ʈ
			pushBtn.addMouseListener(new MouseAdapter() {
				Thread thread;
				@Override
				public void mousePressed(MouseEvent e) {
					//Thread thread = new Thread(ThreadOnOffT.this); //���⼭ this�� �͸�Ŭ������ ����Ŵ. �͸��� Runnable�� �� ���� �ִ�
																    //�׷��Ƿ� this�� ����� ��������� ��
					thread = new Thread(ThreadOnOffT.this);
					System.out.println("������ t = " + thread); //�ܼ�â�� ��µ�
//					������ t = Thread[Thread-2,6,main] - Thread-2 ������ �̸��� ��� ���� (Thread-1�� main)
//					������ t = Thread[Thread-3,6,main]
//					������ t = Thread[Thread-4,6,main]
//					������ t = Thread[Thread-5,6,main]
//					������ t = Thread[Thread-6,6,main]
//					������ t = Thread[Thread-7,6,main]
					thread.start(); //���� �� ���� ������ ����
					stopCount = true;
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					thread = null; //���⼭ �����带 �����ϰ� �ٽ� ������ ��ư�� ������ ���ο� ������ ����
					               //��� �����尡 ����ִ� ��� �޸𸮰� ��ũ���� ����
					System.out.println("�ն��� t = " + thread);
					stopCount = false;
				}
			});
			
		}
		

		
		//5. ���� �����ϱ�
		@Override
		public void run() {
			while(true) {
				num++;
				label.setText(num + ""); //setText�� ���ڰ� �ü� ���� ������ ""�� �־���
				
				if(!stopCount) break;
				
				try {
					Thread.sleep(70);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}

		public static void main(String[] args) {
			new ThreadOnOffT();

		}
	}
	 
	//MouseListner - MousePressed / MouseRelease -> MouseAdapter
	//while��


