package _interface;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

//1.Frame클래스 상속
//3.인터페이스
public class WindowTest extends Frame 
	implements ActionListener, MouseListener, MouseMotionListener {
	//자바 클래스는 단일 상속
	//다른 클래스로부터 뭔가 받고 싶으면 interface
	
	//7-1.버튼 생성
	private Button exitBtn; //null값, 생성이 반드시 필요
	
	//2.메소드 작성
	public void init() {
		//7-2.
		exitBtn = new Button("종료");
		//배치
		this.add("North", exitBtn);
		
		
		//2-1. 프레임 설정
		setBounds(900, 100, 300, 400);
		setVisible(true);
		
		//8.이벤트
		this.addMouseListener(this);
		//(this) : 위치를 나타냄, this는 WindowTest클래스에서 생성한 프레임을 가리킴
		this.addMouseMotionListener(this);
		this.addWindowListener(new WindowExit());//다른 클래스 호출
		exitBtn.addActionListener(this); 
		//종료버튼을 누르면 JVM이 this(내 클래스)의
		//ActionListener의 actionPerformed로 찾아감->System.exit(0)을 만나 종료
	}

	//7-3.ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼으로 종료");
		System.exit(0);	
	}
	
	//4. MouseListener Overriding, CallBack메소드
	@Override
	public void mouseClicked(MouseEvent e) {//구현
		System.out.println("마우스 클릭");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스 IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("마우스 OUT");
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	
	//5. MouseMotionListener Overriding
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("마우스 드래그");
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	
	
	//9.호출
	public static void main(String[] args) {
		new WindowTest().init(); //생성 + 생성자 + 메소드 호출
	}

	
	
}
