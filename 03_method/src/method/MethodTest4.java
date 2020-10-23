package method;

import java.util.Random;
import java.text.DecimalFormat;
import java.io.IOException;

public class MethodTest4 {
	
	
	public static void main(String[] args) throws IOException {
		System.out.println(Math.abs(-25));//��Ŀ�� ���Ǳ�(300) ����
		//MathŬ������ abs()�޼ҵ� : ���밪 ���ϴ� �޼ҵ�
		
		//���� -��ǻ�Ͱ� �������� �߻��ϴ� ��, 0 <= ���� < 1 (�Ǽ���)
		System.out.println("���� = " + Math.random()); //��Ŀ�� ���ǰ�()����
		//MathŬ������ random()�޼ҵ� : ������ ���ϴ� �޼ҵ�
		
		//������ ó���ϴ� RandomŬ����
		Random r = new Random(); //����(Static�ƴ�)
		System.out.println("���� = " + r.nextDouble()); //nextDouble ��ü
		
		//DecimalFormat(NumberFormat)Ŭ������ format()�޼ҵ�
		//���ڸ� 3�ڸ����� , ���
		int num = 1234567;
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		
		//SystemŬ������ in�ʵ�
		//Ű���� �Է� - 1���� ����
		System.out.println("������a : ");
		char a = (char)System.in.read(); //��������
		//System.in.read();�� �⺻ int�� ����
		
		//flush -  ���� ����
		System.in.read(); //���ٹٲٱ�?
		System.in.read(); //���� �����ΰ���?
		
		System.out.println("������b : ");
		char b = (char)System.in.read();
		System.out.println("��� = " + a + "\t" + b);
		
		//����� ���� �Լ� ���(Ŭ�������� �۾��ϰ� �ִ� Ŭ����) - a�� b�߿��� ū ���� ����ϴ� �޼ҵ带 ����ڰ� �ۼ� 
		//main�Լ� ��
		MethodTest4 mt = new MethodTest4();
		char max = mt.big(a,b);
		System.out.println("ū �� = " + max);
		
		
	}
	
	public char big(char a, char b){ //����� ���� �Լ� ����, parameter(�Ű�����), argument(�μ�)
		return a > b ? a : b;
	}
	
}

//�ڹ�
// -main �޼ҵ�
// -�ڹٰ� �ƴ� ��Ű���� java.lang
// -�ڹٴ� ��� Ŭ������ java.lang(default package) ã�´�

//����ó�� Exception
//������ ���� ���۽����� �ߴ� �� ��� �Էµ� ������ ����
//try~catch
//throws
// -try~catch�� ���� �𸣹Ƿ� JVM���� �� �ѱ�� ���
// -�Լ� �ڿ� �ۼ�(�ش��Լ�(System.in.read();)�� �����ϰ� �ִ� main�Լ� �ڿ� �Է�)

//������ ����(���)
//1. Ŀ���� �� ������ �̵� -> \r
//2. ���� �ٷ� �̵� -> \n
// =>���� �ȿ� �� ���� ����