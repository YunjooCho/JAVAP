package p03_method;

public class CompTestP {

	public static void main(String[] args) {
		int score = 85;
		String result = score >= 80 && score <= 100 ? "�հ�" : "���հ�";
		System.out.println("��� = " + result);
		System.out.println();
		
		String result2 = score % 2 == 0 ? "¦��" : "Ȧ��";
		System.out.println("��� = " + result2);
		System.out.println();
		
		int a = 26, b = 125;
		int big = a > b ? a : b;
		System.out.println("��� = " + big);
		System.out.println();
		System.out.println("ū �� = " + Math.max(a, b)); //MathŬ���� max()�޼ҵ�
		System.out.println("���� �� = " + Math.min(a, b));
		
		double p = Math.pow(2.0, 5.0);
		System.out.println("���� = " + p);
		System.out.println();
		
		int c = 15;
		String result3 = c % 2 == 0 && c % 3 ==0 ? "2�� 3�� ������̴�" : "2�� 3�� ������� �ƴϴ�";
		System.out.println("��� = " + result3);
			

	}

}
