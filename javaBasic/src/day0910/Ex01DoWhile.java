package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01DoWhile {
	public static void main(String[] args) throws IOException {
		int number = 5;
		while(number > 5) {
			System.out.println("반복이 될까요?");
		}
		//그에 반해서 do while은 무조건 한번은 실행이 된다.
		do {
			System.out.println("dowhile:반복이 될까요?");
		}while(number > 5);
		
		//사용자로부터 숫자를 입력 받되
		//10보다 큰 수가 나오면 다시 입력받도록 만들어 보자
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//while을 사용하면 다음과 같이 코드를 만들어야 한다.
		System.out.println("숫자를 입력하세요 : ");
		String number2 = bufferedReader.readLine();
		int stringToInt = Integer.parseInt(number2);
		
		while(stringToInt > 10) {
			//만약 사용자가 10보다 작거나 같은 수를 입력한다면
			//stringToInt > 10는 false가 나오기 때문에
			//이 while문은 실행이 되지 않는다.
			System.out.println("다시 입력해주세요 : ");
			number2 = bufferedReader.readLine();
			stringToInt = Integer.parseInt(number2);
		}
		System.out.println("사용자가 입력한 수 :" + number2);
		
		
		//do while을 쓰면 아래와 같이 쓸 수 있다.
		int userNumber = 0;
		do {
			if(userNumber > 0) {
				System.out.println("잘못입력하셨습니다");
			}
			System.out.println("숫자를 입력해 주세요 :");
			userNumber = Integer.parseInt(bufferedReader.readLine());
		}while(userNumber > 10);
		System.out.println("userNumber : " + userNumber);
	}
}
