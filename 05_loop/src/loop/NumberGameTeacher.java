package loop;

/*
숫자맞추기 게임
1~100사이의 난수를 발생하여 맞추는 게임

[실행결과]
숫자 입력 : 50
50보다 큽니다

숫자 입력 : 90
90보다 작습니다

...

숫자 입력 : 87
딩동뎅 xx번만에 맞추셨습니다        

continue(Y/N) : n
프로그램을 종료합니다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberGameTeacher {

	public static void main(String[] args) throws IOException {
		//메모리생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//변수
		int com, user, count = 0;
		String yn;
		
		for(;;) { //while(true)도 가능
			com = (int)(Math.random()*100)+1;
		
			while(true) {
			
			
				//사용자가 데이터 입력
				System.out.print("숫자 입력 : ");
				user = Integer.parseInt(br.readLine());
				count++; //1,2,3,4,5,....
			
				//비교
				if(com > user)
					System.out.print(user + "보다 큽니다\n");
			
				else if(com < user)
					System.out.print(user + "보다 작습니다\n");
			
				else
					break;
			

			
			}//while
			System.out.println("딩동뎅~" + count + "번 만에 맞추셨습니다");
			System.out.println("----------------------------------");
			
			while(true) {
				System.out.print("continue(Y/N) : ");
				yn = br.readLine();
				
				//이 while문을 벗어날 방법은 Y/y/N/n이면  빠져나감
				if(yn.contentEquals("Y")||yn.contentEquals("y")||yn.contentEquals("N")||yn.contentEquals("n"))
					break;
				//그 외의 글자는 반복문 실행
			}//continue의 while
			
				if(yn.equals("n")||yn.equals("N")) break; // for문 나가기
			

		}//for
		System.out.println("프로그램을 종료합니다");
	}

}
