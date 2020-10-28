package day0910P;



//구구단 만들기
//입력받은 숫자의 단 출력하기

import java.io.IOException;

public class Ex03NestedForP02 {

	public static void main(String[] args) throws IOException{
		
		//변수
		int user;
		int dan;
		
		//반복문(구구단)
		System.out.print("원하는 단을 입력하세요 : ");
		user = System.in.read() - 48;
		for(int i = 1; i <= user; i++) {
			for(int j = 1; j <= 9; j++) {
				dan = i * j; 
				System.out.println(i + " * " + j + " = " + dan);
			}
		}

	}

}
