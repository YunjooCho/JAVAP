package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01DoWhileP2 {
	public static void main(String[] args) throws IOException {
		int number = 5;
		while(number > 5) {
			System.out.println("�ݺ��� �ɱ��?");
		}
		
		//Do~While�� ������ �ѹ� ����ȴ�
		do {
			System.out.println("dowhile : �ݺ��� �ɱ��?");
		}while(number > 5);
		
		
		//����ڷκ��� ���ڸ� �Է� �޵�
		//10���� ū ���� ������ �ٽ� �Է¹޵��� ����� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("���ڸ� �Է��ϼ��� : ");
		String number2 = br.readLine();
		int stringToInt = Integer.parseInt(number2);
		
		while(stringToInt > 10) {
			System.out.println("�ٽ� �Է����ּ���");
			number2 = br.readLine();
			stringToInt = Integer.parseInt(number2);
		}
		System.out.println("����ڰ� �Է��� �� : " + stringToInt);
		
		//do~while��
		int userNumber = 0;
		do {
			if(userNumber > 0) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�");
			}
			System.out.print("���ڸ� �Է��ϼ���(dowhile) : ");
			userNumber = Integer.parseInt(br.readLine());
		}while(userNumber > 10);
		System.out.println("userNumber : " + userNumber);
		
	}

}
