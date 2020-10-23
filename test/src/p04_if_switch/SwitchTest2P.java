package p04_if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2개의 정수형 숫자와 연산자(+,-,*,/)를 입력하여 계산하시오

[실행결과]
a 입력 : 25
b 입력 : 36
연산자(+,-,*,/) 입력 : +
25 + 36 = xx

a 입력 : 25
b 입력 : 36
연산자(+,-,*,/) 입력 : /
25 / 36 = 0.xxx

a 입력 : 25
b 입력 : 36
연산자(+,-,*,/) 입력 : $
연산자 error
 */

public class SwitchTest2P {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("a 입력 : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("b 입력 : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("연산자(+,-,*,/) 입력 : ");
		String y = br.readLine();
		
		
		switch(y) {
		case "+" : System.out.println(a + y + b + "= " + (a + b));
			       break;
		case "-" : System.out.println(a + y + b + "= " + (a - b));
				   break;
		case "*" : System.out.println(a + y + b + "= " + (a * b));
			       break;
		case "/" : System.out.println(a + y + b + "= " + (a / b));
				   break;
		default : System.out.println("연산자 error");
		}
		

	}

}
