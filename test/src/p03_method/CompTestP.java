package p03_method;

public class CompTestP {

	public static void main(String[] args) {
		int score = 85;
		String result = score >= 80 && score <= 100 ? "합격" : "불합격";
		System.out.println("결과 = " + result);
		System.out.println();
		
		String result2 = score % 2 == 0 ? "짝수" : "홀수";
		System.out.println("결과 = " + result2);
		System.out.println();
		
		int a = 26, b = 125;
		int big = a > b ? a : b;
		System.out.println("결과 = " + big);
		System.out.println();
		System.out.println("큰 값 = " + Math.max(a, b)); //Math클래스 max()메소드
		System.out.println("작은 값 = " + Math.min(a, b));
		
		double p = Math.pow(2.0, 5.0);
		System.out.println("제곱 = " + p);
		System.out.println();
		
		int c = 15;
		String result3 = c % 2 == 0 && c % 3 ==0 ? "2와 3의 공배수이다" : "2와 3의 공배수가 아니다";
		System.out.println("결과 = " + result3);
			

	}

}
