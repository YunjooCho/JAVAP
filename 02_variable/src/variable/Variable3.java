package variable;

public class Variable3 {
	int a; //Ŭ���� ������ �޸�
	static int b; //�Ŵ��� ������
	
	public static void main(String[] args) {
		int a = 10; //��������, �⺻��
					//�Լ� ������ �޸�
		  	   		//������� - �ʱ�ȭ �ʿ�
		System.out.println("�������� a = " + a);
		
		Variable3 v; //��ü
		//�Ʒ� ������ heap������ �̸��� ���� �� �����Ƿ� �ּҷ� ��
		//�ּҺ���(Variable3�� �ִ� ���� ����Ŵ)
		//������ ��� �ƴ�
		v = new Variable3();
		//Ŭ���� ���� + ������ �Լ�
		//heap������ ����
		//�̸��� ���� �� ����
		//Variable3���� ��� �ν��Ͻ� ��, Ŭ���� ���� ����
		System.out.println("�ʵ� a = " + v.a);
		v.a = 20;
		//'.' : ~�ȿ�(�Ҽ�)
		System.out.println("�ʵ� a = " + v.a);
		
		Variable3 v2; //��ü
		v2 = new Variable3();
		//v�� ��Ÿ���� new Variable3();�ʹ� �ٸ� �޸� ����
		System.out.println("�ʵ� a = " + v2.a);
		//�ٸ� �޸� �̹Ƿ� ���� 20�� �ƴ� �ʱ�ȭ�� 0�� ��µ�
		
		int sum = v.a + v2.a;
		System.out.println("�� = " + sum);
		
		System.out.println("�ʵ� b = " + Variable3.b);
		System.out.println("�ʵ� b = " + b);
		System.out.println("�ʵ� b = " + v.b);
		//public class Variable3 ���� ���̹Ƿ� �׳� ��� ����
	}

}

//main�Լ��� �� ���ϴ� �ϳ��� ����
//�Ʒ��� ���� ��찡 ����

//���ϸ� : Test.java
//		 Test.class
//		 Sample.class

//class Test {
//		public static void main(String[] args) {
//  }
//}
//class Sample {
//}