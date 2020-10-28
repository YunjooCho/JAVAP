package p12_exception;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TimerP extends Frame implements ActionListener, Runnable{

	//1.필드 생성
	private Label label;
	private Button startBtn, stopBtn;
	
	//6.숫자세기 동작
	private boolean aa = true;
	
	public TimerP() {
		//3.라벨, 버튼 생성
		setLayout(null); //위치를 잡아 주어야 함
		label = new Label();
		label.setFont(new Font("고딕체", Font.BOLD, 70));
		label.setForeground(Color.RED);
		startBtn = new Button("시작");
		stopBtn = new Button("정지");
		
		
		label.setBounds(50, 50, 100, 100);
		startBtn.setBounds(200, 40, 60, 30);
		stopBtn.setBounds(200, 80, 60, 30);
		
		add(label);
		add(startBtn);
		add(stopBtn);
		

		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
		
		//2.프레임 생성
		setBounds(800, 300, 300, 200);
		setVisible(true);
		setResizable(false);
		setTitle("타이머");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//5.이벤트
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
	}
	

	//4.버든 클릭시 작동
	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t;
		if(e.getSource() == startBtn) {
			t = new Thread(this);
			t.start();
			
			aa = true;
			startBtn.setEnabled(false);
			stopBtn.setEnabled(true);
		}else if(e.getSource() == stopBtn) {
			t = null;
			
			aa = false;
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
			
		}
		
	}
	
	
	//7.run() 구현
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			label.setText(i + "");
			
			if(!aa)break;
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
	}
	public static void main(String[] args) {
		new TimerP();
	}

}
