package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04DoWhile03 {

	public static void main(String[] args) throws IOException {
		
		//메모리 생성
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//기존 while의 경우에는
		//while 옆의 조건식이 false가 나오면
		//반복이 중단되고
		//true가 나오면 반복되는 형식이었다.
		System.out.println("숫자를 하나 입력해주세요 : ");
		int number = Integer.parseInt(bufferedReader.readLine());
		while(number < 0) { 
			System.out.println("자연수를 입력해주세요");
			System.out.print("숫자를 하나 입력해주세요");
			number = Integer.parseInt(bufferedReader.readLine());
		}
		
		//위 while문의 경우
		//사용자가 맨 처음에 0보다 크거나 같은 수를 입력하면
		//number < 0 이라는 조건식이 false가 나오므로
		//반복이 되지 않게 된다.(while문 자체가 실행이 안됨)
		System.out.println("사용자가 입력한 숫자 : " + number); //0보다 크거나 같아야 실행됨
		
		
		
		//그에 반해서 do while 구조에서는
		//무조건 한번은 실행이 된다.
		do {
			System.out.println("두 와일 첫번째 줄");
		}while(number < 0);
		//여기가 true가 나오면 do문이 반복 
		//0보다 작은 수가 나오면 반복
	}

}
