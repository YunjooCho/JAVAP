package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04DoWhile03 {

	public static void main(String[] args) throws IOException {
		
		//�޸� ����
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//���� while�� ��쿡��
		//while ���� ���ǽ��� false�� ������
		//�ݺ��� �ߴܵǰ�
		//true�� ������ �ݺ��Ǵ� �����̾���.
		System.out.println("���ڸ� �ϳ� �Է����ּ��� : ");
		int number = Integer.parseInt(bufferedReader.readLine());
		while(number < 0) { 
			System.out.println("�ڿ����� �Է����ּ���");
			System.out.print("���ڸ� �ϳ� �Է����ּ���");
			number = Integer.parseInt(bufferedReader.readLine());
		}
		
		//�� while���� ���
		//����ڰ� �� ó���� 0���� ũ�ų� ���� ���� �Է��ϸ�
		//number < 0 �̶�� ���ǽ��� false�� �����Ƿ�
		//�ݺ��� ���� �ʰ� �ȴ�.(while�� ��ü�� ������ �ȵ�)
		System.out.println("����ڰ� �Է��� ���� : " + number); //0���� ũ�ų� ���ƾ� �����
		
		
		
		//�׿� ���ؼ� do while ����������
		//������ �ѹ��� ������ �ȴ�.
		do {
			System.out.println("�� ���� ù��° ��");
		}while(number < 0);
		//���Ⱑ true�� ������ do���� �ݺ� 
		//0���� ���� ���� ������ �ݺ�
	}

}
