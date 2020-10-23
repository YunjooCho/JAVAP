package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01DoWhileP2 {
	public static void main(String[] args) throws IOException {
		int number = 5;
		while(number > 5) {
			System.out.println("반복이 될까요?");
		}
		
		//Do~While은 무조건 한번 실행된다
		do {
			System.out.println("dowhile : 반복이 될까요?");
		}while(number > 5);
		
		
		//사용자로부터 숫자를 입력 받되
		//10보다 큰 수가 나오면 다시 입력받도록 만들어 보자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자를 입력하세요 : ");
		String number2 = br.readLine();
		int stringToInt = Integer.parseInt(number2);
		
		while(stringToInt > 10) {
			System.out.println("다시 입력해주세요");
			number2 = br.readLine();
			stringToInt = Integer.parseInt(number2);
		}
		System.out.println("사용자가 입력한 수 : " + stringToInt);
		
		//do~while문
		int userNumber = 0;
		do {
			if(userNumber > 0) {
				System.out.println("잘못 입력하셨습니다");
			}
			System.out.print("숫자를 입력하세요(dowhile) : ");
			userNumber = Integer.parseInt(br.readLine());
		}while(userNumber > 10);
		System.out.println("userNumber : " + userNumber);
		
	}

}
