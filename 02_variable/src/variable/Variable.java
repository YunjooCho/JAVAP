package variable;

public class Variable {

	public static void main(String[] args) {
		boolean a;
		a = true; //true = 1
		System.out.println("a = " + a);
		
		
		char b;
		b = 'A'; //char�̹Ƿ� 0000 0000 0100 0001 -> 65 = 'A'�� ASCII
		System.out.println("b = " + b);
		
		
		char c;
		c = 65;
		//c = 65535; -error char�� 65535���� ǥ�ð���(�ѱ����� ����)
		//char�� ���� ������ �߱� ������ ���ڰ� �ƴ� ���ڷ� ���
		//��ǻ�Ϳ��� 65536�̻�(char�� ���� �� ���� ��)�� 
		//int(����)�� �ν��ϱ� ������
		//65536�̻��� �Է��� ��� mismatch(char/int) �޽����� ��
		System.out.println("c = " + c); //����� : 'A'
		
		//int d;(32bit, 4byte) 
		//d = 65; int�̹Ƿ� 0000 0000 0000 0000 0000 0000 0100 0001
		int d = 65;
		System.out.println("d = " + d); 
		
		int e = 'A';
		System.out.println("e = " + e); //����� : 65
		
		float f; //�����Ű��� ���� ��� Ʋ�� ����, �Ǽ��� �⺻ double
		f = 43.8f; //���� ���� float��, �� ���� f�� ��ҹ��� ��� ����
		//f = (float) 43.8; - ����ȯ
		System.out.println("f = " + f); 
	}

}

//25    int�� ���
//25L   long�� ���
//43.8  double�� ���
//43.8f float�� ���
