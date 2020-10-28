package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//사용자로부터 숫자를 입력 받되
//10보다 큰 수가 나오면 다시 입력받도록 만들어 보자
public class Ex01DoWhileP {

	public static void main(String[] args) throws IOException {
	//메모리생성
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	int number;
	
	//반복문
	do {
		System.out.print("숫자 입력 : ");
		number = Integer.parseInt(bufferedReader.readLine());
		
		if(number > 10) {
			System.out.println("다시 입력하세요");
		}
	}while(number > 10);
	System.out.println("사용자가 입력한 숫자 : " + number);
	}

}
