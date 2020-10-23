package inheritance;

class ShapeTest{
	protected double area;
	public ShapeTest() {
		System.out.println("ShapeTest 기본 생성자");
	}
	
	public void calcArea() {
		System.out.println("도형을 계산합니다");
	}
	
	public void dispArea() {
		System.out.println("도형을 출력합니다");
	}
}

class SamTest extends ShapeTest{
	protected double base, height;
	
	public SamTest(double base, double height) {
		System.out.println("SamTest 생성자");
		this.base = base;
		this.height = height;
	}
	
	@Override//어노테이션 - 오버라이드 하고자 하는 메소드에 메소드명이 달라도 에러가 검출되지 않음(다른 메소드로 인식)
	//때문에 어노테이션을 쓰면 오버라이드가 됐는지 체크하여 되지 않았으면 에러가 검출됨
	public void calcArea() {
		area = base * height / 2.0;
	}
	
	@Override
	public void dispArea() {
		System.out.println("삼각형 넓이 = " + area);//부모클래스 필드를 가져옴
	}
}



class SaTest extends ShapeTest{
	protected double width, height;
	
	public SaTest(double width, double height) {
		System.out.println("SaTest 생성자");
		this.width = width;
		this.height = height;
	}
	
	@Override
	public void calcArea() {
		area = width * height;
	}
	
	@Override
	public void dispArea() {
		System.out.println("사각형 넓이 = " + area);
	}
	
}



class SadariTest extends ShapeTest{
	protected double top, bottom, height;
	
	public SadariTest(double top, double bottom, double height) {
		System.out.println("SadariTest 생성자");
		this.top = top;
		this.bottom = bottom;
		this.height =  height;
	}
	
	@Override
	public void calcArea() {
		area = (top + bottom) * height / 2;
	}
	
	@Override
	public void dispArea() {
		System.out.println("사다리꼴 넓이 = " + area);
	}
}


public class ShapeMain {
	public static void main(String[] args) {
		/*
		//클래스 생성
		SamTest sam = new SamTest(5,7); 
		sam.calcArea();//자식클래스 메소드가 출력(부모는 절대 출력안됨)
		sam.dispArea();//자식클래스 메소드가 출력(부모는 절대 출력안됨)
		System.out.println();
		
		SaTest sa = new SaTest(7,9);
		sa.calcArea();
		sa.dispArea();
		System.out.println();
		
		SadariTest sadari = new SadariTest(2,3,5);
		sadari.calcArea();
		sadari.dispArea();
		System.out.println();
		*/
		
		//다형성 -> 부모 = 자식, 결합도가 느슨해진다
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
		
		//각각의 개체에 덮어씌어짐
	}
}
