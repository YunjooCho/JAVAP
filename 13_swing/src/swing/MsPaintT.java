package swing;

//ctrl + shift + f : 정렬
//alt + 위아래 : 선택한 부분이 움직임

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//그림판 틀만 만들어오기(카톡의 사진 참조)

//class DrCanvas extends Canvas{    //따로 클래스 잡음
//	public void paint(Graphics g) {
//		g.drawRect(10, 0, 560, 180);
//		
//		
//	}
//}


//프레임 구성(컴포넌트(도구들) 생성 및 배치)&이벤트 발생
//복습할때는 틀은 냅두고 이벤트 등만 지워서 실습해보기
public class MsPaintT extends JFrame implements ActionListener {

	//1.필드 선언
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private JButton draw;
	private DrCanvasT canvas;
	private String[] colorlist;
	private ArrayList<ShapeDTO> list;
	
	//private List<ShapeDTO> list = new ArrayList<ShapeDTO>(); - 부모로 접근해도 가능(이걸로 공부하는 것이 좋음)
	//Object ob = new String("사과"); - 상속의 다형성
	//스프링에서는 전부 거의 List를 많이 씀
	//스프링 부트는 프레임(?) 와쿠가 있어서 변경이 있으면 깨야함, 스프링이 대부분 많이 사용하고 있음
	


