package practice;


public class CalTestP2 {
	    
 	    //메소드 만들기<MethodTest3>
	    int c = 25; //static int c도 가능
		int d = 36; //static int d도 가능
				
		public int sum(int c, int d) { 
			return c + d;
		}
		
		public int sub(int c, int d) {
			return c - d;
		}
		
		public int mul(int c, int d) {
			return c * d;
		}
		
		public double div(int c, int d) {
			return (double) c / d;
		}
	
	public static void main(String[] args) {
		/*
		 *  <CalcTest>
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
			int sub = a-b;
			int mul = a * b;
			double div = (double)a / b;
			
			System.out.println(a + "와 " + b + "의 합 : " + sum);
			System.out.println(a + "와 " + b + "의 차 : " + sub);
			System.out.println(a + "와 " + b + "의 곱 : " + mul);
			System.out.println(a + "와 " + b + "의 몫 : " + String.format("%.2f", div));
		    System.out.println();
			
		/* 
		 *  덧셈, 뺄셈, 곱셈, 나눗셈 메소드 만들기
		 *  숫자는 25, 36
		 *  필드에 작성
		 *  
		 */
			//int c = 25, d = 36;
			
			CalTestP2 calculation = new CalTestP2();
			
			System.out.println(calculation.c + "와 " + calculation.d + "의 합 : " + calculation.sum(calculation.c, calculation.d));
			System.out.println(calculation.c + "와 " + calculation.d + "의 차 : " + calculation.sub(calculation.c, calculation.d));
			System.out.println(calculation.c + "와 " + calculation.d + "의 곱 : " + calculation.mul(calculation.c, calculation.d));
			System.out.println(calculation.c + "와 " + calculation.d + "의 몫 : " + String.format("%.2f", calculation.div(calculation.c, calculation.d)));
			//calculation.sum(calculation.c, calculation.d)가 너무 길 경우, int c와 d앞에 static을 입력하기
	}

}
