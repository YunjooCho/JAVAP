package _interface;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//1. 상속 및 임플리멘트
//Frame은 BorderLayout(동서남북)
public class WindowTest2 extends Frame implements ActionListener, MouseListener, WindowListener {
	private Button redBtn, greenBtn, blueBtn, exitBtn;
	private int x, y;
	public static void main(String[] args)  {
		new WindowTest2().init();
	}
	
	//2. 프레임 설정
	public void init() {
		redBtn = new Button("   빨강   ");
		greenBtn = new Button("   초록   ");
		blueBtn = new Button("   파랑   ");
		exitBtn = new Button("   종료   ");
		
		Panel p = new Panel(); //Panel은 FlowLayOut(순서배치 - 중앙을 중심으로 나란히 배치)
		p.setBackground(new Color(119,200,250));
		p.add(redBtn); //판넬에 객체 추가
		p.add(greenBtn);
		p.add(blueBtn);
		p.add(exitBtn);
		
		this.add("North",p); //프레임의 윗부분에 Panel이 잡힘. Panel 위에 버튼 3개가 잡힘
							 //글자수에 따라 버튼의 크기가 조절 가능
//		this.add("North", redBtn);
//		this.add("South", greenBtn);
//		this.add("Center", blueBtn);
		
		
		setBounds(900, 100, 300, 400);
		setVisible(true);
		
		//4.이벤트
		this.addWindowListener(this); 
		//this - Frame클래스(WindowTest2에게 상속), Frame창
		//addWindowListener() - 메소드명
		//()구현부를 누가 갖고 있는지
		//redBtn.addActionListener(arg0);
		redBtn.addActionListener(this);
		greenBtn.addActionListener(this);
		blueBtn.addActionListener(this);
		exitBtn.addActionListener(this);
		
		this.addMouseListener(this);
	}
	
	//5.프레임 안에 글씨 표기
	public void paint(Graphics g) {//Window클래스
								   //setVisible(true)가 실행되면 바로 여기로 오기때문에 둘다 0으로 나옴
								   //x = 0, y = 0이 됨
								   //콜백메소드라 호출이 안됨
		g.drawString("X : " + x + " \tY : " + y, x, y); //뒤에 x,y는 값이 출력되는 곳을 지정
		
	}

	
	//3.오버라이드
	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) { //ActionEvent e : EventObject클래스
		if(e.getActionCommand() == "   빨강   ") {//타이틀명으로 비교&호출
		//if(e.getSource() == redBtn) {//개체명으로 비교&호출
			this.setBackground(new Color(255,0,0));
		}else if(e.getSource() == greenBtn) {
			this.setBackground(new Color(0,255,0));
		}else if(e.getSource() == blueBtn) {
			this.setBackground(new Color(0,0,255));
		}else if(e.getSource() == exitBtn) {
			System.exit(0);
		}
		
	}
	
	//MouseListener
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭");
		this.x = e.getX();
		this.y = e.getY();
		System.out.println("X : " + x + "\tY : " + y);//콘솔창에 찍힘
	
		repaint(); //JVM에 의해서 paint()가 호출됨
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	
	//WindowListener
	@Override
	public void windowActivated(WindowEvent arg0) {}

	@Override
	public void windowClosed(WindowEvent arg0) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); //프로그램 강제 종료
	}

	@Override
	public void windowDeactivated(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowOpened(WindowEvent e) {}

	
	

}
