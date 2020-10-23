package p02_variable;

public class Variable2P {
	
	int a; //필드(클래스 밑에 있음), 인스턴스 변수, 초기화 되어 있음(a = 0), 선언문
		   //함수 안의 변수와 다른 메모리를 가짐
	
	static int b; //필드(클래스 밑에 잡히는 변수는 전부 필드), 선언문
				  //클래스변수(static), 초기화 되어 있음(b = 0)

	int c;
	String d;//String함수, 초기값  = null
	
	int e = 5;
	
	int f;
	//f = 7; -error!(
	
	public Variable2P() {
		f = 7;
	}
	
	public static void main(String[] args) {
		int a = 10;//지역변수 - 메인메소드 안에 있는 변수
				   //지역변수는 쓰레기값을 갖고 있어 그대로 출력이 안되므로 초기화가 필요
				   //메소드가 끝나면 사라짐
		System.out.println("지역변수 a = " + a);
		System.out.println("필드 b = " + b);
		System.out.println("필드 b = " + Variable2P.b);
		System.out.println("필드 a = " + new Variable2P().a);
		System.out.println("필드 c = " + new Variable2P().c);
		System.out.println("필드 d = " + new Variable2P().d);

	}

}
