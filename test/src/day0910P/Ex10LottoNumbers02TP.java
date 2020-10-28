package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

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

public class Ex10LottoNumbers02TP {
	//1. 상수 선언
	final static int SIZE = 6;
	final static int MAX = 45;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//배열
		int[] lottoNumbers = new int[SIZE];
		int[] userNumbers = new int[SIZE];
		
		//로또 번호 저장
		Random random = new Random();
		for(int i = 0; i < SIZE; i++) {
			lottoNumbers[i] = random.nextInt(MAX) + 1;
		}
		//중복제거
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

		System.out.println("로또 번호 추첨 완료");
		
		//사용자 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < userNumbers.length; i++) {
			System.out.print((i+1) + "번째 숫자를 입력하세요 : ");
			int number = Integer.parseInt(br.readLine());
			
			//사용자 입력 값이 중복일 경우 boolean변수에 값을 저장
			boolean isDuplicated = false;
			for(int j = 0; j < i; j++) {
				if(number == userNumbers[i]) {
					isDuplicated = true;
				}
			}
			
			
			while(number < 0 || number > MAX || isDuplicated == true) {
				System.out.println("잘못 입력하셨습니다");
				System.out.print((i+1) + "번째 숫자를 입력하세요 : ");
				number = Integer.parseInt(br.readLine());
				
				isDuplicated = false;
	            for(int j = 0; j < i; j++) {
	               if(number == userNumbers[i]) {
	                  isDuplicated = true;
	               }
	            }
			}
			userNumbers[i] = number;
		}
		
		
		//사용자가 입력한 숫자로 이루어진 배열 정렬
		for(int i = 0; i < userNumbers.length - 1; i++) {
			if(userNumbers[i] > userNumbers[i+1]) {
				int temp = userNumbers[i];
				userNumbers[i] = userNumbers[i+1];
				userNumbers[i+1] = temp;
				i = -1;
			}
		}
		
		
		//로또 배열과 사용자 입력배열 비교
		int score = 0;
		for(int i = 0; i < lottoNumbers.length; i++) {
			for(int j = 0; j < userNumbers.length; j++) {
				if(lottoNumbers[i] == userNumbers[j]) {
					score++;
				}
			}
		}
		
		//두 배열 출력
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i] + "\t" + userNumbers[i]);
		}
		switch(score) {
		case 6 :
			System.out.println("총" + score + "개 맞추셨습니다. 1등입니다.");
			break;
		case 5 :
			System.out.println("총" + score + "개 맞추셨습니다. 2등입니다.");
			break;
		case 4 :
			System.out.println("총" + score + "개 맞추셨습니다. 3등입니다.");
			break;
		case 3 :
			System.out.println("총" + score + "개 맞추셨습니다. 4등입니다.");
			break;
		default :
			System.out.println("총" + score + "개 맞추셨습니다. 탈락입니다.");
			break;
			
		}
	
	}

}
