package day0910P;

import java.io.BufferedReader;

//성적 관리 프로그램
//우리가 사용자로부터 입력을 받되
//제일 마지막에 사용자로부터 계속할지 말지를 입력 받아서
//만약 사용자가 종료를 선택하면 프로그램이 종료가 되는 형식으로 만들어보자


import java.io.IOException;
import java.io.InputStreamReader;


public class Ex03NestedForP2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//스트링 초기화 방법
		//1. 생성자
		String yn = new String();
		System.out.println("1번" + yn);
		
		//2.null
		yn = null;
		System.out.println("2번" + yn);
		
		//3.리터럴(공백)
		yn = "";
		System.out.println("3번" + yn);
		
		//4.리터럴
		yn = "스트링";
		System.out.println("4번" + yn);
		
		do {
			System.out.print("이름 : ");
			String name = br.readLine();
			System.out.print("국어 : ");
			int kor = Integer.parseInt(br.readLine());
			System.out.print("영어 : ");
			int eng = Integer.parseInt(br.readLine());
			System.out.print("수학 : ");
			int math = Integer.parseInt(br.readLine());
			
			System.out.print("Continued(Y/N)? : ");
			yn = br.readLine().toUpperCase();
		}while(yn.equals("Y"));
		System.out.println("프로그램을 종료합니다.");
	}

}
