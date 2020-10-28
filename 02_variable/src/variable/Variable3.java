package variable;

public class Variable3 {
	int a; //클래스 영역에 메모리
	static int b; //매니저 선생님
	
	public static void main(String[] args) {
		int a = 10; //지역변수, 기본형
					//함수 영역에 메모리
		  	   		//노란밑줄 - 초기화 필요
		System.out.println("지역변수 a = " + a);
		
		Variable3 v; //객체
		//아래 설명대로 heap영역에 이름을 정할 수 없으므로 주소로 들어감
		//주소보관(Variable3가 있는 곳을 가리킴)
		//데이터 상수 아님
		v = new Variable3();
		//클래스 생성 + 생성자 함수
		//heap영역에 생성
		//이름을 정할 수 없음
		//Variable3안의 모든 인스턴스 값, 클래스 값이 저장
		System.out.println("필드 a = " + v.a);
		v.a = 20;
		//'.' : ~안에(소속)
		System.out.println("필드 a = " + v.a);
		
		Variable3 v2; //객체
		v2 = new Variable3();
		//v가 나타내는 new Variable3();와는 다른 메모리 생성
		System.out.println("필드 a = " + v2.a);
		//다른 메모리 이므로 값이 20이 아닌 초기화값 0이 출력됨
		
		int sum = v.a + v2.a;
		System.out.println("합 = " + sum);
		
		System.out.println("필드 b = " + Variable3.b);
		System.out.println("필드 b = " + b);
		System.out.println("필드 b = " + v.b);
		//public class Variable3 영역 안이므로 그냥 사용 가능
	}

}

//main함수는 한 파일당 하나만 존재
//아래와 같은 경우가 있음

//파일명 : Test.java
//		 Test.class
//		 Sample.class

//class Test {
//		public static void main(String[] args) {
//  }
//}
//class Sample {
//}
