package variable;

public class Variable2 {

	int a; //필드(클래스 밑에 있음), 인스턴스 변수, 초기화 되어 있음(a = 0), 선언문
		   //함수 안의 변수와 다른 메모리를 가짐
	static int b; //필드(클래스 밑에 잡히는 변수는 전부 필드), 선언문
				  //클래스 변수(static 밑에 있음), 초기화 되어 있음(b = 0)
	int c;
	String d; //String함수, 초기값 = null
	
	int e = 5;
	
	int f;
	//f = 7 -error(대입문과 같은 명령어는 생성자(메소드(함수)) 안에서 적용)
	
	//▶2020.9.30 내가 추가한 문장
	public Variable2() {
		f = 7;
	}
	
	
	public static void main(String[] args) {
		int a = 10; // 지역변수(Local variable) : 함수(main) 안에 있는 변수
					// 지역변수는 쓰레기 값을 갖고 있어, 그대로 출력 안되므로 초기화가 필요
					// 4byte의 공간, 함수가 끝나면 사라짐
		System.out.println("지역변수 a = " + a);
		System.out.println("필드 b = " + b); //b앞에 클래스명이 생략되어 있다
		System.out.println("필드 b = " + Variable2.b); //생략된 클래스명은 Variable2(static은 생성하지 않아도 사용가능)
		System.out.println("필드 a = " + new Variable2().a); //인스턴스 변수는 생성 뒤에 사용 가능
		System.out.println("필드 c = " + new Variable2().c); // 다른 Variable2 메모리가 생성
		System.out.println("필드 d = " + new Variable2().d); 
		//위의 new클래스들은 주소가 없음(1회용), 다시는 그 자리를 찾아갈 수 없음
	}

}


//static
//	-실행 시 메모리에 자동으로 생성
// 예)빵가게
// 주인이 새로만든 빵, 공짜 ->메모리에 생성안해도 자동으로 만들어짐

//필드 변수
//미리 만들어 놓은 음식 : static int b 클래스 변수
//요청에 의해 만들어진 음식 : int a 인스턴스 변수 -> new Variable2().a
//                     ※클래스는 무조건 메모리를 생성해야 함(new), 요청
//                     ※() : 생성자 함수, new를 쓰면 호출

//클래스도 변수