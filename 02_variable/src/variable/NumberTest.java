package variable;

public class NumberTest {

	public static void main(String[] args) {
		System.out.print("안녕하세요\n");
		System.out.println(25+36);
		System.out.println("25+36");
		System.out.println("25+36 = " + 25+36);
		System.out.println("25+36 = " + (25+36));
		System.out.println("25/36 = " + (25/36));
		System.out.println("25/36 = " + (25.0/36));
		System.out.printf("25/36 = %.2f\n", (25.0/36));
		System.out.printf("25/36 = %.1f\n", (25.0/36));
		System.out.printf("%d / %d = %.1f\n", 25, 36, (25.0/36));
		System.out.println("25/36 = " + String.format("%.2f", (25.0/36)));
		System.out.println();
		
		System.out.println('A' + 3);
		System.out.println('A' + 32);
		System.out.println((char)('A' + 32)); 
		//형변환(숫자 -> 문자), 클래스에서도 형변환이 일어남
		System.out.println();
		
		
		System.out.println(2+5);
		
		System.out.println('2'+'5'); //결과값 : 50 + 52 = 103
		System.out.println('2'- 48 + '5' - 48 ); //문자를 숫자로 변환, 7
		//System.out.println((char)'2'+'5');
		
		System.out.println("2"+"5"); 
		System.out.println(Integer.parseInt("2")+Integer.parseInt("5"));
		//문자열을 숫자 7로 변환, Integer 클래스
		
		System.out.println("25.3" + "45.6");
		System.out.println(Double.parseDouble("25.3") + Double.parseDouble("45.6")); 
		//문자열을 실수(정수X)로 변환, Double 클래스
		
	}

}

//숫자
//2, -5, 100

//문자열(JAVA)
//"car", "25" 
//->""사용, 연산 안됨
//->핸드폰 번호에 많이 사용
//※Python에서는 ''또는 ""을 사용

//문자열의 +는 결합(연산x)
//문자열과 숫자를 더하면 우선순위에 따라 결합의 의미로 받아들임
//연산을 하고 싶으면 숫자 주위에 괄호입력
//갖고 있는 값이 정수면 정수로 결과값이 산출
//한쪽이 실수일때 연산하는 다른 숫자를 실수로 변환 : 자동 캐스트

//printf()
//정수형 값을 원한다 : %d ※decimal
//실수형 값을 원한다 : %f
//문자 한 글자          : %c
//문자 열                 : %s
//%전체자리수.소수이하자리수f
//ex)25.3 -> %4.1f : 000.0 백의자리, 소숫점 1자리
//ex)%.2f : 전체자리는 상관x, 소숫점 자리 1까지만 출력
//소수 자리 수 지정시 반올림 됨

//※ASCII(외우기)
//'A' = 65;
//’A’ -> ‘a’ : ‘A’ + 32
//‘a’ -> ‘A’ : ‘a’ - 32
// 0  -> ‘0’ : 0 + 48
//‘0’ ->  0  : ‘0’ - 48

//※문자열을 숫자로 바꾸기
//“2” -> Integer.parseInt() -> 2

//자바가 제공하는 클래스는 jre에서 확인가능
//기본형은 보이지 않지만 String같은 객체는 눈으로 확인 가능
//C:\Program Files\Java\jre1.8.0_261\lib rt.jar(JAVA의 압축파일)

//Overload : 함수의 이름이 동일한 것이 두가지 존재 
//			  ex)String.fomat : String클래스의 format 메소드 