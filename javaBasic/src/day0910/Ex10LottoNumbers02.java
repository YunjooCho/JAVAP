package day0910;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Ex10LottoNumbers02 {

	final static int SIZE = 6; 
	final static int MAX = 45;
	
	public static void main(String[] args) throws IOException {
		//메모리 생성
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//로또 번호를 저장할 인트배열을 만들어주자
		int[] lottoNumbers = new int[SIZE];
		int count = 1;
		int user;
		int correct = 0;
				
		//난수
		Random random = new Random();
		for(int i = 0; i < lottoNumbers.length; i++) {
			
			lottoNumbers[i] = random.nextInt(MAX) + 1; //0~44에 +1씩 
		}
		//중복 정리
		for(int i = 0; i < lottoNumbers.length; i++) {
			for(int j = 0; j < lottoNumbers.length; j++) {
				
				if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
					lottoNumbers[i] = random.nextInt(MAX) + 1; //i에 새로운 값을 넣음
					j = -1; //이후 j++이 실행되므로 -1 -> 0으로 바뀌어 처음부터 검사시작 (i는 중복이 검출된 값일 때부터 시작(i = 4)
			
				}//j의 if문
				
			}//for 중복 j문
				
				

		}//for 중복 i문
//		System.out.println("중복제거 후");
//		for(int i = 0; i < lottoNumbers.length; i++) {//for 중복 출력
//			System.out.println(lottoNumbers[i]);
//			
//		}//for 중복 출력
//		
		for(int i = 0; i < lottoNumbers.length - 1; i++) {
	         if(lottoNumbers[i] > lottoNumbers[i+1]) {
	            int temp = lottoNumbers[i];
	            lottoNumbers[i] = lottoNumbers[i+1];
	            lottoNumbers[i+1] = temp;
	            i = -1;
	         }
	      }
	      
//	      System.out.println("정렬 후");
//	      
//	      for(int i = 0; i < lottoNumbers.length; i++) {
//	         System.out.println(lottoNumbers[i]);
//	      }
		
		
		for(int i = 0; i <= lottoNumbers.length - 1; i++) {//입력
			
			System.out.println(count + "번째 숫자를 입력하세요 : ");
			user = Integer.parseInt(bufferedReader.readLine());
			//user는 배열이 아닌 계속 덮어쓰워짐, 입력 -> 입력값과 배열에 저장된 값 비교 -> correct증가(또는 변화없음) -> 입력값 다음 입력 숫자로 초기화 순서
			if( user < 1 || user > 45 ) {
				System.out.println("잘못 입력하셨습니다");
				System.out.println(count + "번째 숫자를 입력하세요 : ");
				user = Integer.parseInt(bufferedReader.readLine());
			}
			if ( user == lottoNumbers[i]) {
				correct++;
			}
			count++;
			System.out.println("총" + correct + "개 맞추셨습니다");
		}//입력 for문
		
		
		
		
		
		
	}

}
