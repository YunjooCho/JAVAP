package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


//지우개 기능 만들어보기

public class DrCanvasT extends Canvas { //그림을 그릴 화면은 캔버스가 가지고 있어야함(캔버스가 프레임 위를 다 덮고있음)
										//메인을 가질 수 없음(독단으로 사용 불가) - JPanel도 마찬가지 ->프레임이 필요

	private MsPaintT mp;
	private ShapeDTO dto;
	private Image bufferImage;
	private Graphics bufferG; //paint()에 그리면 매개변수 g를 사용하면 되지만 update()에 그리므로 새로운 필드를 설정,
	                          //해당 필드로 그림을 그림
	
	
	
	public DrCanvasT(MsPaintT mp) {
		this.mp = mp; //MsPaintT로 부터 넘겨받은 객체의 참조변수(주소값)을 본 필드에 저장하기
		this.setBackground(new Color(200,200,255));
		
		//이벤트(keyListener) - esc키를 누르면 종료됨(Mspaint에는 안먹음)
		addKeyListener(new KeyAdapter() {
	         @Override
	         public void keyPressed(KeyEvent e) {

	            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	               System.exit(0);
	            }
	         }
	      });
	}
	
	@Override
		public void update(Graphics g) {//paint()호출  : paint()에 있던 내용을 update로 옮겨옴
		
		//Image bufferImage //이미지객체 위에서 그림을 그릴 예정
		//Graphics bufferG  //메소드 매개값(Graphics g)은 update()메소드 전용이므로 가져다 쓸 수 없음
		//버퍼화면의 크기와 캔버스의 크기는 같아야 함(갖다 붙여야 하기 때문)
		Dimension d = this.getSize(); //Dimension(클래스?) : 사각형의 정보를 쥐고 있음 - 캔버스의 크기만큼 버퍼를 만듦
		if(bufferG == null) {//만약 이 문장이 없으면 계속해서 Image객체를 생성하여 기존의 값은 사라짐
							 //잔상은 남음
			bufferImage = createImage(d.width,d.height);
			bufferG = bufferImage.getGraphics(); //여기에 그림을 그림
		}
		
		
		//지우기 - 잔상 없애기
		//현재 캔버스의 바탕색을 얻어오기
		Color c = this.getBackground(); //마지막 마우스 놓으면  위에 덮어버림
										//지울때는 그 위에 배경색과 같은 색으로 덮어버림
		bufferG.setColor(c);
		bufferG.fillRect(0, 0, d.width, d.height);
		
		
		
		
		int x1, y1, x2, y2, z1, z2;
		//작업 되돌리기
		//좌표(6개)및 선택옵션(채우기, 도형, 색깔)에 대한 정보를 가지고 있어야 함 - 클래스로 잡아줌(ShapeDTO)->어레이리스트에 보관
		//어레이리스트 안의 도형을 하나씩 꺼내서 다시 그려준다(복원)
		
		//<선생님 풀이>
		for(ShapeDTO dto : mp.getList()) {
			//DTO의 좌표를 꺼내옴
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();
			
			//DTO의 색
			switch(dto.getColor()) {//index값 가져오기, getSelectedItem -> 저장된 문자열을 가져옴
			case 0 : bufferG.setColor(new Color(255,0,0)); //this - 캔버스
					 break;
			case 1 : bufferG.setColor(new Color(0,255,0));
					 break;
			case 2 : bufferG.setColor(new Color(0, 0, 255));
					 break;
			case 3 : bufferG.setColor(new Color(255, 0, 255));
					 break;
			case 4 : bufferG.setColor(new Color(0, 255, 255));
					 break;
			
			}
			
			if(dto.isFill()) {
				if(dto.getShape() == Figure.LINE) {
					bufferG.drawLine(x1, y1, x2, y2);
					//Math.min(x1,x2), Math.min(y1, y2)로 입력
				}else if(dto.getShape() == Figure.CIRCLE) {
					bufferG.fillOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(dto.getShape() == Figure.RECT) {
					bufferG.fillRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(dto.getShape() == Figure.ROUND_RECT) {
					bufferG.fillRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); //꼭지점의 둥근 부분이 얼마나 들어갈지 - 50으로 고정된 값을 넣어줌(임의)
				}else if(dto.getShape() == Figure.PEN) {
					bufferG.drawLine(x1, y1, x2, y2);
				}
			}else {
				if(dto.getShape() == Figure.LINE) {
					bufferG.drawLine(x1, y1, x2, y2);
				}else if(dto.getShape() == Figure.CIRCLE) {
					bufferG.drawOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1)); //여기서 x2-x1, y2-y1으로 표기하고 있기 때문에 다른 방향에서 그리면 표기가 안됨
				}else if(dto.getShape() == Figure.RECT) {
					bufferG.drawRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(dto.getShape() == Figure.ROUND_RECT) {
					bufferG.drawRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
				}else if(dto.getShape() == Figure.PEN) {
					bufferG.drawLine(x1, y1, x2, y2);
				}
			}
			
					
		}//for
		
		
		
		//새로운 그림
		//MsPaintT mp = new MsPaintT(); - 새로 또 다른 객체가 생성되므로 하면 안됨
		//좌표 얻어옴(TextField에 저장된 값을 얻어옴)
			x1 = Integer.parseInt(mp.getX1T().getText().trim()); //trim() - 앞뒤 공백을 없앰
			y1 = Integer.parseInt(mp.getY1T().getText().trim());
			x2 = Integer.parseInt(mp.getX2T().getText().trim());
			y2 = Integer.parseInt(mp.getY2T().getText().trim());
			z1 = Integer.parseInt(mp.getZ1T().getText().trim());
			z2 = Integer.parseInt(mp.getZ2T().getText().trim());
			
			
			//색
			switch(mp.getCombo().getSelectedIndex()) {//index값 가져오기, getSelectedItem -> 저장된 문자열을 가져옴
				case 0 : bufferG.setColor(new Color(255,0,0));
						 break;
				case 1 : bufferG.setColor(new Color(0,255,0));
						 break;
				case 2 : bufferG.setColor(new Color(0, 0, 255));
						 break;
				case 3 : bufferG.setColor(new Color(255, 0, 255));
						 break;
				case 4 : bufferG.setColor(new Color(0, 255, 255));
						 break;
				
			}
			
			//도형 
			if(mp.getFill().isSelected()) { //색이 채워진 도형 
													//isSelected : 사용자가 선택했는지 안했는지를 알려줌, 선택한 경우 true를 반환
				 									//==true생략해도 됨
				if(mp.getLine().isSelected()) {
					bufferG.drawLine(x1, y1, x2, y2);
					//Math.min(x1,x2), Math.min(y1, y2)로 입력  x1 < x2 ? x1 : x2   y1 < y2 ? y1 : y2
				}else if(mp.getCircle().isSelected()) {
					bufferG.fillOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(mp.getRect().isSelected()) {
					bufferG.fillRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(mp.getRoundRect().isSelected()) {
					bufferG.fillRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); //꼭지점의 둥근 부분이 얼마나 들어갈지 - 50으로 고정된 값을 넣어줌(임의)
				}
				
			}else {
				if(mp.getLine().isSelected()) {
					bufferG.drawLine(x1, y1, x2, y2);
				}else if(mp.getCircle().isSelected()) {
					bufferG.drawOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1)); //여기서 x2-x1, y2-y1으로 표기하고 있기 때문에 다른 방향에서 그리면 표기가 안됨
				}else if(mp.getRect().isSelected()) {
					bufferG.drawRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
				}else if(mp.getRoundRect().isSelected()) {
					bufferG.drawRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
				}
				
			}
			
			paint(g); //paint()메소드 호출
		}//update()
	
	
	@Override
	public void paint(Graphics g) { //실행하면 setVisible이 자동으로 paint메소드를 부름, 아직 초기화 되지 않은 상태이기 때문에 아래와 같은 에러가 뜸
								    //Exception in thread "AWT-EventQueue-0" java.lang.NumberFormatException: For input string: ""
									//대안 : Mspaint에서 생성시에 초깃값을 줌
		g.drawImage(bufferImage, 0, 0, this); //bufferImage를 뜯어서 this에 붙이기(스티커 같은 느낌), 좌표 0,0을 기준으로 초점을 맞춰서 붙이기
		
	}

	

	
	
}

