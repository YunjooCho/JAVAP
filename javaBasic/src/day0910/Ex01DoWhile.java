package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01DoWhile {
	public static void main(String[] args) throws IOException {
		int number = 5;
		while(number > 5) {
			System.out.println("�ݺ��� �ɱ��?");
		}
		//�׿� ���ؼ� do while�� ������ �ѹ��� ������ �ȴ�.
		do {
			System.out.println("dowhile:�ݺ��� �ɱ��?");
		}while(number > 5);
		
		//����ڷκ��� ���ڸ� �Է� �޵�
		//10���� ū ���� ������ �ٽ� �Է¹޵��� ����� ����
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//while�� ����ϸ� ������ ���� �ڵ带 ������ �Ѵ�.
		System.out.println("���ڸ� �Է��ϼ��� : ");
		String number2 = bufferedReader.readLine();
		int stringToInt = Integer.parseInt(number2);
		
		while(stringToInt > 10) {
			//���� ����ڰ� 10���� �۰ų� ���� ���� �Է��Ѵٸ�
			//stringToInt > 10�� false�� ������ ������
			//�� while���� ������ ���� �ʴ´�.
			System.out.println("�ٽ� �Է����ּ��� : ");
			number2 = bufferedReader.readLine();
			stringToInt = Integer.parseInt(number2);
		}
		System.out.println("����ڰ� �Է��� �� :" + number2);
		
		
		//do while�� ���� �Ʒ��� ���� �� �� �ִ�.
		int userNumber = 0;
		do {
			if(userNumber > 0) {
				System.out.println("�߸��Է��ϼ̽��ϴ�");
			}
			System.out.println("���ڸ� �Է��� �ּ��� :");
			userNumber = Integer.parseInt(bufferedReader.readLine());
		}while(userNumber > 10);
		System.out.println("userNumber : " + userNumber);
	}
}
