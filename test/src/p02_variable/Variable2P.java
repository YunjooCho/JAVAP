package p02_variable;

public class Variable2P {
	
	int a; //�ʵ�(Ŭ���� �ؿ� ����), �ν��Ͻ� ����, �ʱ�ȭ �Ǿ� ����(a = 0), ����
		   //�Լ� ���� ������ �ٸ� �޸𸮸� ����
	
	static int b; //�ʵ�(Ŭ���� �ؿ� ������ ������ ���� �ʵ�), ����
				  //Ŭ��������(static), �ʱ�ȭ �Ǿ� ����(b = 0)

	int c;
	String d;//String�Լ�, �ʱⰪ  = null
	
	int e = 5;
	
	int f;
	//f = 7; -error!(
	
	public Variable2P() {
		f = 7;
	}
	
	public static void main(String[] args) {
		int a = 10;//�������� - ���θ޼ҵ� �ȿ� �ִ� ����
				   //���������� �����Ⱚ�� ���� �־� �״�� ����� �ȵǹǷ� �ʱ�ȭ�� �ʿ�
				   //�޼ҵ尡 ������ �����
		System.out.println("�������� a = " + a);
		System.out.println("�ʵ� b = " + b);
		System.out.println("�ʵ� b = " + Variable2P.b);
		System.out.println("�ʵ� a = " + new Variable2P().a);
		System.out.println("�ʵ� c = " + new Variable2P().c);
		System.out.println("�ʵ� d = " + new Variable2P().d);

	}

}
