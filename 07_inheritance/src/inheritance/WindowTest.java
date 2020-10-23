package inheritance;

import java.awt.Color;
import java.awt.Frame;//패키지 외우기
import java.awt.Graphics;


//1.상속
public class WindowTest extends Frame {
	
	//2.기본생성자
	public WindowTest() {
		//Frame 클래스의 생성자를 통해서 "내가 만든 윈도우"
		//Frame(String title)을 사용
		//seTitle("내가 만든 윈도우");랑 같은 기능
		//String title = "내가 만든 윈도우";
		//String title = new String("내가 만든 윈도우");
		//super(new String("내가 만든 윈도우");
		//4.
		super("내가 만든 윈도우");
		//메인 메소드의 생성 -> 부모 생성자 -> 자식생성자
		//오버라이딩 아님(자식에 똑같은 형태가 없음)
		//부모(Frame)클래스의 파라미터가 있는 생성자, 첫째줄에 입력
		//super();파라미터가 없는 생성자는 부르지 않음
		//this는 WindowTest의 나 이므로, 나한테 String title파라미터가 있는 생성자가 있을 때 사용가능
		
		//paint() - 윈도우 창 안에 그려주는 메소드(window클래스)
		
		//System.out - 콘솔창에 표시
		//System.out.println("도형"); 
		
		
		//윈도우 기본 바탕색 - 흰색, 기본 글씨색 - 검정
		//바탕색 바꾸기(static이기 때문에 new생성필요X), 클래스 영역 안이므로  this가 필요
		//this.setBackground(Color.PINK);
		
		//Color의 생성자를 호출해서 선택한 색으로 지정
		//Color c = new Color(251, 220, 225); - 메모리 생성하여 c에 주소값줌, 언제든지 다시 찾아갈 수 있음
		//this.setBackground(c);
		
		//4.
		this.setBackground(new Color(255, 220, 193));//배경색 설정, 메모리 생성하지 않았기 때문에 1회용
		setForeground(Color.YELLOW);//글자색 설정
		
		
		//3.창의 크기 잡기
		//setSize(300,400); //Window클래스에서 상속받음
		//setBounds(x의 위치, y의 위치, 너비, 높이)
		setBounds(700,100,300,400);//해상도랑 관련있음
		setVisible(true);

	}
	
	//3.
	public static void main(String[] args) {
		WindowTest aa = new WindowTest(); // Frame 생성자 -> WindowTest 생성자
	}
	
	//일정한 시점이 되면 JVM(또는 운영체제)에 의해서 호출되는 메소드 - Call Back메소드
	//java뿐만 아니라 안드로이드에도 있음
	//안드로이드에서는 JVM이 아닌 달빅머신에 의해 호출됨
	//main()도 콜백메소드 : RunAs때 호출
	//paint는 setVisible(true);때 딱 한번 호출됨
	//5.
	public void paint(Graphics g) {//구현, 윈도우 창 안에 글씨 표기, Window클래스의 오버라이드 
		g.drawString("도형", 100, 80);
		g.drawLine(70, 120, 200, 300);
		g.drawLine(200,120, 70, 300);
		g.drawRect(70, 130, 120, 100);
		g.drawOval(70, 130, 120, 100);
	}
}



//상속
//is~a
//WindowTest is a Frame 윈도우테스트는 프레임이다
//WindowTest가 Frame역할을 하겠다
//Frame 윈도우 창을 만들어주는 것(안드로이드에서도 사용)