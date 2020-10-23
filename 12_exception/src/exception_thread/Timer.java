package exception_thread;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Timer extends Frame implements ActionListener, Runnable { //ī�� ������, ���� ��� ����

	//2.�ʵ弱��
	private Label label;
	private Button startBtn, stopBtn;
	
	//7. ���� ���߱�
	private boolean aa = true;
	
	public Timer() {
		//3.��&��ư ����
		setLayout(null); //��ġ�� ��� �־�� ��
		label = new Label("0");
		label.setFont(new Font("���ü", Font.BOLD, 70));
		label.setForeground(Color.RED);
		startBtn = new Button("����");
		stopBtn = new Button("����");
		
		label.setBounds(50, 50, 100, 100);
		startBtn.setBounds(200, 40, 60, 30);
		stopBtn.setBounds(200, 80, 60, 30);
		
		add(label);
		add(startBtn);
		add(stopBtn);
		
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
		
		//1.������ �����
		setBounds(800, 300, 300, 200);
		setVisible(true);
		setResizable(false);
		setTitle("Ÿ�̸�");
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//5.�̺�Ʈ
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
	}
	
	//4. �������̽� ����, �������̵�
		@Override
		public void actionPerformed(ActionEvent e) {
			Thread t;
			if(e.getSource() == startBtn) {
				t = new Thread(this);  //Ŭ���� �ȿ� �����Ƿ� ���� ��ü�������� ���� this�� �Է�
				t.start(); //�����带 ����ؼ� ����, main�� ������ ������ ���� ��� �����ǰ� ����
				
				aa = true;
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
			}else if(e.getSource() == stopBtn) {
				t = null; //������ ����

				aa = false;
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
			}
			
		}
	

	//6.run() �����ϱ�
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			label.setText(i + "");
			
			if(!aa) break; //����Ʈ�� true(���� �߰�)�� ���� !�� �����ϸ� false�� �ǹǷ� �ؿ� try~catch(sleep)�� ����� 
			               //�ݴ�� ������ false�� �� ��� ���ǿ� �����Ƿ� ����������
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//�ٽ� ���۹�ư Ȱ��ȭ
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new Timer();

	}

}
