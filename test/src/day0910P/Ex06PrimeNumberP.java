package day0910P;



//1���� ����ڰ� �Է��ϴ� ���ڱ����� �Ҽ��� ���ϴ� ���α׷�
//�Ҽ���?
//����� 1�� �ڱ� �ڽŸ� �ִ� ����
//= �� ����� ������ 2�� ����

//�����?
//a�� b�� ����� ���� ��������(�������� 0)
//b�� a�� ����� �ȴ�.
//���� : 6 / 3 �� ���� �������� ������
//3�� 6�� ����� �ȴ�
//�� ����� �������� 0�� ���ڸ� ������ �Ѵ�
//�׷��ٸ� 2�� 5�� ����ΰ�?

//� ������ ���� ū ����� ���ϱ�?
//5�� ���� ū ����� 5��.
//1872�� ���� ū ����� 1872��.

//����
//���ڸ� �Է��ϼ��� : 10
//1���� 10������ �Ҽ���
//2
//3
//5
//7
//�Դϴ�

//���� for�� �����
//i�� �� ���ڰ� �Ҽ����� �ƴ��� �˻��� ���ڰ� �ȴ�
//j�� �� ���ڰ� i�� ������� �ƴ��� üũ�� ���ڰ� �ȴ�

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Ex06PrimeNumberP {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("���ڸ� �Է��ϼ��� : ");
		int userNumber = Integer.parseInt(bufferedReader.readLine());
		
		
		//���� if��
		
		System.out.println(userNumber + "�� �Ҽ��� ");
		for(int i = 1; i <= userNumber; i++) {
			int count = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					count++;
				}
			}//for j	
			if(count == 2) {
				System.out.println(i);
			}
					
			
			
		}//for i
	  System.out.println("�Դϴ�");

	}

}
