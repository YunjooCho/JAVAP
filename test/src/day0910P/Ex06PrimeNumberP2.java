package day0910P;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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
public class Ex06PrimeNumberP2  {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int number = Integer.parseInt(br.readLine());
		
		System.out.println("1����" + number + "������ �Ҽ���");
		for(int i = 1; i <= number; i++) {
			int count = 0;
			for(int j = 1; j <= i; j++) {
				if(i % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println(i);
			}
		}
		System.out.println("�Դϴ�");

	}

}
