package class_constructor;


import static java.lang.Math.*;//���ϵ� ī��, all
//�ؿ� �� import������ �����(MathŬ������ �ִ� ��� �Լ� ��밡��)
//import static java.lang.Math.random;
//import static java.lang.Math.pow;
//Math.�� ���� �ʱ� ���� import�� ������
//����ִ� �Լ����� �˷���
//import static �� ���� �������
import static java.lang.String.format;
import static java.lang.System.out;
//out�� �ʵ��, println()�� �޼ҵ��
//import static�� ����ϸ� �޼ҵ�� �տ� [Ŭ������.]�� ���������ϴ�.

public class ImportStatic {

	public static void main(String[] args) {
		out.println("���� = " + random());//Math.random()�� static�Լ�
		out.println("������ = " + pow(2, 10));
		//pow�� ���� class ImportStaticŬ�������� �ش� �޼ҵ带 ã���Ƿ� ������ �߻�
		//import static ����
		//���� �ٸ� Ŭ������ �־� �� ���� random()�� ������ ��� ������ ���� �Ұ�
		//�� ���� Ŭ������.�޼ҵ��()���� ǥ��
		out.println("�Ҽ� ���� 2°�ڸ� = " + format("%.2f", 123.456));
		//String.format -> format���� ���̱�
		

	}

}
