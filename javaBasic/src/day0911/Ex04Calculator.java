package day0911;



//���� ���α׷�
//����ڰ� ù���� ������ �Է��ϰ�
//+ - * / % �� �����ϰ�
//�ι�° ������ �Է��ϸ�
//�ش� ��ɿ� ���� �޼ҵ尡 ����Ǽ� 
//������� ȭ�鿡
//����ϰ� ��������

//����
//ù��° ���� �Է����ּ���: (1�Է�)
//�����ڸ� �������ּ���: +
//�ι�° ���� �Է����ּ���: (100�Է�)
//�����: 101

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04Calculator {

	//�Ի�޼ҵ�
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
	
	//main�޼ҵ忡�� ������ �޼ҵ带 ȣ���� �� �ְ� ���������
	public static void main(String[] args) throws IOException{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		
			
		System.out.print("ù��° ���� �Է��� �ּ��� : ");
		int number1 = Integer.parseInt(bufferedReader.readLine());
		System.out.print("�����ڸ� ������ �ּ���(+,-,/,*) : ");
		String operator = bufferedReader.readLine();
		System.out.print("�ι�° ���� �Է��� �ּ��� : ");
		int number2 = Integer.parseInt(bufferedReader.readLine());
		
		System.out.println("case��");
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
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
			break;
		}
		
		System.out.println();
		System.out.println();
		System.out.println("if��");
			if(operator.equals("+")) {
				System.out.println("����� : " + Ex04Calculator.add(number1, number2));
			}else if(operator.equals("-")) {
				System.out.println("����� : " + Ex04Calculator.sub(number1, number2));
			}else if(operator.equals("*")) {
				System.out.println("����� : " + Ex04Calculator.mul(number1, number2));
			}else if(operator.equals("/")) {
				System.out.printf("����� : %.2f", Ex04Calculator.div(number1, number2));
			}
		
		
		
		
		
	}

}
