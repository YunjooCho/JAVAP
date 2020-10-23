package method;

public class CompTest3 {

	public static void main(String[] args) {
		int num1 = 0, num2 = 0;
		boolean result;
		
		result = ((num1 += 10) < 0 && (num2 += 10) > 0);
		
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1 + " num2 = " + num2);
		System.out.println();
		
		result = ((num1 += 10) > 0 || (num2 += 10) > 0);
		
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1 + " num2 = " + num2);

	}

}

//&&와 ||는 첫번째 조건이 만족하면 뒷 연산은 실행하지 않음(빠른 처리) 그러므로 num2는 0
//&와 |이면 첫번째 조건이 만족하더라도 뒷 연산까지 실행