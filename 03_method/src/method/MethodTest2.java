package method;

public class MethodTest2 {
	public void disp(){//����(���� ����) , �Է�, void - ������ ������� ����
					   //new �ʿ���
		System.out.println("non-static method");
	}
	
	public static void output() {//���� 
								 //�������� ��밡��(new �ʿ����)
		System.out.println("static method");
	}
	
	public static void main(String[] args) {
		//ȣ��
		MethodTest2.output();
		output(); //Ŭ���� �޼ҵ�(static)�� MethodTest2 ���� ���̹Ƿ� Ŭ������ �Ƚᵵ ��
		System.out.println();
		
		MethodTest2 m = new MethodTest2();
		m.disp();
		//System.out.prinltn(MethodTest2.m);
		//new MethodTest2().disp(); - 1ȸ���̹Ƿ� �����ϴ°� ����
	}

}//MethodTest2 ����

//��� �޼ҵ�� �ݵ�� ȣ���� ������ �ǵ��� �;��Ѵ�
//(main�� �Լ� -> static void output()���� �� -> �������� �ǵ��ƿ�)
