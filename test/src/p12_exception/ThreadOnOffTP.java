package p12_exception;

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


public class ThreadOnOffTP extends Frame implements Runnable{
	
	//0.�ʵ弱��
	private Label label;
	private Button pushBtn;
	private int num = 0;
	
	private boolean stopCount = true;
	
	public ThreadOnOffTP() {
		
		//2.�� ����
		label = new Label("0", Label.CENTER);
		label.setFont(new Font("���ü", Font.BOLD, 70));
		label.setForeground(Color.RED);
		add("Center",label);
		
		//3.��ư ����
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
		pushBtn = new Button("������");
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
				thread = new Thread(ThreadOnOffTP.this);
				System.out.println("������ t = " + thread);
				thread.start();
				stopCount = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				thread = null;
				System.out.println("�ն��� t = " + thread);
				stopCount = false;
			}
		});
	}

	//5.���� �����ϱ�
	@Override
	public void run() {
		while(true) {
			num++;
			label.setText(num + "");
			
			if(!stopCount) break;
			
			try {
				Thread.sleep(70);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ThreadOnOffTP();

	}

}
