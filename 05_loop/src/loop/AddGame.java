package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
더하기 연습 프로그램
10~99 사이의 난수를 2개(a, b) 발생하여 합을 구하는 프로그램
문제수는 총 5문제를 제공한다 - for
1문제당 점수 20점씩 계산

[실행결과]
[1] 25 + 36 = 45
틀렸다

[2] 78 + 10 = 88
딩동뎅
...

[5] 12 + 25 = 37
딩동뎅

당신의 총 x문제를 맞추어서 xx점 입니다

또 할래 (Y/N) : n
프로그램을 종료합니다
 */

public class AddGame {

	public static void main(String[] args) throws IOException {
		
		//메모리생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a, b, sum = 0, count = 0 , user, rightanswer = 0;
		String yn;
		
		//난수
		a = (int)(Math.random()*90)+10;
		b = (int)(Math.random()*90)+10;
		
	
		
		//반복문
		while(true) {
			count = 0;
			rightanswer = 0;
			
			for(int i = 1 ; i <= 5; i++) {
			
				//숫자세기
				count++;
				//계산
				sum = a + b;
			
			
				//출력
				System.out.print("[" + count + "]" + a +" + "+ b + " = ");
			
				//사용자 입력
				user = Integer.parseInt(br.readLine());
			
				//정답확인
				if (sum != user) {
					System.out.println("틀렸다");
					a = (int)(Math.random()*90)+1;
					b = (int)(Math.random()*90)+1;
				
				}else {
					rightanswer++;
					System.out.println("딩동뎅");
					a = (int)(Math.random()*90)+1;
					b = (int)(Math.random()*90)+1;
				}
			
			
			
			}//for
			System.out.println("당신은 총 " + rightanswer + "문제를 맞추어서 " + (rightanswer * 20) + "점 입니다");
		
			while(true) {
				System.out.print("또할래(Y/N) : ");
				yn = br.readLine();
			
				// Y/y/N/n이면  빠져나감
				if(yn.contentEquals("Y")||yn.contentEquals("y")||yn.contentEquals("N")||yn.contentEquals("n")) {
					break;
				}else {
					System.out.println("잘못된 명령입니다");
				}
				//그 외의 글자는 반복문 실행
			
				}//또할래 질문while
			//N/n이면 while 빠져나감
			if(yn.contentEquals("N")||yn.contentEquals("n")) {
				break;
			}
		}//또할래 반복 while
		
		System.out.println("프로그램을 종료합니다");
	}

}
