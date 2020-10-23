package p02_variable;

public class Variable3P {
	int a; //인스턴스 변수
	static int b;//클래스 변수
	
	static {
		b = 100;
	}
	
	
	public static void main(String[] args) {
		int a = 10; //지역변수, 기본형
			        //함수 영역에 메모리
					//노란 밑줄 - 초기화 필요
		System.out.println("지역변수 = " + a);
		
		Variable3P v;//객체
		//힙 영역에 이름을 정할 수 없으므로 주소가 들어감
		//주소보관(Variable3P가 있는 곳을 가리킴
		v = new Variable3P();
		//클래스 생성(생성자 함수)
		//힙 영역에 생성, 이름을 정할 수 없음
		//Variable3P안의 모든 인스턴스 값, 클래스 값이 저장
		System.out.println("필드 a = " + v.a);
		v.a = 20;
		System.out.println("필드 a = " + v.a);
		
		Variable3P v2 = new Variable3P();
		System.out.println("필드 a = " + v2.a);
		
		int sum = v.a + v2.a;
		System.out.println("합 = " + sum);
		
		System.out.println("필드 b = " + Variable3P.b);
		System.out.println("필드 b = " + b);
		System.out.println("필드 b = " + v.b);

	}

}
