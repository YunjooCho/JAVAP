package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//성적 관리 프로그램
//우리가 사용자로부터 입력을 받되
//제일 마지막에 사용자로부터 계속할지 말지를 입력 받아서
//만약 사용자가 종료를 선택하면 프로그램이 종료가 되는 형식으로 만들어보자

public class Ex05GradeBook {
	public static void main(String[] args) throws IOException {
		//메모리 생성(초기화도 실행)
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//스트링을 초기화 해주는 방법(Uppercase메소드를 사용하므로 초기화 필요)
		//1번 생성자
		String yn = new String();
		System.out.println("1번" + yn);
		//2번 null
		yn = null;
		System.out.println("2번" + yn);
		//3번 리터럴(공백)
		yn = "";
		System.out.println("3번" + yn);
		//4번 리터럴
		yn = "스트링";
		System.out.println("4번" + yn);
		
		do {
			System.out.println("이름 : ");
			String name = bufferedReader.readLine();
			
			System.out.println("국어 : ");
			int kor = Integer.parseInt(bufferedReader.readLine());
			
			System.out.println("영어 : ");
			int eng = Integer.parseInt(bufferedReader.readLine());
			
			System.out.println("수학 : ");
			int math = Integer.parseInt(bufferedReader.readLine());
			
			int sum = kor + eng + math;
			System.out.println("총점 : " + sum);
			
			System.out.println("계속하시겠습니까? (y/n)");
			yn = bufferedReader.readLine();
			yn = yn.toUpperCase();//기존의 yn에 넣어줌 sum = sum + i 같은 거?
			//yn = bufferedReader.readLine().toUpperCase();
			//toUpperCase()메소드는
			//해당 내용을 모두 대문자로 바꿔주는 메소드이다
		}while(yn.equals("Y"));
		System.out.println("프로그램을 종료합니다");
	}

}
