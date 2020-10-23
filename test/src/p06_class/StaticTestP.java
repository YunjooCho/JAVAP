package p06_class;



public class StaticTestP {
	private int a;
	private static int b;
	
	public StaticTestP() {
		System.out.println("�⺻ ������");
		a = 3; //this.a
		b = 5;
	}
	
	static {
		System.out.println("static �ʱ�ȭ ����");
		//a = 10; - error : �ν��Ͻ� ������ �����ڷ� �ʱ�ȭ
		b = 7;
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a=" + this.a + "\t b=" + StaticTestP.b); 
		//this.a�� this�� ��������
		//StaticTest.b�� StaticTest�� ��������
	}
	
	public static void output() { //�ν��Ͻ� ������, super()�� ����� �� ����
		//System.out.println("a=" + a + "\t b=" + StaticTest.b); 
		//- error : static�޼ҵ忡�� static������ ���� ����
		System.out.println("static method...");
	}
	
	public static void main(String[] args) {
		StaticTestP st = new StaticTestP();
		//System.out.println("a=" + st.a + "\t b=" + b); 
		//disp()�޼ҵ忡���� a���� ���� �����ϳ� ���θ޼ҵ� �ȿ����� �׳� a�� ������ ��� �ȵ�
		st.calc();
		st.disp();
		System.out.println();
		//����� : a=4	 b=6(b = 8�� �ƴ�)
	}

}
