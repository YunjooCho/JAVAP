package practice;


public class CalcTestP {
	
	public int sum(int a, int b) {//덧셈 메소드 - 구현
		return a + b;             //메소드 괄호 안에 있는 값 - parameter, argument
  	}
	
	public int sub(int a, int b) {//뺄셈 메소드 - 구현
		return a - b;             
  	}
	
	public int mul(int a, int b) {//곱셈 메소드 - 구현
		return a * b;             
  	}
	
	public double div(int a, int b) {//나눗셈 메소드 - 구현
		return (double) a / b;  
  	}
	
	public static void main(String[] args) {
	
		/*
		 *  변수에 저장하여 320, 258의 합을 구하시오
		 *  
		 *  [실행결과]
		 *  320 + 258 = XXX
		 *  320 - 258 = XXX(sub)
		 *  320 * 258 = XXX(mul)
		 *  320 / 258 = XXX(div) 소숫점 이하 2자리
		 */
		
		int a = 320, b = 258;
		
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		double div = (double)a / b;
		
		System.out.println("sum = " + sum);
		System.out.println("sub = " + sub);
		System.out.println("mul = " + mul);
		System.out.println("div = " + String.format("%.2f", div));
		System.out.println();
		System.out.println();

		/* 
		 *  덧셈, 뺄셈, 곱셈, 나눗셈 메소드 만들기
		 *  숫자는 25, 36
		 *  필드에 작성
		 *  
		 */
		
		 CalcTestP y = new CalcTestP();
		 System.out.println("sum = " + y.sum(25, 36));
		 System.out.println("sub = " + y.sub(25, 36));
		 System.out.println("mul = " + y.mul(25, 36));
		 System.out.println("div = " + String.format("%.2f", y.div(25, 36)));
		 
	}

}
