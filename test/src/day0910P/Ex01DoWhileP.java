package day0910P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//����ڷκ��� ���ڸ� �Է� �޵�
//10���� ū ���� ������ �ٽ� �Է¹޵��� ����� ����
public class Ex01DoWhileP {

	public static void main(String[] args) throws IOException {
	//�޸𸮻���
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	
	int number;
	
	//�ݺ���
	do {
		System.out.print("���� �Է� : ");
		number = Integer.parseInt(bufferedReader.readLine());
		
		if(number > 10) {
			System.out.println("�ٽ� �Է��ϼ���");
		}
	}while(number > 10);
	System.out.println("����ڰ� �Է��� ���� : " + number);
	}

}
