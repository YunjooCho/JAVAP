package p04_if_switch;


import java.io.IOException;


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


public class RGSGameP {

	public static void main(String[] args) throws IOException {
		
		int com, user;
		
		com = (int)(Math.random()*3) + 1;
		//a~b 사이의 난수 발생 => (int)(math.random()*(b-a+1) + a);
		//a~b 사이의 난수 발생 => (int)(math.random()*(3-1+1) + 1);
		
		System.out.println("가위(1) 바위(2) 보(3) 중 번호 입력: ");
		user = System.in.read() - '0'; //입력된 숫자문자를 숫자로 치환
		
		if(com == 1) {//컴이 가위인 경우
			if(user == 1) {
				System.out.println("컴퓨터 : 가위\t 사용자 : 가위");
				System.out.println("You Draw!");
			}else if(user == 2) {
				System.out.println("컴퓨터 : 가위\t 사용자 : 바위");
				System.out.println("You Win!");
			}else if(user == 3) {
				System.out.println("컴퓨터 : 가위\t 사용자 : 보");
				System.out.println("You Lose!");
			}
		}else if(com == 2) {//컴이 바위인 경우
			if(user == 1) {
				System.out.println("컴퓨터 : 바위\t 사용자 : 가위");
				System.out.println("You Lose!");
			}else if(user == 2) {
				System.out.println("컴퓨터 : 바위\t 사용자 : 바위");
				System.out.println("You Draw!");
			}else if(user == 3) {
				System.out.println("컴퓨터 : 바위\t 사용자 : 보");
				System.out.println("You Win!");
			}
		}else if(com == 3) {//컴이 보자기인 경우
			if(user == 1) {
				System.out.println("컴퓨터 : 보\t 사용자 : 가위");
				System.out.println("You Win!");
			}else if(user == 2) {
				System.out.println("컴퓨터 : 보\t 사용자 : 바위");
				System.out.println("You Draw!");
			}else if(user == 3) {
				System.out.println("컴퓨터 : 보\t 사용자 : 보");
				System.out.println("You Lose!");
			}
		}
	}
}