	public MsPaintT() {
		super("그림 그리기");
		//3.필드를 잡은 표시도구들 생성
		x1L = new JLabel("X1"); //역할 : 화면에 글자만 표시
		y1L = new JLabel("Y1");
		x2L = new JLabel("X2");
		y2L = new JLabel("Y2");
		z1L = new JLabel("Z1");
		z2L = new JLabel("Z2");
		x1T = new JTextField("0",4);//문자열("  ")이 아닌 숫자(4)를 입력해서 칸을 넓힐 수 있음, 기본값으로 "0"을 줌
		y1T = new JTextField("0",4);
		x2T = new JTextField("0",4);
		y2T = new JTextField("0",4);
		z1T = new JTextField("0",4);
		z2T = new JTextField("0",4);
		fill = new JCheckBox("채우기");
		
		JPanel p = new JPanel();
		p.add(x1L);
		p.add(x1T);
		p.add(y1L);
		p.add(y1T);
		p.add(x2L);
		p.add(x2T);
		p.add(y2L);
		p.add(y2T);
		p.add(z1L);
		p.add(z1T);
		p.add(z2L);
		p.add(z2T);
		p.add(fill);
		
		
		//4.아랫부분 생성
		JPanel p2 = new JPanel();
		line = new JRadioButton("선");
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형", true); //true : default값으로 실행시 사각형이 선택되어있음
		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("연필");
		
		ButtonGroup group = new ButtonGroup(); //라디오버튼 중 중복선택이 아닌 한번에 하나만 선택되게 하기 위해  group을 묶어줌
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		colorlist = new String[] {"빨강","초록","파랑","보라","하늘"};
		combo = new JComboBox<String>(colorlist);
		draw = new JButton("그리기");
		
		p2.add(line);
		p2.add(circle);
		p2.add(rect);
		p2.add(roundRect);
		p2.add(pen);
		p2.add(combo);
		p2.add(draw);
		
		canvas = new DrCanvasT(this); //DrCanvasT의 주소값을 알 수 있음(참조변수 canvas)
									  //this는 MsPaint를 가리킴
		
		
		//모든 컴포넌트는 contentPane에 붙여야 함
		Container c = this.getContentPane();	
		c.add("North",p);
		c.add("South",p2);
		c.add("Center",canvas);
		
		//이벤트
		draw.addActionListener(this);
		
		
		list = new ArrayList<ShapeDTO>();
		//mousePressed(~~) - x1, y1 좌표
		//mouseDragged(~~) - x2, y2 좌표	
		canvas.addMouseListener(new MouseAdapter() { //MouseListener 메소드 5개
													 //MouseAdapter는 추상클래스 - 익명내부 클래스로 활용
													 //MouseListener에는 드래그가 없다
			@Override
			public void mousePressed(MouseEvent e) { 
				x1T.setText(e.getX() + ""); //java에서 제공하는 메소드 - getX(), getY(), setText()(내가 만든거 아님)
				y1T.setText(e.getY() + "");
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
			    //마우스를 눌렀다가 드래그 안하면 그림이 안그려진다
				//근데 마우스에서 손을 떼면 list에 ShapeDTO가 들어간다
				//x2T와 y2T는 바뀌지 않음
				//단순 클릭만으로 어레이리스트에 추가 되는 것 방지
			 	if(x2T.getText().equals("0") && y2T.getText().equals("0")) return;
			 	
			 	//<선생님 풀이>
			 	//System.out.println(e.getX() + e.getY());
			 	//int x1 = Integer.parseInt(x1T.getText());
			 	//int y1 = Integer.parseInt(y1T.getText());
			 	//if(x1 == e.getX() && y1 == e.getY()) return;
			 	//x1T.Text는 프레스 한 지점의 좌표, e.getX는 드래그한 후 마우스가 가리키고 있는 좌표이므로
			 	//드래그(이동)했다면 두 좌표가 달라야한다.
			 	//드래그 하지 않았다면 두 좌표가 같다 그러므로 위의 if문을 적용하면 드래그 했는지 하지 않았는지 알 수 있다.
			 	
				//이미 저장되어 있는 값(그린 값)을 ShapeDTO객체에 넘겨줌
			 	//☆☆☆☆☆for문 필요 없음 -> for문을 입력할 경우 객체가 추가안됨 - 이유 : 아직 객체를 입력하지 않았는데 
			 	//     					   조건식에 i < list.size() (값 : 0)를 넣어서 작동하지 않음
				//그린 값은 기존의 메소드를 이용하여 받음
				ShapeDTO dto = new ShapeDTO();
				//좌표
				dto.setX1(Integer.parseInt(x1T.getText())); //x1T.getText()가 String타입이므로 int형으로 형변환
															//dto.setX1()는 int형
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));
				
				//채우기
				if(fill.isSelected()) dto.setFill(true);
				else dto.setFill(false);
				//dto.setFill(fill.isSelected());
				
				//도형
				if(line.isSelected()) dto.setShape(Figure.LINE);
				else if(circle.isSelected()) dto.setShape(Figure.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Figure.RECT);
				else if(roundRect.isSelected()) dto.setShape(Figure.ROUND_RECT);
				//펜은 dragg에 적용 : else if(pen.isSelected() == true) dto.setShape(Figure.PEN);
				
				//색
				dto.setColor(combo.getSelectedIndex());
				list.add(dto);
				System.out.println("list의 개수 : " + list.size());
			}
		});
		
		canvas.addMouseMotionListener(new MouseAdapter() {//MouseMotionListener도 MouseAdapter 사용할 수 있음
			@Override
			public void mouseDragged(MouseEvent e) {
				x2T.setText(e.getX() + "");
				y2T.setText(e.getY() + "");
				canvas.repaint(); //잔상이 보임 repaint() 실행 시 update()호출 -> update()가 paint()호출
				
				//☆☆☆☆☆펜 기능 - 펜은 마우스를 놓으면 끝나므로 release가 아닌 dragg에서 설정한다
				if(pen.isSelected()) {
					ShapeDTO dto = new ShapeDTO(); //그림을 보존한 객체와는 연필용의 또다른 객체 생성
					
					//좌표(release내용과 같음)
					dto.setX1(Integer.parseInt(x1T.getText())); 
					dto.setY1(Integer.parseInt(y1T.getText()));
					dto.setX2(Integer.parseInt(x2T.getText()));
					dto.setY2(Integer.parseInt(y2T.getText()));
					dto.setZ1(Integer.parseInt(z1T.getText()));
					dto.setZ2(Integer.parseInt(z2T.getText()));
					
					//채우기(release내용과 같음)
					if(fill.isSelected() == true) dto.setFill(true);
					else dto.setFill(false);
					
					//도형 - pen만 여기서 설정, 나머지 모양은 release에서 설정
					dto.setShape(Figure.PEN); 
					
					//색(release내용과 같음)
					dto.setColor(combo.getSelectedIndex());
					
					//생성한 객체를 어레이리스트에 추가
					list.add(dto);
					
					//x2, y2의 좌표값을 x1, y1으로 넘겨줌
					//끝나는 좌표값을 다시 시작좌표값으로 넘겨줌으로써 계속해서 그림이 그려지게 됨
					x1T.setText(x2T.getText()); 
					y1T.setText(y2T.getText());
					
				}//if
			}//mouseDragg
		});
		
		//can.setBackground(Color.WHITE);
		
		//2.프레임 생성
		setBounds(700,300,600,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public String[] getColorlist() {
		return colorlist;
	}



	public void setColorlist(String[] colorlist) {
		this.colorlist = colorlist;
	}

	

	public JTextField getX1T() {
		return x1T;
	}


	public JTextField getY1T() {
		return y1T;
	}


	public JTextField getX2T() {
		return x2T;
	}


	public JTextField getY2T() {
		return y2T;
	}


	public JTextField getZ1T() {
		return z1T;
	}


	public JTextField getZ2T() {
		return z2T;
	}


	public JCheckBox getFill() {
		return fill;
	}


	public JRadioButton getLine() {
		return line;
	}


	public JRadioButton getCircle() {
		return circle;
	}


	public JRadioButton getRect() {
		return rect;
	}


	public JRadioButton getRoundRect() {
		return roundRect;
	}


	public JRadioButton getPen() {
		return pen;
	}


	public JComboBox<String> getCombo() {
		return combo;
	}
	
	public ArrayList<ShapeDTO> getList(){
		return list;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == draw) {
			canvas.repaint();
		}
		
	}
	
	public static void main(String[] args) {
		new MsPaintT();
		
	}
	

}

//checkbox
//jcombobox
//센터에 그림그릴 공간 - Canvas

//1. JOptionPane.showMessageDialog(this, "사용중인 아이디 입니다");
//
//2. delete()
//
//3. 그리판 - 틀 만 작성하세요
//Project : 13_swing
//
//Class   : MsPaint.java
//
//private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
//private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
//private JCheckBox fill;
//private JRadioButton line, circle, rect, roundRect, pen;
//private JComboBox<String> combo;
//private JButton draw;
//private DrCanvas can;
//사이즈 고정 필요 X