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
	
		//0.필드선언
		//시작버튼 누르면 숫자세다가 손떼면 멈추기
		private Label label; //숫자 표시용
		private Button pushBtn; //시작버튼
		private int num = 0; //셀 숫자
		//private Thread thread = new Thread(this); //☆다른점
		
		//6. 슷자멈추기
		private boolean stopCount = true;
		
		public ThreadOnOffT() {
			
			//2.라벨 생성하기
			//setLayout(null); //☆다른점
			label = new Label("0", Label.CENTER);
			label.setFont(new Font("고딕체", Font.BOLD, 70));
			label.setForeground(Color.BLUE);
			//label.setBounds(50, 50, 100, 100); //☆다른점
			add("Center",label);
			
			//3.버튼 생성하기
			Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT)); //☆다른점, 버튼을 오른쪽으로 정렬
			pushBtn = new Button("누르기");
			//pushBtn.setBounds(220, 150, 40, 20); //☆다른점
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
					//Thread thread = new Thread(ThreadOnOffT.this); //여기서 this는 익명클래스를 가리킴. 익명은 Runnable을 안 갖고 있다
																    //그러므로 this를 제대로 가리켜줘야 함
					thread = new Thread(ThreadOnOffT.this);
					System.out.println("누르기 t = " + thread); //콘솔창에 출력됨
//					누르기 t = Thread[Thread-2,6,main] - Thread-2 스레드 이름이 계속 붙음 (Thread-1은 main)
//					누르기 t = Thread[Thread-3,6,main]
//					누르기 t = Thread[Thread-4,6,main]
//					누르기 t = Thread[Thread-5,6,main]
//					누르기 t = Thread[Thread-6,6,main]
//					누르기 t = Thread[Thread-7,6,main]
					thread.start(); //위의 두 줄을 생략한 형태
					stopCount = true;
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					thread = null; //여기서 스레드를 종료하고 다시 누르기 버튼이 눌리면 새로운 스레드 생성
					               //계속 스레드가 살아있는 경우 메모리가 펑크나기 쉬움
					System.out.println("손떼기 t = " + thread);
					stopCount = false;
				}
			});
			
		}
		

		
		//5. 동작 구현하기
		@Override
		public void run() {
			while(true) {
				num++;
				label.setText(num + ""); //setText에 글자가 올수 없기 때문에 ""를 넣어줌
				
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
	//while문


