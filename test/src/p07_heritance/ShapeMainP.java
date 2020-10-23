package p07_heritance;


class ShapeTest{
		
		//필드 선언
		protected double area;
		
		//생성자
		public ShapeTest() {
			System.out.println("ShapeMainP 기본 생성자");
		}
		
		
		//메소드
		public void calcArea() {
			System.out.println("도형의 넓이을 계산합니다.");
		}
		
		public void dispArea() {
			System.out.println("도형의 넓이를 출력합니다.");
		}
}


class SamTest extends ShapeTest{//상속(필드와 메소드 사용가능)
	//자식클래스의 필드
	protected int base, height;
	
	//자식클래스의 생성자
	public SamTest(int base, int height) {
		System.out.println("SamTest 생성자");
		this.base = base; //매개변수(파라미터)로 받은 base의 값을 자식클래스 필드 base에 넘겨줌
		this.height = height; //매개변수(파라미터)로 받은 height의 값을 자식클래스 필드 height에 넘겨줌
	}
	
	//자식클래스의 메소드(오버라이드로 앞으로는 자식클래스의 메소드밖에 불러올수 없음)
	@Override 
	//어노테이션 - 오버라이드 전욕 에러 검출코드
	//어노테이션이 없으면 오버라이드가 되지 않아도 아예 다른 메소드로 인식하여 에러가 검출되지 않음
	public void calcArea() {
		
		area = base * height / 2.0; //부모필드에 값 반환
	}
	
	
	@Override
	public void dispArea() {
		System.out.println("삼각형 넓이 = " + area); //부모 필드 호출
	}
}//SamTest


class SaTest extends ShapeTest{
	//자식클래스의 필드
	private int width, height;
	
	//자식클래스의 생성자
	public SaTest(int width, int height) {
		
		System.out.println("SaTest 생성자");
		this.width = width;
		this.height = height;
		
	}
	
	//자식클래스의 메소드
	@Override
	public void calcArea() {
		
		area = width * height;
	}
	
	@Override
	public void dispArea() {
		
		System.out.println("사각형 넓이 = " + area);
		
	}
}//SaTest


class SadariTest extends ShapeTest{
	//자식클래스 필드
	private int top, bottom, height;
	
	//자식클래스 생성자
	public SadariTest(int top, int bottom, int height) {
		System.out.println("SadariTest 생성자");
		this.top = top;
		this.bottom = bottom;
		this.height = height;
	}
	
	//자식클래스 메소드
	@Override
	public void calcArea() {
		area = (top + bottom) * height / 2.0;
	}
	public void dispArea() {
		System.out.println("사다리꼴 넓이 = " + area);
	}
	
}


public class ShapeMainP {
	public static void main(String[] args) {
		ShapeTest shape;
		shape = new SamTest(5,7);
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		shape = new SaTest(7,9);
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		shape = new SadariTest(2,3,5);
		shape.calcArea();
		shape.dispArea();
		System.out.println();
	}
}
