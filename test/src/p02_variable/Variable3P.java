package p02_variable;

public class Variable3P {
	int a; //�ν��Ͻ� ����
	static int b;//Ŭ���� ����
	
	static {
		b = 100;
	}
	
	
	public static void main(String[] args) {
		int a = 10; //��������, �⺻��
			        //�Լ� ������ �޸�
					//��� ���� - �ʱ�ȭ �ʿ�
		System.out.println("�������� = " + a);
		
		Variable3P v;//��ü
		//�� ������ �̸��� ���� �� �����Ƿ� �ּҰ� ��
		//�ּҺ���(Variable3P�� �ִ� ���� ����Ŵ
		v = new Variable3P();
		//Ŭ���� ����(������ �Լ�)
		//�� ������ ����, �̸��� ���� �� ����
		//Variable3P���� ��� �ν��Ͻ� ��, Ŭ���� ���� ����
		System.out.println("�ʵ� a = " + v.a);
		v.a = 20;
		System.out.println("�ʵ� a = " + v.a);
		
		Variable3P v2 = new Variable3P();
		System.out.println("�ʵ� a = " + v2.a);
		
		int sum = v.a + v2.a;
		System.out.println("�� = " + sum);
		
		System.out.println("�ʵ� b = " + Variable3P.b);
		System.out.println("�ʵ� b = " + b);
		System.out.println("�ʵ� b = " + v.b);

	}

}
