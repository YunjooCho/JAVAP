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
		//1.프레임 생성
		//this.setFont(new Font("고딕", Font.BOLD, 24)); //PLAIN - 보통 글씨, BOLD - 굵게, ITALIC - 기울이기 | 각각 숫자를 갖고있음
		this.setFont(new Font("고딕", 1, 24)); //여기의 1(BOLD)이 무엇인지 알기 어려우므로 위의 형식을 더 선호
		this.setForeground(Color.RED); //this생략가능
		setBounds(700, 200, 300, 100);
		setVisible(true);
		
		//2.종료버튼 활성화
		this.addWindowListener(new WindowAdapter() { 
			//WindowAdapter - 추상클래스(추상메소드가 없음-반드시 오버라이드 안해도 됨), new생성 불가 -> 익명내부 클래스만 있어도 문제 없음
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		//종료버튼이 동작하는 시간변경 표시
		//6.스레드 생성
		Thread t  = new Thread(this); //나를 스레드로 생성해주세요
		//7.스레드 시작(스레드 실행 - run())
		t.start();
	}
	
	
	//5.오버라이드, 콜백 - start()실행시 자동 호출됨
	@Override
	public void run() {
		while(true) {
			repaint(); //이전것은 버리고 새로 그림
			try {
				Thread.sleep(1000); //처리속도가 빨라 글씨가 잘 안보임. 지금 명령으로 움직이는 시간이 그래도 찍힘
			} catch (InterruptedException e) {
			e.printStackTrace();
			} // 기본이 1000 = 1초
		}
	}
	
	
	//4.현재시간 출력
	//SimpleDateFormat HH시 mm분 ss초
 	public void paint(Graphics g) {//CallBack메소드
 		SimpleDateFormat sd = new SimpleDateFormat("HH시 mm분 ss초");
 		//while(true) {
 			Date date = new Date();
 			g.drawString(sd.format(date), 60, 65);
 		//}//종료버튼이 안먹힘
 	}
 	
 	
 	//3.생성
	public static void main(String[] args) {
		new Clock();
		

	}

}

//Component(도구)
//연필 / 볼펜
//Button, TextField, Panel

//Container(도구상자)
//필통
//Frame(최종컨테이너), Dialog(팝업창)
//모달 다이얼로그 - 해당 팝업창이 뜨면 다른 부분은 선택할 수 없음(다른 부분이 정지)
//모달리스 - 다른 부분도 움직임
