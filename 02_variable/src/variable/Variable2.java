package variable;

public class Variable2 {

	int a; //�ʵ�(Ŭ���� �ؿ� ����), �ν��Ͻ� ����, �ʱ�ȭ �Ǿ� ����(a = 0), ����
		   //�Լ� ���� ������ �ٸ� �޸𸮸� ����
	static int b; //�ʵ�(Ŭ���� �ؿ� ������ ������ ���� �ʵ�), ����
				  //Ŭ���� ����(static �ؿ� ����), �ʱ�ȭ �Ǿ� ����(b = 0)
	int c;
	String d; //String�Լ�, �ʱⰪ = null
	
	int e = 5;
	
	int f;
	//f = 7 -error(���Թ��� ���� ��ɾ�� ������(�޼ҵ�(�Լ�)) �ȿ��� ����)
	
	//��2020.9.30 ���� �߰��� ����
	public Variable2() {
		f = 7;
	}
	
	
	public static void main(String[] args) {
		int a = 10; // ��������(Local variable) : �Լ�(main) �ȿ� �ִ� ����
					// ���������� ������ ���� ���� �־�, �״�� ��� �ȵǹǷ� �ʱ�ȭ�� �ʿ�
					// 4byte�� ����, �Լ��� ������ �����
		System.out.println("�������� a = " + a);
		System.out.println("�ʵ� b = " + b); //b�տ� Ŭ�������� �����Ǿ� �ִ�
		System.out.println("�ʵ� b = " + Variable2.b); //������ Ŭ�������� Variable2(static�� �������� �ʾƵ� ��밡��)
		System.out.println("�ʵ� a = " + new Variable2().a); //�ν��Ͻ� ������ ���� �ڿ� ��� ����
		System.out.println("�ʵ� c = " + new Variable2().c); // �ٸ� Variable2 �޸𸮰� ����
		System.out.println("�ʵ� d = " + new Variable2().d); 
		//���� newŬ�������� �ּҰ� ����(1ȸ��), �ٽô� �� �ڸ��� ã�ư� �� ����
	}

}


//static
//	-���� �� �޸𸮿� �ڵ����� ����
// ��)������
// ������ ���θ��� ��, ��¥ ->�޸𸮿� �������ص� �ڵ����� �������

//�ʵ� ����
//�̸� ����� ���� ���� : static int b Ŭ���� ����
//��û�� ���� ������� ���� : int a �ν��Ͻ� ���� -> new Variable2().a
//                     ��Ŭ������ ������ �޸𸮸� �����ؾ� ��(new), ��û
//                     ��() : ������ �Լ�, new�� ���� ȣ��

//Ŭ������ ����