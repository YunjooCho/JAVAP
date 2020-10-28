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
	
	//0.필드선언
	private Label label;
	private Button pushBtn;
	private int num = 0;
	
	private boolean stopCount = true;
	
	public ThreadOnOffTP() {
		
		//2.라벨 생성
		label = new Label("0", Label.CENTER);
		label.setFont(new Font("고딕체", Font.BOLD, 70));
		label.setForeground(Color.RED);
		add("Center",label);
		
		//3.버튼 생성
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
		pushBtn = new Button("누르기");
		p.add(pushBtn);
		add("South",p);
		
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
		
		//4.이벤트
		pushBtn.addMouseListener(new MouseAdapter() {
			Thread thread;
			@Override
			public void mousePressed(MouseEvent e) {
				thread = new Thread(ThreadOnOffTP.this);
				System.out.println("누르기 t = " + thread);
				thread.start();
				stopCount = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				thread = null;
				System.out.println("손떼기 t = " + thread);
				stopCount = false;
			}
		});
	}

	//5.동작 구현하기
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
