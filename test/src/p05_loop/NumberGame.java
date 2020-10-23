package p05_loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

public class NumberGame {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//a~b 사이의 난수 발생 => (int)(math.random()*(b-a+1) + a);
		int number = (int)(Math.random()*100 + 1);
		int input;
		int count = 0;
		while(true) {
			
			++count;
			System.out.print("숫자 입력 :");
			input = Integer.parseInt(br.readLine());
			
			if(input < number) {
				System.out.println(input + " 보다 큽니다");
			}else if(input > number) {
				System.out.println(input + "보다 작습니다");
			}else {
				System.out.println("딩동뎅~ " + count + "번만에 맞추셨습니다.");
				System.out.print("continue(Y/N)? ");
				String yn = br.readLine().toUpperCase();
				while(true) {
					if(yn.contentEquals("Y")||yn.contentEquals("y")||yn.contentEquals("N")||yn.contentEquals("n"))
					break;
				}
				if(yn.equals("N")) {
					System.out.println("프로그램을 종료합니다");
					break;
				}
			}
		
		}

	}

}