//x1 = ???; //login과 loginresult를 참조

//1.x1T에 들어온 값을 꺼낸다
//2.문자열로 가져온 "100"을 정수형으로 변환


//PEN
//선은 x1,y1이 고정(x2,y2가 움직임)
//연필은 x2,y2가 다시 x1,y1이 됨(x1,y1도 바뀜) temp?


//캔버스와 같은 크기의 버퍼를 잡음(그림을 버퍼에 그림), 그걸 화면에 다시 옮김 - 연필로 그릴때 깜빡거림이 없어짐(화면에 딱 한번 보임)
//좌표지정 등 전부 버퍼에서 지정함(더블버퍼)
//콜백메소드임 - repaint()할때 불림
//update() - paint()순으로 호출


//		for(int i = 0; i < mp.getList().size(); i++){
//		
//			//int x1, y1, x2, y2, z1, z2;
//			
//			x1 = mp.getList().get(i).getX1();
//			y1 = mp.getList().get(i).getY1();
//			x2 = mp.getList().get(i).getX2();
//			y2 = mp.getList().get(i).getY2();
//			z1 = mp.getList().get(i).getZ1();
//			z2 = mp.getList().get(i).getZ2();
//			
//			switch(mp.getList().get(i).getColor()) {//index값 가져오기, getSelectedItem -> 저장된 문자열을 가져옴
//			case 0 : bufferG.setColor(new Color(255,0,0));
//					 break;
//			case 1 : bufferG.setColor(new Color(0,255,0));
//					 break;
//			case 2 : bufferG.setColor(new Color(0, 0, 255));
//					 break;
//			case 3 : bufferG.setColor(new Color(255, 0, 255));
//					 break;
//			case 4 : bufferG.setColor(new Color(0, 255, 255));
//					 break;
//			
//		}
//			if(mp.getList().get(i).isFill()) {
//				if(mp.getList().get(i).getShape() == Figure.LINE) {
//					bufferG.drawLine(x1, y1, x2, y2);
//					//Math.min(x1,x2), Math.min(y1, y2)로 입력
//				}else if(mp.getList().get(i).getShape() == Figure.CIRCLE) {
//					bufferG.fillOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
//				}else if(mp.getList().get(i).getShape() == Figure.RECT) {
//					bufferG.fillRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
//				}else if(mp.getList().get(i).getShape() == Figure.ROUND_RECT) {
//					bufferG.fillRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2); //꼭지점의 둥근 부분이 얼마나 들어갈지 - 50으로 고정된 값을 넣어줌(임의)
//				}else if(mp.getList().get(i).getShape() == Figure.PEN) {
//					bufferG.drawLine(x1, y1, x2, y2);
//				}
//			}else {
//				if(mp.getList().get(i).getShape() == Figure.LINE) {
//					bufferG.drawLine(x1, y1, x2, y2);
//				}else if(mp.getList().get(i).getShape() == Figure.CIRCLE) {
//					bufferG.drawOval(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1)); //여기서 x2-x1, y2-y1으로 표기하고 있기 때문에 다른 방향에서 그리면 표기가 안됨
//				}else if(mp.getList().get(i).getShape() == Figure.RECT) {
//					bufferG.drawRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1));
//				}else if(mp.getList().get(i).getShape() == Figure.ROUND_RECT) {
//					bufferG.drawRoundRect(x1 < x2 ? x1 : x2, y1 < y2 ? y1 : y2, Math.abs(x2 - x1), Math.abs(y2 - y1), z1, z2);
//				}else if(mp.getList().get(i).getShape() == Figure.PEN) {
//					bufferG.drawLine(x1, y1, x2, y2);
//				}
//			}
//			
//		}//for문