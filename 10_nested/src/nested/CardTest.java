package nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//CardLayout
public class CardTest {
	//1.필드 선언
	private Frame frame; //Frame클래스를 상속받지 않고 프레임 생성하기, BorderLayout
	private CardLayout card; //java에 존재하는 클래스 - 프레임 위에 카드와 같이 겹겹이 쌓인 레이아웃을 생성
	
	//2.생성자
	public CardTest() {
		//3.프레임 창 만들기
		frame = new Frame();
		card = new CardLayout();
		
		frame.setLayout(card); //메소드
							   //Layout바꾸기 BorderLayout -> CardLayout (Panel의 레이아웃(FlowLayout)을 GridLayout으로 바꾼 것처럼)
							   //Layout마다 메소드 사용법이 다름
		
		//Panel 6장
		Panel[] p = new Panel[6];
		Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN, Color.YELLOW};
		String[] title = {"빨강", "초록", "파랑", "보라", "하늘", "노랑"}; 
		//여기가 1층, 2층, 3층으로 이름이 붙어있었다면 아래  show메소드에서 해당 층 이름을 넣으면 출력됨
		
		for(int i = 0; i < p.length; i++) {
			p[i] = new Panel();
			p[i].setBackground(color[i]);
			
			frame.add(p[i], title[i]); //프레임에 카드와 카드의 이름을 올리기
			    					   //CardLayout이기 때문에 동서남북 지정이 없음
			//이벤트
			p[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					//card.show(frame, "보라"); //어디에 무엇을 보여줄지 설정
					card.next(frame); //다음 카드를 꺼내옴(어디에 보여줄 것인지 설정)
				}
			});	
		}
		
		
		

		frame.setBounds(600, 100, 300, 300);
		frame.setVisible(true);
		
		//5.이벤트
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	public static void main(String[] args) {
		//4.생성
		new CardTest();
	}

}
