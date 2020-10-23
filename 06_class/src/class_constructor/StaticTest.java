package class_constructor;

public class StaticTest { //extends Object가 생략되어 있음
	private int a; //필드, 인스턴스 변수
	private static int b; //필드, 클래스 변수, 누적의 개념
	
	static {
		System.out.println("초기화 영역"); //static의 초기화
		b = 3;
	}
	
	public StaticTest() {
		System.out.println("기본 생성자");
		this.a = 3; 
		//초기화(static은 생성자에서 초기화 되지 않음), static은 이미 main메소드 생성시 만들어짐
		
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a=" + this.a + "\t b=" + StaticTest.b); 
		//this.a의 this는 생략가능
		//StaticTest.b의 StaticTest는 생략가능
	}
	
	public static void output() { //인스턴스 변수도, super()도 사용할 수 없음
		//System.out.println("a=" + a + "\t b=" + StaticTest.b); 
		//- error : static메소드에는 static변수만 접근 가능
		System.out.println("static method...");
	}
	
	public static void main(String[] args) {
		StaticTest st = new StaticTest();
		st.calc();
		st.disp();
		System.out.println();
		
		StaticTest st2 = new StaticTest();
		st2.calc();
		st2.disp();
		System.out.println();
		
		StaticTest st3 = new StaticTest();
		st3.calc();
		st3.disp();
		System.out.println();
		
		System.out.println("static 메소드 호출");
		StaticTest.output();//클래스명 생략 가능
		output();
		st.output();
		st2.output();
		st3.output();
	}
}//class StaticTest
