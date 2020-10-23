package p06_class;

public class VarArgsP {
	//�����ε��, �Ķ���͸� ����ȭ�ϴ� ���(���� ���� ����, �Ű������� ��������)
	
	//�ʵ�� ����
	private int sum;
	
	//Sum�޼ҵ�(�����ε�)
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
//	
	//VarArgs���
	public int sum(int...ar) {//�Ķ���͸� �����迭�� ����
		//�Ķ���� int�� Object�� �ٲٸ� ��� ������Ÿ���� �� �ްڴٴ� �� - �ڵ����� autoBoxing, UnBoxing
		int hap = 0;
		for(int i  = 1; i < ar.length; i++) {
			hap += ar[i];
		}
		return hap;
	}
	
	public static void main(String[] args) {
		VarArgsP va = new VarArgsP();
		System.out.println("�� = " + va.sum(10,20));
		System.out.println("�� = " + va.sum(10,'A'));
		System.out.println("�� = " + va.sum(10,20,30));
		System.out.println("�� = " + va.sum(10,20,30,40));
		System.out.println("�� = " + va.sum(10,20,30,100));

	}

}
