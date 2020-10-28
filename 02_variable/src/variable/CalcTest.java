package variable;


/*
 *  변수에 저장하여 320, 258의 합을 구하시오
 *  
 *  [실행결과]
 *  320 + 258 = XXX
 *  320 - 258 = XXX(sub)
 *  320 * 258 = XXX(mul)
 *  320 / 258 = XXX(div) 소숫점 이하 2자리
 */

public class CalcTest {

	public static void main(String[] args) {		
		short c = 320;
		short d = 258;
		short sum2 = (short)(c + d); 
		//JAVA 특성 상, 연산 후 결과값은 만드시 int형으로 산출됨 (short)를 적어 형변환 시킴
		System.out.println("short형 : " + c + " + " + d + " = " + sum2);
		System.out.println();
		
		int a = 320;
		int b = 258;
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		double div = (double)a / b; // 강제 형변환 ※(double)을 입력하여 변환 / 자동 형변환
		System.out.println(a + " + " + b + " = " + sum);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + mul);
		System.out.printf(a + " / " + b + " = %.2f\n", div);
		System.out.println(a + " / " + b + " = " + String.format("%.2f", div));
		
	}

}
