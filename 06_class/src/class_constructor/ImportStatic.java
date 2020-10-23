package class_constructor;


import static java.lang.Math.*;//와일드 카드, all
//밑에 두 import선언을 축약함(Math클래스에 있는 모든 함수 사용가능)
//import static java.lang.Math.random;
//import static java.lang.Math.pow;
//Math.을 쓰지 않기 위해 import를 선언함
//어디있는 함수인지 알려줌
//import static 이 지정 예약어임
import static java.lang.String.format;
import static java.lang.System.out;
//out은 필드명, println()은 메소드명
//import static을 사용하면 메소드명 앞에 [클래스명.]이 생략가능하다.

public class ImportStatic {

	public static void main(String[] args) {
		out.println("난수 = " + random());//Math.random()은 static함수
		out.println("제곱승 = " + pow(2, 10));
		//pow만 쓰면 class ImportStatic클래스에서 해당 메소드를 찾으므로 에러가 발생
		//import static 선언
		//만약 다른 클래스가 있어 그 곳에 random()가 있으면 어느 것인지 구별 불가
		//그 때는 클래스명.메소드명()으로 표시
		out.println("소수 이하 2째자리 = " + format("%.2f", 123.456));
		//String.format -> format으로 줄이기
		

	}

}
