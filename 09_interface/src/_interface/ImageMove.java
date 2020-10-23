package _interface;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ImageMove extends Frame implements ActionListener, KeyListener, WindowListener{
	//2-1.버튼만들기
	private Button returnBtn, leftBtn, upBtn, downBtn, rightBtn;
	private int x = 100, y = 100;
	
	public void init() {
		
		//2-2.버튼 만들기
		returnBtn = new Button("초기화");
		leftBtn = new Button("왼쪽");
		upBtn = new Button("윗쪽");
		downBtn = new Button("아랫쪽");
		rightBtn = new Button("오른쪽");
		
		Panel p = new Panel();
		p.add(returnBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);
		
		this.add("North", p); //this생략 가능, 판넬을 프레임에 추가(추가할 위치, 판넬객체)
		
		returnBtn.setFocusable(false); //포커스 없애는 메소드
		                               //키보드로 입력하는데 있어서 버튼에 포커스가 맞춰져있으면 키보드로 움직이지 못하기 때문에
		leftBtn.setFocusable(false);
		upBtn.setFocusable(false);
		downBtn.setFocusable(false);
		rightBtn.setFocusable(false);
		
		//1.프레임 설정
		setBounds(300, 100, 500, 500);
		setVisible(true);
		setResizable(false); //창크기 변경 불가
				
		
		//이벤트 (2-3.버튼용)
		returnBtn.addActionListener(this);//해당 모션 실행할 위치.이벤트명(구현부가 작성된 위치)
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		this.addWindowListener(this);
		
		this.addKeyListener(this);

	}
	
	public void paint(Graphics g) {//paint메소드는 과부화가 옴(지웠다가 다시 그림)
		//이미지 불러오기 - Toolkit클래스(추상클래스) - 자식클래스가 없으므로 메소드로 생성
		Image img = Toolkit.getDefaultToolkit().getImage("puppy.jpg");
		//Toolkit t = Toolkit.getDefaultToolkit();
		//Image img = t.getImage("puppy.jpg");
		
		
		//이미지 그리기
		g.drawImage(img, x, y, this);//this부분 : 어디에 그림을 그릴지 표기
	}
	

	//ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("x : " + x + " y : " + y);
		if(e.getSource() == returnBtn) { //returnBtn이 눌렸는가
			this.x = 100;
			this.y = 100;
		}else if(e.getSource() == leftBtn) {
			this.x = x -= 10;
			if(x == -130) {
				this.x = 490;
			}
		}else if(e.getSource() == upBtn) {
			this.y = y -= 10;
			if(y == -90) {
				this.y = 480;
			}
		}else if(e.getSource() == downBtn) {
			this.y = y += 10;
			if(y == 500) { //★수치 수정하기
				this.y = 0;
			}
		}else if(e.getSource() == rightBtn) {
			this.x = x += 10;
			if(x == 500) { //★수치 수정하기
				this.x = 0;
			}
		}
		repaint(); //위의 내용(변경사항)에 맞추어 매번 새로 그림
	}
	
	
	//WindowListener
	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowClosed(WindowEvent e) {}

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

	
	//KeyListener
	//키보드 액션(예:if(키보드 == KeyEvent.VK_ESCAPE / int esc -> 27 : 숫자를 외울수 없기에 변수를 상수화)
	@Override
	public void keyPressed(KeyEvent k) {
		//if(k.getKeyCode() == 27)
		if(k.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}else if(k.getKeyCode() == KeyEvent.VK_LEFT) {
			this.x -= 10;
			if(x < -130) {
				this.x = 490;
			}
			repaint();
		}else if(k.getKeyCode() == KeyEvent.VK_UP) {
			this.y -= 10;
			if(y < -90) {
				this.y = 480;
			}
			repaint();
		}else if(k.getKeyCode() == KeyEvent.VK_DOWN) { 
			this.y += 10;
			if(y > 500) { //★수치 수정하기
				this.y = 0;
			}
			repaint();
		}else if(k.getKeyCode() == KeyEvent.VK_RIGHT) {
			this.x += 10;
			if(x > 500) { //★수치 수정하기
				this.x = 0;
			}
			repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent k) {}

	@Override
	public void keyTyped(KeyEvent k) {}

	
	//main메소드
		public static void main(String[] args) {
			new ImageMove().init();
		}

}


//1. Frame 창 띄우기 (o)
//2. North 방향에 버튼 5개 만들기(o)
//3. Frame(창)에 100, 100의 위치에 이미지 그리기(o)
//4. 이벤트 - 반대쪽에서 다시 다타나는게 잘 샐행 안됨 -> 해결함

//interface
//1.implements(모든 추상메소드 Override) - ArrayList(Collection인터페이스 오버라이드)

//클래스 생성
//1.new
//2.메소드