package if_switch;

/*
가위(1), 바위(2), 보(3) 게임

[실행결과]
가위(1),바위(2),보(3) 중 번호 입력 : 3 (user)
컴퓨터 : 바위   나 : 보자기
You Win!!

가위(1),바위(2),보(3) 중 번호 입력 : 3 (user)
컴퓨터 : 가위   나 : 보자기
You Lose!!

가위(1),바위(2),보(3) 중 번호 입력 : 2 (user)
컴퓨터 : 가위   나 : 가위
You Draw!!
 */
//com 1 ~ 3의 난수, user 키보드 입력
//숫자가 아닌 한글로 표기(가위, 바위, 보)
//두 숫자를 비교하여 승패를 표기 - if문(9개), system.out

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RPSGame  {

	public static void main(String[] args) throws IOException {
		//메모리 생성(키보드 입력)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
				
		System.out.println("가위(1) 바위(2) 보(3) 중 번호 입력: ");
		int user = Integer.parseInt(br.readLine());
		
		
		//난수 -컴퓨터가 무작위로 발생하는 수, 0 <= 난수 < 1 (실수형)
		//a~b 사이의 난수 발생 => (int)(math.random()*(b-a+1) + a);
		
		//<예제>
		//double a = Math.random();
		//System.out.println(a); // 0.99999999999999999
		//System.out.println(a*100); // 99.999999999999999
		//System.out.println((int)(a*100)); // 99, 0~99
		//System.out.println((int)(a*100)+1); // 1~100
		
		//<예제2>
		//int a = (int)(Math.random()*25+65);
		//System.out.println((a)); //65~90
		//System.out.println((char)a); //A~Z
		
		//com의 가위 바위 보
		double b = Math.random();
		//System.out.println(b);
		//System.out.println(b*3);
		//System.out.println((int)(b*3)); // 0~2
		//System.out.println((int)(b*3)+1); // 1~3
		
		
		//com의 숫자를 글씨로 표기
		int com = (int) ((b*3)+1);
		System.out.println("컴퓨터 : ");
		if((int)(b*3)+1 == 1) {
			System.out.println("가위");
		}else if ((int)(b*3)+1 == 2) {
			System.out.println("바위");
		}else {
			System.out.println("보");
		}
		System.out.println();
		
		//user입력
		System.out.println("나 : ");
		if (user == 1) {
			System.out.println("가위");
		}else if(user == 2){
			System.out.println("바위");
		}else {
			System.out.println("보");
		}
		
		//승패결과
		 if(user == 1 ) {
			if (com == 2) {
				System.out.println("You Lose!");				
			}else if(com == 3){
				System.out.println("You Win!");
			}else {
				System.out.println("You Draw!");
			}
		}else if(user == 2) {
			if (com == 1) {
				System.out.println("You Win!");
			}else if(com == 3) {
				System.out.println("You Lose!");
			}else {
				System.out.println("You Draw!");
			}
		}else if(user == 3) {
			if(com == 1) {
				System.out.println("You Lose!");
			}else if(com == 2){
				System.out.println("You Win!");
			}else {
				System.out.println("You Draw!");
			}
		}

		
		
	}

}
