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

//XX번 a++ 
//while(true){ //위는 while문 하나 & continued에서 while문 2개
//break;
//}
//for(;;){ <-무한루프
//}
//for(;true;){
//}
//continue(Y/N)  if문? - 혼자 못하겠으면 내일 선생님이랑 같이 while 안의 while

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class NumberGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//a~b 사이의 난수 발생 => (int)(math.random()*(b-a+1) + a);
		int num = (int)(Math.random()*100)+1; //1~100사이
		int inp;
		int count = 0;
		String yn;
		
		//반복
		for(;;) {
			//입력받기		
			while (true) {
				
				//몇번째 숫자세기
				++count;	
				System.out.println("숫자 입력 : ");
				inp = Integer.parseInt(br.readLine());
			
				//비교, 출력
				if(num > inp) { 
					System.out.println(inp + "보다 큽니다");
				}else if(num < inp) {
					System.out.println(inp + "보다 작습니다");
				}else {
					 break;
				}	
						
				
			}//while
			System.out.println("딩동뎅~" + count + "번만에 맞추셨습니다");
			System.out.println("--------------------------------");
			
			while(true) {
				
				System.out.println("continue(Y/N)?");
				yn = br.readLine();
			
				if(yn.equals("n") || yn.equals("N") || yn.equals("y") || yn.equals("Y")) {
					break; 
				}else {
					System.out.println("올바른 문자를 입력하세요");
				}
				
			}//continue의 while
			if(yn.equals("n") || yn.equals("N")) break;
			
		}//for		
		System.out.println("프로그램을 종료했습니다");	
		
	}

}
