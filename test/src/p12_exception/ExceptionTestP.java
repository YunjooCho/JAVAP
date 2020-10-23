package p12_exception;

import java.util.Scanner;

public class ExceptionTestP {

	public static void main(String[] args) { //callBack�� ����, JVM�� ���� ���� ȣ���ϴ� �κ�, 
		                                     //String[] args�� ������ Ÿ���� ���� String&�迭 Ÿ��
		
		System.out.println(args[0]); //Run Configuration���� �� �Է�
//		System.out.println(args[1]);
//		System.out.println(args[2]);
//		System.out.println(args[3]);
		
		if(args.length > 0) System.out.println(args[0]);	
		
		int num1 = Integer.parseInt(args[0]); //runas configuration�� ���ڸ� �Է��� ��� ���⼭ ������ ��
		System.out.println("num1 = " + num1);
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("���� �Է� : "); 
			int num2 = scan.nextInt();
			System.out.println("num2 = " + num2);
			System.out.println("num1 / num2 = " + (num1 / num2));
		} catch (NumberFormatException e){
			System.out.println("���ڸ� �Է��ϼ���"); 
		} catch (ArithmeticException e){
			System.out.println("0���� ���� �� �����ϴ�");
		} finally {
			System.out.println("error�� �ְ� ���� ������ ����!!");
		}
		

		
		
		
		

	}

}
