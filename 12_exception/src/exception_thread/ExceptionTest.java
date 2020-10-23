package exception_thread;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) { //callBack�� ����, JVM�� ���� ���� ȣ���ϴ� �κ�, String[] args�� ������ Ÿ���� ���� String&�迭Ÿ��
//		System.out.println(args[0]); //�׳� RunAs�ϸ� ������
//		                             //������ ���콺 - RunAs - Run Configuration - Arguments - Program Arguments�� StringŸ�� ���� �ְ� ����
//		System.out.println(args[1]); //�ΰ��� �����͸� �Է�(����� ����, �Ǵ� ""�� �ִ� ��� ""�� ������ ������ �켱����)�ϸ� �迭�� ����
		                             //�ϳ��� �����͸� �Է��ϴ� ���, System.out.println(args[1])�� ������ ��
		               
		if(args.length > 0) System.out.println(args[0]);//System.out.println(args[1])�� ������ throws, try~catch �ʿ� ����, ���α׷����� ������
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("���� �Է� : ");
			int num2 = scan.nextInt();
			
			int num1 = Integer.parseInt(args[0]); //Run Configuration���� ���� �Է�
			//������ ���콺 - RunAs - Run Configuration - Arguments - Program Arguments�� ȣ���̶�� �Է��� ��� ���⼭ ������ ��
			//Integer�� ���� ���ڿ��� �Է��߱� ������
			System.out.println(num1 + " / " + num2 + " = " + ((double)num1/num2)); //���Ⱑ ������ �϶��� catch �ι�°�� �����
			//double������ ��ȯ�ϸ� Infinity�� ��(�Ҽ��ڸ��� �������� ����Ϸ��� �ϱ� ������)
		} catch (NumberFormatException e){//� Exception�� ���� ������
			System.out.println("���ڸ� �Է��ϼ���");
			//num2�� ���ڸ� �Է��ص� num1�� ȣ���̰� �� �ֱ� ������ ������ ��
			//Exception in thread "main" java.lang.NumberFormatException: For input string: "ȣ����" �� �����޽��� ��� ǥ�õ�
		} catch(ArithmeticException e) {//ArithmeticException �� ����ó�� ��ü�� ������ܷ� ��� ���� 0���� ���� �� ���⶧����
			                			//try�ȿ� �ִ� ������ �Ŀ� ������ ���� 0�̸� ������ �ߵ��� ��
										//���� �Է� �κп� 0�� ���� num1 / 0(num2) �� �ǹǷ� ������ �� 
			System.out.println("0���� ���� �� �����ϴ�");
		} finally {//���� ������ ������� �ݵ�� ����Ǵ� �κ�
			System.out.println("error�� �ְ� ���� ������ ����!!");
			//DBó������ �����߰� ���߰� �ݵ�� ������Ѿ��� �� ���
		}
		
	}

}


