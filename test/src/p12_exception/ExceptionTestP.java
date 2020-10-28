package p12_exception;

import java.util.Scanner;

public class ExceptionTestP {

	public static void main(String[] args) { //callBack과 유사, JVM이 가장 먼저 호출하는 부분, 
		                                     //String[] args는 들어오는 타입이 전부 String&배열 타입
		
		System.out.println(args[0]); //Run Configuration으로 값 입력
//		System.out.println(args[1]);
//		System.out.println(args[2]);
//		System.out.println(args[3]);
		
		if(args.length > 0) System.out.println(args[0]);	
		
		int num1 = Integer.parseInt(args[0]); //runas configuration에 문자를 입력한 경우 여기서 에러가 뜸
		System.out.println("num1 = " + num1);
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("숫자 입력 : "); 
			int num2 = scan.nextInt();
			System.out.println("num2 = " + num2);
			System.out.println("num1 / num2 = " + (num1 / num2));
		} catch (NumberFormatException e){
			System.out.println("숫자만 입력하세요"); 
		} catch (ArithmeticException e){
			System.out.println("0으로 나눌 수 없습니다");
		} finally {
			System.out.println("error가 있건 없건 무조건 실행!!");
		}
		

		
		
		
		

	}

}
