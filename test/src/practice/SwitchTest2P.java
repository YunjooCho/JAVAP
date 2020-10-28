package practice;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchTest2P {

	public static void main(String[] args) throws IOException {
		//메모리 입력
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    //키보드 입력
	    System.out.println("a 입력 : ");
	    int a = Integer.parseInt(br.readLine());
	    System.out.println("b 입력 : ");
	    int b = Integer.parseInt(br.readLine());
	    System.out.println("연산자(+,-,*,/,%) 입력 : ");
	    String calc = br.readLine();
	    
	    //계산
	    switch (calc) {
	    	case "+" : System.out.println(a + calc + b + " = " + (a + b));
	    				break;
	    	case "-" : System.out.println(a + calc + b + " = " + (a - b));
						break;
	    	case "*" : System.out.println(a + calc + b + " = " + (a * b));
			            break;
	    	case "/" : System.out.println(a + calc + b + " = " + (String.format("%.3f", (double)a / b)));
			            break;
	    	case "%" : System.out.println(a + calc + b + " = " + (a % b));
            			break;
	    	default : System.out.println("연산자 error");
	    	
	    }

	}

}
