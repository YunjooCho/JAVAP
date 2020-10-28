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

public class Timer extends Frame implements ActionListener, Runnable { //카드 뒤집기, 오목 등에서 사용됨

	//2.필드선언
	private Label label;
	private Button startBtn, stopBtn;
	
	//7. 숫자 멈추기
	private boolean aa = true;
	
	public Timer() {
		//3.라벨&버튼 생성
		setLayout(null); //위치를 잡아 주어야 함
		label = new Label("0");
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
		
		//1.프레임 만들기
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
	
	//4. 인터페이스 구현, 오버라이딩
		@Override
		public void actionPerformed(ActionEvent e) {
			Thread t;
			if(e.getSource() == startBtn) {
				t = new Thread(this);  //클래스 안에 있으므로 따로 객체생성하지 말고 this를 입력
				t.start(); //스레드를 계속해서 생성, main이 끝날때 까지는 값이 계속 유지되고 있음
				
				aa = true;
				startBtn.setEnabled(false);
				stopBtn.setEnabled(true);
			}else if(e.getSource() == stopBtn) {
				t = null; //스레드 종료

				aa = false;
				startBtn.setEnabled(true);
				stopBtn.setEnabled(false);
			}
			
		}
	

	//6.run() 구현하기
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			label.setText(i + "");
			
			if(!aa) break; //디폴트가 true(숫자 추가)에 대해 !를 적용하면 false가 되므로 밑에 try~catch(sleep)이 실행됨 
			               //반대로 위에서 false가 된 경우 조건에 맞으므로 빠져나가짐
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//다시 시작버튼 활성화
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new Timer();

	}

}
