package method;

public class CompTest {

	public static void main(String[] args) {
		int score = 85;
		
		//System.out.println(score >= 80 && score <= 100 ? "�հ�" : "���հ�");
		//���
		
		String result = score >= 80 && score <= 100 ? "�հ�" : "���հ�";
		System.out.println("��� = " + result);
		//������ ���� �� ���
		System.out.println();
		
		
		//score�� ���� ¦���̸� "¦��" �ƴϸ� "Ȧ��"��� ���
		String result2 = score % 2 == 0 ? "¦��" : "Ȧ��";
		System.out.println("��� = " + result2);
		System.out.println();
		
		//a, b�߿��� ū ���� ����Ͻÿ�
		int a = 26, b = 125;
		int big = a > b ? a : b;
		System.out.println("��� = " + big);
		System.out.println();
		System.out.println("ū �� = " + Math.max(a,b));
		System.out.println("���� �� = " + Math.min(a,b));
		
		
		//System.out.println("���� = " + Math.pow(2.0, 5.0));
		double p = Math.pow(2.0, 5.0);
		System.out.println("���� = " + p);
		System.out.println();
		
		//c�� 2�� 3�� ��������� Ȯ��
		int c = 15;
		result = c % 2 == 0 && c % 3 == 0 ? "2�� 3�� ������̴�" : "2�� 3�� ������� �ƴϴ�";
		System.out.println("��� = " + result);
		System.out.println();
		
	}

}
