package variable;


/*
 *  ������ �����Ͽ� 320, 258�� ���� ���Ͻÿ�
 *  
 *  [������]
 *  320 + 258 = XXX
 *  320 - 258 = XXX(sub)
 *  320 * 258 = XXX(mul)
 *  320 / 258 = XXX(div) �Ҽ��� ���� 2�ڸ�
 */

public class CalcTest {

	public static void main(String[] args) {		
		short c = 320;
		short d = 258;
		short sum2 = (short)(c + d); 
		//JAVA Ư�� ��, ���� �� ������� ����� int������ ����� (short)�� ���� ����ȯ ��Ŵ
		System.out.println("short�� : " + c + " + " + d + " = " + sum2);
		System.out.println();
		
		int a = 320;
		int b = 258;
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		double div = (double)a / b; // ���� ����ȯ ��(double)�� �Է��Ͽ� ��ȯ / �ڵ� ����ȯ
		System.out.println(a + " + " + b + " = " + sum);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + mul);
		System.out.printf(a + " / " + b + " = %.2f\n", div);
		System.out.println(a + " / " + b + " = " + String.format("%.2f", div));
		
	}

}
