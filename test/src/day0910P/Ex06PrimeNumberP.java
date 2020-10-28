package day0910P;



//1부터 사용자가 입력하는 숫자까지의 소수를 구하는 프로그램
//소수란?
//약수가 1과 자기 자신만 있는 숫자
//= 즉 약수의 갯수가 2인 숫자

//약수란?
//a를 b로 나누어서 나눠 떨어지면(나머지가 0)
//b는 a의 약수가 된다.
//예시 : 6 / 3 은 나눠 떨어지기 때문에
//3은 6의 약수가 된다
//즉 약수란 나머지가 0인 숫자를 약수라고 한다
//그렇다면 2는 5의 약수인가?

//어떤 숫자의 가장 큰 약수는 얼마일까?
//5의 가장 큰 약수는 5다.
//1872의 가장 큰 약수는 1872다.

//예시
//숫자를 입력하세요 : 10
//1부터 10까지의 소수는
//2
//3
//5
//7
//입니다

//다중 for문 만들기
//i는 그 숫자가 소수인지 아닌지 검사할 숫자가 된다
//j는 그 숫자가 i의 약수인지 아닌지 체크할 숫자가 된다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ex06PrimeNumberP {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("숫자를 입력하세요 : ");
		int userNumber = Integer.parseInt(bufferedReader.readLine());
		
		
		//다중 if문
		
		System.out.println(userNumber + "의 소수는 ");
		for(int i = 1; i <= userNumber; i++) {
			int count = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					count++;
				}
			}//for j	
			if(count == 2) {
				System.out.println(i);
			}
					
			
			
		}//for i
	  System.out.println("입니다");

	}

}
