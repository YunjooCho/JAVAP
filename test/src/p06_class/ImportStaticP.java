package p06_class;


import static java.lang.String.format;
import static java.lang.System.out;


public class ImportStaticP {
	public static void main(String[] args) {
		out.println("���� = " + Math.random()); //MathŬ������ random()�޼ҵ�
		out.println("������ = " + Math.pow(2,5));
		out.println("�Ҽ� ���� 2°�ڸ� = " + format("%.2f",123.456));
	}
}
