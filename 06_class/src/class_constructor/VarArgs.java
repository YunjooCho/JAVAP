package class_constructor;

public class VarArgs {
	//�����ε��, �Ķ���͸� ����ȭ�ϴ� ���(���� ���� ����, �Ű������� ��������)
	private int sum;
	
	//sum�޼ҵ�(�����ε�)
	//VarArgs������� ���� ��
//	public int sum(int a, int b) {
//		sum = a + b;
//		return sum;
//	}
//	
//	public int sum(int a, int b, int c) {
//		sum = a + b + c;
//		return sum;
//	}
//	
//	public int sum(int a, int b, int c, int d) {
//		sum = a + b + c + d;
//		return sum;
//	}
	
	//VarArgs ���
	public int sum(int ... ar) { //�Ķ���͸� �����迭�� ����
		//�Ķ���� int�� Object��(��� ������Ÿ���� �� �ްڴ�) - �ڵ����� autoboxing, unboxing
		int hap = 0;
		for(int i = 0; i < ar.length; i++) {
			
			hap += ar[i];
		}//for
		System.out.println("�Ķ���� ���� : " + ar.length + "��"); //���Ķ���� ����
		return hap;
	}
	
	
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		System.out.println("�� = " + va.sum(10,20)); //ȣ��
		System.out.println("�� = " + va.sum(10,'A'));
		System.out.println("�� = " + va.sum(10,20,30));
		System.out.println("�� = " + va.sum(10,20,30,40));
		
	}
}
