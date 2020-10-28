package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//로또 번호제작기 2번
//사용자로부터 숫자를 입력 받아서
//6개가 다 맞을시: 1등
//5개가 맞을시: 2등
//4개: 3등
//3개: 4등
//이 출력되는 프로그램을 작성하시오.
//단 사용자가 1~45를 벗어난 값을 입력하면
//올바른 값을 입력할때까지 다시 입력을 하게 만드세요

//프로그램 예시:
//로또번호 추첨 완료
//1번째 숫자를 입력하세요: 3
//2번째 숫자를 입력하세요: 1
//3번째 숫자를 입력하세요: 1000
//잘못 입력하셨습니다.
//3번째 숫자를 입력하세요: -150
//잘못 입력하셨습니다.
//3번째 숫자를 입력하세요: 43
//4번째 숫자를 입력하세요: 23
//5번째 숫자를 입력하세요: 12
//6번째 숫자를 입력하세요: 11
//총 4개 맞추셨습니다. 3등 당첨입니다!!! (55분까지)

import java.util.Random;

public class Ex10LottoNumbers02P {
	final static int SIZE = 6;
	final static int MAX = 46;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//배열, 변수 선언
		int[] lottoNumbers = new int[6];
		int user;
		int count = 1;
		int correct = 0;
		
		
		//난수 발생, 배열에 입력
		Random random = new Random();
		for(int i = 0; i < SIZE; i++) {
			lottoNumbers[i] = random.nextInt(MAX) + 1;
		}
		//중복 제거
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
					lottoNumbers[i] = random.nextInt(MAX) + 1;
					j = -1; 
				}
			}
		}
		//정렬
		for(int i = 0; i < SIZE - 1; i++) {
			if(lottoNumbers[i] > lottoNumbers[i+1]) {
				int temp = lottoNumbers[i];
				lottoNumbers[i] = lottoNumbers[i+1];
				lottoNumbers[i+1] = temp;
				i = -1;
			}
		}
		
		//사용자로부터 숫자 입력받기
		for(int i = 0; i < SIZE; i++) {
			System.out.print(count + "번째 숫자를 입력하세요 :");
			user = Integer.parseInt(br.readLine());
			count++;
			if(user < 1 || user > 45) {
				System.out.println("잘못입력하셨습니다");
				System.out.print(count + "번째 숫자를 입력하세요 :");
				user = Integer.parseInt(br.readLine());
			}//if
			
			if(user == lottoNumbers[i]) {
				correct++;
			}
		}
		
		//결과 출력
		switch(correct) {
		case 6 : System.out.println("총 " + correct + "개 맞추셨습니다. 1등 입니다!!!");
			     break;
		case 5 : System.out.println("총 " + correct + "개 맞추셨습니다. 2등 입니다!!!");
			     break;
		case 4 : System.out.println("총 " + correct + "개 맞추셨습니다. 3등 입니다!!!");
			     break;
		case 3 : System.out.println("총 " + correct + "개 맞추셨습니다. 4등 입니다!!!");
			     break;
	    default : System.out.println("총 " + correct + "개 맞추셨습니다. 순위권 밖입니다.");
	    		 break;
		}
	}
}
