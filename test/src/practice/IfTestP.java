package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfTestP {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("입력 : ");
		int num = Integer.parseInt(br.readLine());
		
		//입력받은 값이 짝수인지 홀수인지 확인
		if (num % 2 == 0) System.out.println("짝수");
		else System.out.println("홀수");
		
		
		//대문자&소문자&특수문자
		if (num >= 'A' && num <= 'Z') System.out.println("대문자 : " + (char)num);
		else if(num >= 'a' && num <= 'z') System.out.println("소문자 : " + (char)num);
		else System.out.println("숫자 또는 특수문자");
	}

}
