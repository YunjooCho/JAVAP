package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
3개의 숫자(a,b,c)를 입력받아서 순서대로 출력하시오

[실행결과]
a : 68
b : 50
c : 45
45, 50, 68

a : 30
b : 50
c : 45
30, 45, 50
 */

public class IfTest3P {

	public static void main(String[] args) throws IOException {

		//메모리 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("a : ");
		int a = Integer.parseInt(br.readLine());
		System.out.println("b : ");
		int b = Integer.parseInt(br.readLine());
		System.out.println("c : ");
		int c = Integer.parseInt(br.readLine());
		
		if(a < b && a < c) {
			if(b < c) {
				System.out.println(a + "," + b + "," + c);
			}else {
				System.out.println(a + "," + c + "," + b);
			}
		}else if(b < a && b < c) {
			if(a < c) {
				System.out.println(b + "," + a + "," + c);
			}else {
				System.out.println(b + "," + c + "," + a);
			}
		}else {
			if(a < b) {
				System.out.println(c + "," + a + "," + b);
			}else {
				System.out.println(c + "," + b + "," + a);
			}
		}

	}

}
