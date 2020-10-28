package nested;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame - BorderLayout(동서남북)
public class RGBTest extends Frame  {//ActionAdapter 없음, implements ActionListener 사용 안함
	//2-1. 버튼 작성
	private Button redBtn, greenBtn, blueBtn; //null값
	private DrCanvas can;
	
	//생성자
	public RGBTest() {
		//1.프레임 생성
		setBounds(400, 100, 300, 400);
		setVisible(true);
		
		//2-2. 버튼 작성
		redBtn = new Button("빨강"); //초기화
		greenBtn = new Button("초록");
		blueBtn = new Button("파랑");
		can = new DrCanvas();
		
		Panel p = new Panel(); //Panel - FlowLayout(순서배치 - 중앙) - 글자수만큼 자리잡음
		//p.setLayout(new GridLayout(1,3)); //GridLayout(행열배치, 균등배열) - 균등한 크기로 1줄 3칸으로 나누기
		p.setLayout(new GridLayout(1, 3, 5, 0));   //new GridLayout(행, 열, 가로여백, 세로여백)
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);
		
		//이벤트
		//2-3.버튼 생성
		//implements ActionListener 사용 안함 -> 익명 클래스 사용
		this.add("North",p); //판넬을 프레임 위에 추가
		add("Center", can);
		redBtn.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.RED);
			}
		});
		greenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.GREEN);
			}
		});
		blueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.BLUE);
			}
		});	
		
		
		//6.종료버튼 생성(익명클래스)
		this.addWindowListener(new WindowAdapter() { //WindowAdapter가 구현, 추상메소드가 없음
			public void windowClosing(WindowEvent e) { //사용자가 사용하고 싶은 내용만 오버라이드
				System.exit(0);
			}
		});
	}
	
	//Canvas - null(Layout(동서남북)이 없음)
	class DrCanvas extends Canvas{ //프레임 위에 캔버스를 생성
		public DrCanvas() {
			this.setBackground(new Color(255,255,0));	
		}
		
		@Override
		public void paint(Graphics g) { 
			//프레임에 페인트 기능 구현 - 프레임 위에 캔버스가 있기 때문에 DrCanvas 클래스 안에 구현해야 내용이 보임
			g.drawString("노란색 캔버스", 100, 100);
		}
	}
	
	
	//ActionPerformance 오버라이드 - implements ActionListener 사용안함
	//2-4. 버튼 생성
//	@Override
//	public void actionPerformed(ActionEvent e) { //프레임 위에 캔버스가 있으므로, 캔버스의 색상을 변경
//		if(e.getSource() == redBtn) {
//			can.setBackground(new Color(255, 0, 0));
//		}else if(e.getSource() == greenBtn) {
//			can.setBackground(new Color(0,255,0));
//		}else if(e.getSource() == blueBtn) {
//			can.setBackground(new Color(0,0,255));
//		}
//	}
	
	
	//5.생성
	public static void main(String[] args) {
		new RGBTest();
		
	}
	
}


//Canvas클래스를 사용(일반클래스)
//API에 Canvas는 상속해서 사용하도록 명시되어 있다.
//그러나 현재 Frame클래스를 상속받고 있기때문에 다중상속 불가하므로 Canvas의 상속이 불가
//해결방법1. 내부클래스 사용 - 본 클래스(외부클래스가 됨)의 멤버를 바로 사용하는 것이 가능 (이번에 사용한 방법)
//해결방법2. 새로 클래스를 생성하여 Canvas클래스 상속 - setter/getter 작성이 필요 
//               ★해결방법2가 실무에서 자주 사용

//추상메소드를 가져다 쓰는 경우 사용은 2가지 방법이 있음
//1.추상클래스
//2.인터페이스
//클래스는 단일상속이기 때문에 인터페이스를 통해 사용하는 것을 선호함(인터페이스는 다중 상속(...은 아니지만)이 가능하기 때문에
