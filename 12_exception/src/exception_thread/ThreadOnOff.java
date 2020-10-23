package exception_thread;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//Ʋ������ ThreadOnOffT.java ������ ��
public class ThreadOnOff extends Frame implements Runnable {

	private Label label;
	private Button pushBtn;
	private int num = 0;
	private Thread thread = new Thread(this);
	
	//6. ���ڸ��߱�
	private boolean stopCount = true;
	
	public ThreadOnOff() {
		
		//2.�� �����ϱ�
		setLayout(null);
		label = new Label("0");
		label.setFont(new Font("���ü", Font.BOLD, 70));
		label.setForeground(Color.BLUE);
		label.setBounds(50, 50, 100, 100);
		add(label);
		
		//3.��ư �����ϱ�
		pushBtn = new Button("������");
		pushBtn.setBounds(220, 150, 40, 20);
		add(pushBtn);
		
		
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
		
		//5.�̺�Ʈ
		pushBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				thread.start();
				stopCount = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				thread = null;
				stopCount = false;
			}
		});
		
	}
	

	
	//4. ���� �����ϱ�
	@Override
	public void run() {
		while(true) {
			num++;
			label.setText(num + "");
			
			if(!stopCount) break;
			
			try {
				thread.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		new ThreadOnOff();

	}
}
 
//MouseListner - MousePressed / MouseRelease -> MouseAdapter
//while��