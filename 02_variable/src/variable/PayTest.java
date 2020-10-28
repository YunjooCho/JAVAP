package variable;

/*
  이름이 L(name)인 사람의 기본급(basePay)이 2500000일 때
 3.3% 세금(tax, 0.033)과 월급(salary)를 계산하시오
  
  세금 = 기본급 * 3.3%(0.033)
  월급 = 기본급 - 세금

<출력내용>
 [실행결과]
 *** L의 월급 ***
 기본급 : 2500000원
 세금 : 82500원
 월급 : 2417500원 
 
 변수 : 4개 
 숙제 제출X
 참가자 중 한사람 찝어서 그 사람의 답을 보는 방법
 소숫점은 표기X, 정수형(그냥 잘라도 되고, 반올림도 가능)
 */

public class PayTest {

	public static void main(String[] args) {
		char name = 'L'; //지역변수 | String name = "L"; 객체
		int basePay = 2500000;
		double tax = basePay * 0.033;
		//int tax = (int)(basePay * 0.033);
		double salary = basePay - tax;
		//int salary = basePay - tax;
		
		
		System.out.println("[실행결과]");
		System.out.println("**** " + name + "의 월급 ***");
		System.out.println("기본급 : " + basePay + "원");
		System.out.println("세금 : " + (int)tax + "원");
		//System.out.println("세금 : " + String.format("%.0f",tax) + "원");
		System.out.println("월급 : " + (int)salary + "원");
		
		

	}

}
