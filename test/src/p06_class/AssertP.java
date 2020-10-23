package p06_class;

import java.util.Scanner;

public class AssertP {

	public static void main(String[] args) {		
		AssertP as = new AssertP();
		as.inPut();
		as.outPut();
	}
	
	private int x, y, result = 1;
	
	public void inPut() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("x 입력 : ");
		x = scanner.nextInt();
		System.out.print("y 입력 : ");
		y = scanner.nextInt();
	}
	
	public void outPut() {
		assert y >= 0 : "y는 0보다 크거나 같아야 한다"; //에러메시지
		
		//프로그램에서 수행할 식
		for(int i = 1; i <= y; i++) {
			result *= x;
		}
		System.out.println(x + "의 " + y + "승 : " + result);
	}

}
