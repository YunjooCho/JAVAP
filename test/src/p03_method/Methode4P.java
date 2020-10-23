package p03_method;

import java.util.Random;
import java.text.DecimalFormat;
import java.io.IOException;

public class Methode4P {

	public static void main(String[] args) throws IOException {
		System.out.println(Math.abs(-25)); //��Ŀ�� ���Ǳ�(300) ����
		
		//���� - ��ǻ�Ͱ� �������� �߻��ϴ� ��
		System.out.println("���� = " + Math.random()); //��Ŀ�� ���ǰ�()����
		
		//������ ó���ϴ� Ŭ����
		Random r = new Random();
		System.out.println("���� = " + r.nextDouble());
		
		//���� 3�ڸ����� ,��� �޼ҵ�
		int num = 1234567;
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		//Ű���� �Է� - 1���� ����
		System.out.print("������ a : ");
		char a = (char)System.in.read();
		//flush -  ���� ����
		System.in.read();
		System.in.read();
		
		System.out.print("������ b : ");
		char b = (char)System.in.read();
		System.out.println("��� = " + a + "\t" + b);
		
		//����� ���� �Լ�
		Methode4P mt4 = new Methode4P();
		char max = mt4.big(a,b);
		System.out.println("ū �� = " + max);
	}

	public char big(char a, char b) {
		return a > b ? a : b;
	}
}
