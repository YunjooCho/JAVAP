package p06_class;



public class StaticTestP {
	private int a;
	private static int b;
	
	public StaticTestP() {
		System.out.println("기본 생성자");
		a = 3; //this.a
		b = 5;
	}
	
	static {
		System.out.println("static 초기화 영역");
		//a = 10; - error : 인스턴스 변수는 생성자로 초기화
		b = 7;
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a=" + this.a + "\t b=" + StaticTestP.b); 
		//this.a의 this는 생략가능
		//StaticTest.b의 StaticTest는 생략가능
	}
	
	public static void output() { //인스턴스 변수도, super()도 사용할 수 없음
		//System.out.println("a=" + a + "\t b=" + StaticTest.b); 
		//- error : static메소드에는 static변수만 접근 가능
		System.out.println("static method...");
	}
	
	public static void main(String[] args) {
		StaticTestP st = new StaticTestP();
		//System.out.println("a=" + st.a + "\t b=" + b); 
		//disp()메소드에서는 a앞이 생략 가능하나 메인메소드 안에서는 그냥 a만 있으면 출력 안됨
		st.calc();
		st.disp();
		System.out.println();
		//결과값 : a=4	 b=6(b = 8이 아님)
	}

}
