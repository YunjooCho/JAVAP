package if_switch;

import java.io.IOException;

//선생님 풀이
public class RPSGame3 {

	public static void main(String[] args) throws IOException{
		int com, user;
		
		com = (int)(Math.random()*3)+1; //1~3 난수 발생
		
		System.out.println("가위(1), 바위(2), 보(3) 중 번호 입력 : ");
		//user = System.in.read()-48; //1개의 문자 입력(입력된 문자('1','2','3')를 숫자로 치환)
		
		user = System.in.read()-'0';
		
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
