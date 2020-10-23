package exception_thread;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) { //callBack과 유사, JVM이 가장 먼저 호출하는 부분, String[] args는 들어오는 타입이 전부 String&배열타입
//		System.out.println(args[0]); //그냥 RunAs하면 에러남
//		                             //오른쪽 마우스 - RunAs - Run Configuration - Arguments - Program Arguments에 String타입 값을 넣고 실행
//		System.out.println(args[1]); //두개의 데이터를 입력(띄어쓰기로 구분, 또는 ""가 있는 경우 ""로 지정한 범위가 우선순위)하면 배열로 받음
		                             //하나의 데이터만 입력하는 경우, System.out.println(args[1])가 에러가 뜸
		               
		if(args.length > 0) System.out.println(args[0]);//System.out.println(args[1])의 에러를 throws, try~catch 필요 없음, 프로그램으로 막아줌
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("숫자 입력 : ");
			int num2 = scan.nextInt();
			
			int num1 = Integer.parseInt(args[0]); //Run Configuration으로 값을 입력
			//오른쪽 마우스 - RunAs - Run Configuration - Arguments - Program Arguments에 호랑이라고 입력한 경우 여기서 에러가 뜸
			//Integer에 대해 문자열을 입력했기 때문에
			System.out.println(num1 + " / " + num2 + " = " + ((double)num1/num2)); //여기가 나누기 일때만 catch 두번째가 실행됨
			//double형으로 변환하면 Infinity가 뜸(소수자리를 악착같이 계산하려고 하기 때문에)
		} catch (NumberFormatException e){//어떤 Exception을 잡을 것인지
			System.out.println("숫자만 입력하세요");
			//num2에 숫자를 입력해도 num1에 호랑이가 들어가 있기 때문에 에러가 뜸
			//Exception in thread "main" java.lang.NumberFormatException: For input string: "호랑이" 이 에러메시지 대신 표시됨
		} catch(ArithmeticException e) {//ArithmeticException 이 예외처리 자체가 산수예외로 모든 수는 0으로 나눌 수 없기때문에
			                			//try안에 있는 나눗셈 식에 나누는 값이 0이면 에러가 뜨도록 함
										//숫자 입력 부분에 0이 들어가면 num1 / 0(num2) 이 되므로 에러가 뜸 
			System.out.println("0으로 나눌 수 없습니다");
		} finally {//에러 유무에 상관없이 반드시 실행되는 부분
			System.out.println("error가 있건 없건 무조건 실행!!");
			//DB처리에서 실행했건 안했건 반드시 종료시켜야할 때 사용
		}
		
	}

}


