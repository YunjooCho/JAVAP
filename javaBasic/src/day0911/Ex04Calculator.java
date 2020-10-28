package day0911;



//계산기 프로그램
//사용자가 첫번재 정수를 입력하고
//+ - * / % 를 선택하고
//두번째 정수를 입력하면
//해당 기능에 맞춘 메소드가 실행되서 
//결과값을 화면에
//출력하게 만들어보세요

//예시
//첫번째 값을 입력해주세요: (1입력)
//연산자를 선택해주세요: +
//두번째 값을 입력해주세요: (100입력)
//결과값: 101

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04Calculator {

	//게산메소드
	static int add(int a, int b) {
		return a + b;
	}
	static int sub(int a, int b) {
		return a - b;
	}
	static int mul(int a, int b) {
		return a * b;
	}
	static double div(int a, int b) {
		return (double)a / b;
	}
	
	static int remainder(int a, int b) {
		return a % b;
	}
	
	//main메소드에서 각각의 메소드를 호출할 수 있게 만들어주자
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		
			
		System.out.print("첫번째 값을 입력해 주세요 : ");
		int number1 = Integer.parseInt(bufferedReader.readLine());
		System.out.print("연산자를 선택해 주세요(+,-,/,*) : ");
		String operator = bufferedReader.readLine();
		System.out.print("두번째 값을 입력해 주세요 : ");
		int number2 = Integer.parseInt(bufferedReader.readLine());
		
		System.out.println("case문");
		switch(operator) {
		case "+":
			System.out.println(add(number1,number2));
			break;
		case "-":
			System.out.println(sub(number1,number2));
			break;
		case "*":
			System.out.println(mul(number1,number2));
			break;
		case "/":
			System.out.printf("%.2f",div(number1,number2));
			break;
		case "%":
			System.out.println(remainder(number1,number2));
			break;
		default : 
			System.out.println("잘못 입력하셨습니다");
			break;
		}
		
		System.out.println();
		System.out.println();
		System.out.println("if문");
			if(operator.equals("+")) {
				System.out.println("결과값 : " + Ex04Calculator.add(number1, number2));
			}else if(operator.equals("-")) {
				System.out.println("결과값 : " + Ex04Calculator.sub(number1, number2));
			}else if(operator.equals("*")) {
				System.out.println("결과값 : " + Ex04Calculator.mul(number1, number2));
			}else if(operator.equals("/")) {
				System.out.printf("결과값 : %.2f", Ex04Calculator.div(number1, number2));
			}
		
		
		
		
		
	}

}
