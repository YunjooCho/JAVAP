package practice;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

public class MethodTest4P {

	public static void main(String[] args) throws IOException {
		
		//��Ŀ�� ���Ǳ�(300) ���� - ���밪(ABS) : Input�� ���� Output ����
		System.out.println(Math.abs(-25));
		System.out.println();
		
		
		//��Ŀ�� ���ǰ�()���� : Input�� ���µ��� Output ����
		//���� -��ǻ�Ͱ� �������� �߻��ϴ� ��, 0 <= ���� < 1 (�Ǽ���)
		System.out.println("���� = " + Math.random());
		
		//������ ó���ϴ� Ŭ����
		//�޸� ����(Static�ƴ�)
		Random rd = new Random(); 
		System.out.println("���� : " + rd.nextDouble()); //nextDouble ��ü
		System.out.println("�Ҽ���°�ڸ� :" + String.format("%.3f", rd.nextDouble()));
		System.out.println();
		
		//���ڸ� 3�ڸ����� , ���
		int a = 4500000;
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(a));
		
		//Ű���� �Է� - 1���� ����
		System.out.println("�Է� : ");
		char key = (char)System.in.read();
		System.out.println((int)key);
		
		//flush -  ���� ����
		
		
		//����� ���� �Լ� ��� - a�� b�߿��� ū ���� ����ϴ� �޼ҵ� �ۼ� 
		//main�Լ� ��
			
	}

}
