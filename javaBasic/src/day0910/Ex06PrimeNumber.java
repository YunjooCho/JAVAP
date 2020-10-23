package day0910;

//1부터 사용자가 입력하는 숫자까지의 소수를 구하는 프로그램
//소수란?
//약수가 1과 자기 자신만 있는 숫자
// = 즉 약수의 갯수가 2인 숫자

//약수란?
// a를 b로 나누어서 나눠 떨어지면(나머지가 0)
// b는 a의 약수가 된다.
// 예시 : 6 / 3 은 나눠 떨어지기 때문에
// 3은 6의 약수가 된다
// 즉 약수란 나머지가 0인 숫자를 약수라고 한다
// 그렇다면 2는 5의 약수인가?

// 어떤 숫자의 가장 큰 약수는 얼마일까?
// 5의 가장 큰 약수는 5다.
// 1872의 가장 큰 약수는 1872다.

//예시
// 숫자를 입력하세요 : 10
// 1부터 10까지의 소수는
// 2
// 3
// 5
// 7
// 입니다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex06PrimeNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("숫자를 입력하세요 : ");
		int number = Integer.parseInt(bufferedReader.readLine());
		//다중 for문 만들기
		//i는 그 숫자가 소수인지 아닌지 검사할 숫자가 된다
		//j는 그 숫자가 i의 약수인지 아닌지 체크할 숫자가 된다
		System.out.println("1부터" + number + "까지의 소수는");
		for(int i = 1; i <= number; i++) {
			//그 다음 약수의 갯수를 저장할 변수를 하나 만든다.
			int count = 0;
			
			//j for 문을 통해서 j가 약수이면 (즉 나머지가 0이면)
			//count를 1 증가 시킨다.
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				//약수의 갯수가 2개
				System.out.println(i);
			}
			//number의 현재값: 10
			//i의 현재값: 1 , 2
			//j의 현재값: 1 , 2(j for문 종료, 사라짐)->1 , 2 , 3
			//count의 현재값: 0 , 1(사라짐)->0, 1 , 2
			
		}
		System.out.println("입니다");
	}
	

}
