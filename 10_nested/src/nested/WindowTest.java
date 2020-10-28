package nested;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowTest extends Frame {
	//메인메소드
	public static void main(String[] args) {
		new WindowTest();
	}
	
	//생성자
	public WindowTest() {
		setBounds(100, 100, 300, 400);
		setVisible(true);
		
		//이벤트
		this.addWindowListener(new WindowAdapter() { //WindowAdapter는 API에서 찾았음
													 //WindowAdapter는 추상클래스, 원래는 new안됨
													 
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//WindowListener인터페이스를 사욯하는 경우,
		//WindowListener가 가지고 있는 모든 메소드를 Override해야 함
		//익명 클래스를 사용하는 경우 필요한 메소드만 가져다 사용할 수 있음
		
		this.addMouseListener(new MouseAdapter() { //MouseAdapter는 추상클래스, 원래는 new안됨
												   //MouseAdapter의 5개의 추상메소드 Override - 빈 body
												   //나머지 2개만 빈 body가 아닌 오버라이드 실행
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("마우스IN");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("마우스OUT");
			}
		});
	}

}
