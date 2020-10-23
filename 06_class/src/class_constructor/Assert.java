package class_constructor;

import java.util.Scanner;

public class Assert { //프로그램이 제대로 수행되는지 확인 - 중간체크
	//1.필드명 선언
	private  int x, y , result = 1;
	
	//2.메소드 작성
	public void inPut() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("x 입력 : ");
		x = scanner.nextInt();
		System.out.print("y 입력 : ");
		y = scanner.nextInt(); //횟수
	}
	
	public void outPut() {
		//y는 반드시 양수만 입력받도록 하겠다
		//y에 음수가 들어오면 작업이 멈춤
		//그냥 Run As가 아닌 Run As - Run Configrations - arguments - VM arguments에서 -ea입력
		//-da가 디폴트
		//디버그 처리
		//assert y >= 0;
		assert y >= 0 : "y는 0보다 크거나 같아야 한다"; 
		//에러메시지 
		//Exception in thread "main" java.lang.AssertionError: y는 0보다 크거나 같아야 한다
		
		//프로그램에서 수행할 식
		for(int i = 1; i <= y; i++) {
			 result *= x; //계속 x의 값을 곱한다
		}
		
		System.out.println(x + "의 " + y + "승은 " + result);
	}
	
	public static void main(String[] args) {
		Assert as = new Assert();
		as.inPut();
		as.outPut();
	}
}

//제곱승을 구하는 프로그램
// x입력 : 2
// y입력 : 5               input() - 입력(Scanner)
//--------------------------------
// 2의 5승은 xx             output() - 계산, 출력