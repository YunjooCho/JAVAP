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


//틀린답임 ThreadOnOffT.java 참조할 것
public class ThreadOnOff extends Frame implements Runnable {

	private Label label;
	private Button pushBtn;
	private int num = 0;
	private Thread thread = new Thread(this);
	
	//6. 슷자멈추기
	private boolean stopCount = true;
	
	public ThreadOnOff() {
		
		//2.라벨 생성하기
		setLayout(null);
		label = new Label("0");
		label.setFont(new Font("고딕체", Font.BOLD, 70));
		label.setForeground(Color.BLUE);
		label.setBounds(50, 50, 100, 100);
		add(label);
		
		//3.버튼 생성하기
		pushBtn = new Button("누르기");
		pushBtn.setBounds(220, 150, 40, 20);
		add(pushBtn);
		
		
		//1.프레임생성
		setBounds(800, 250, 300, 200);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//5.이벤트
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
	

	
	//4. 동작 구현하기
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
//while문