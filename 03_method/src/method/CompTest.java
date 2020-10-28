package method;

public class CompTest {

	public static void main(String[] args) {
		int score = 85;
		
		//System.out.println(score >= 80 && score <= 100 ? "합격" : "불합격");
		//출력
		
		String result = score >= 80 && score <= 100 ? "합격" : "불합격";
		System.out.println("결과 = " + result);
		//변수에 저장 후 출력
		System.out.println();
		
		
		//score의 값이 짝수이면 "짝수" 아니면 "홀수"라고 출력
		String result2 = score % 2 == 0 ? "짝수" : "홀수";
		System.out.println("결과 = " + result2);
		System.out.println();
		
		//a, b중에서 큰 값을 출력하시오
		int a = 26, b = 125;
		int big = a > b ? a : b;
		System.out.println("결과 = " + big);
		System.out.println();
		System.out.println("큰 값 = " + Math.max(a,b));
		System.out.println("작은 값 = " + Math.min(a,b));
		
		
		//System.out.println("제곱 = " + Math.pow(2.0, 5.0));
		double p = Math.pow(2.0, 5.0);
		System.out.println("제곱 = " + p);
		System.out.println();
		
		//c가 2와 3의 공배수인지 확인
		int c = 15;
		result = c % 2 == 0 && c % 3 == 0 ? "2와 3의 공배수이다" : "2와 3의 공배수가 아니다";
		System.out.println("결과 = " + result);
		System.out.println();
		
	}

}
