package method;

public class Operator2 {

	public static void main(String[] args) {
		boolean a = 25 > 36;
		System.out.println("a = " + a); // a = false
		System.out.println("!a = " + !a); // !a = true
		System.out.println();
		
		String b = "apple"; //�ٷ� literal������ ����(String�� ����)
							//b�� apple�� �ִ� '�ּ�'�� ���� �ִ� ���� 
							//(apple�̶�� �����͸� ���� �ִ� ���� �ƴ�)
		String c = new String("apple"); // �޸� ����
		
		String result = b == c ? "����" : "�ٸ���"; //���ϴ� ������ �ּҰ� 
												 //��)b�� �ּҰ��� 100����, c�� �ּҰ��� 300����(���� ����)
		System.out.println("b == c : " + result);
		result = b != c ? "��" : "����"; 
		System.out.println("b != c : " + result);
		System.out.println();
		
		
		//�ּҰ� �ƴ� ���� ��(equals�Լ�) - JAVA������ ���
		//��JAVAScript������ ==�� ���
		result = b.equals(c) ? "����" : "�ٸ���"; //���ڿ�(�����Ͱ�)�� ��
		System.out.println("b.equlas(c) : " + result);
		result = !b.equals(c) ? "��" : "����"; 
		System.out.println("!b.equlas(c) : " + result);
		
		
	}

}
