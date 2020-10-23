package abstractMethod;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class WindowTest extends Frame{
	
	public WindowTest() {
		//1.프레임 만들기
		setTitle("이미지"); //Frame의 메소드
		//super 이 부분 왜 super만으로 가능한지 확인 : 부모클래스인 Frame의 파라미터 있는 생성자 - Frame(String title)
		setBounds(900, 100, 500, 500);//창의 크기(전체화면에서의 x값, y값, 창자체의 너비, 창자체의 높이)
		setVisible(true);//callback
	}
	
	public void paint(Graphics g) {//Window클래스의 메소드 오버라이드
		//Toolkit t = Toolkit.getDefaultToolkit(); : 추상메소드라서 new생성이 안됨 
		//(Calendar cal = cal.getInstance()와 유사)
		//Image img = t.getImage("taji.jpg"); //이미지 불러오기
		//위의 코딩 두줄을 합친 것
		Image img = Toolkit.getDefaultToolkit().getImage("taji.jpg");
		
		//이미지 그리기 - Window 클래스의 paint() : 프레임 안에 그림을 그릴 수 있음
		//g.drawImage(img, 100, 100, this);
		//1.누가 이미지를 갖고 있는지
		//2.프레임의 위치
		//3.어디에 그릴 것 인지
		
		//이미지 작게
		/*
		g.drawImage(img,
		  50, 50, 400, 400, //화면 크기 ★★★★★무엇을 가리키는 건지 정리
		  0, 0, 320, 320, //이미지 크기  ★★★★★무엇을 가리키는 건지 정리
		  this);//this 어디에 이미지가 올려질 것인지 정의(클래스 단위)
		drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer)
		Draws as much of the specified area of the specified image as is currently 
		available, scaling it on the fly to fit inside the specified area of 
		the destination drawable surface.
		Parameters:
		img - the specified image to be drawn. This method does nothing if img is null.
		dx1 - the x coordinate of the first corner of the destination rectangle.
			왼쪽 공백 조절(클수록 왼쪽 공백 커짐)
		dy1 - the y coordinate of the first corner of the destination rectangle.
			윗쪽 공백 조절(클수록 윗쪽 공백 커짐)
		dx2 - the x coordinate of the second corner of the destination rectangle.
			오른쪽 공백 조절(작을수록 오른쪽 공백 커짐)
		dy2 - the y coordinate of the second corner of the destination rectangle.
			아랫쪽 공백 조절(작을수록 아랫쪽 공백 커짐)
		sx1 - the x coordinate of the first corner of the source rectangle.
			
		sy1 - the y coordinate of the first corner of the source rectangle.
			
		sx2 - the x coordinate of the second corner of the source rectangle.
			사진 너비 조절(작을수록 사진의 너비가 커짐)
		sy2 - the y coordinate of the second corner of the source rectangle.
			사진 높이 조절(작을수록 높이가 커짐)
		observer - object to be notified as more of the image is scaled and converted.
			어디에서 구현되어 있는지
		*/
		
		//거꾸로
		g.drawImage(img,
				  50, 50, 400, 400, //화면 크기★★★★★무엇을 가리키는 건지 정리
				  320, 320, 0, 0, //이미지 크기★★★★★무엇을 가리키는 건지 정리(왼쪽 위 위치, 오른쪽 아래 위치)
				  this);
	}
	
	public static void main(String[] args) {
		
		//2. 프레임 생성
		new WindowTest(); //리모콘이 없으나 주소를 가지고 있음(번호표가 있어 객체명이 없어도 사용가능)
	}
}

//Toolkit클래스 - 추상클래스 newToolkit() X
//Toolkit클래스의 생성방법
//1.자식 - Sub class가 없음(API)
//2.메소드 - getDefaultToolkit() 주소값을 넘겨줌
