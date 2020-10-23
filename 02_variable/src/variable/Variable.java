package variable;

public class Variable {

	public static void main(String[] args) {
		boolean a;
		a = true; //true = 1
		System.out.println("a = " + a);
		
		
		char b;
		b = 'A'; //char이므로 0000 0000 0100 0001 -> 65 = 'A'의 ASCII
		System.out.println("b = " + b);
		
		
		char c;
		c = 65;
		//c = 65535; -error char는 65535까지 표시가능(한글파일 참조)
		//char로 변수 선언을 했기 때문에 숫자가 아닌 문자로 출력
		//컴퓨터에서 65536이상(char가 받을 수 없는 값)은 
		//int(정수)로 인식하기 때문에
		//65536이상을 입력할 경우 mismatch(char/int) 메시지가 뜸
		System.out.println("c = " + c); //결과값 : 'A'
		
		//int d;(32bit, 4byte) 
		//d = 65; int이므로 0000 0000 0000 0000 0000 0000 0100 0001
		int d = 65;
		System.out.println("d = " + d); 
		
		int e = 'A';
		System.out.println("e = " + e); //결과값 : 65
		
		float f; //종이컵같이 값을 담는 틀이 있음, 실수는 기본 double
		f = 43.8f; //원래 값이 float형, 값 옆에 f는 대소문자 상관 없음
		//f = (float) 43.8; - 형변환
		System.out.println("f = " + f); 
	}

}

//25    int형 상수
//25L   long형 상수
//43.8  double형 상수
//43.8f float형 상수
