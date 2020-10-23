package class_constructor;

public class StaticTest { //extends Object�� �����Ǿ� ����
	private int a; //�ʵ�, �ν��Ͻ� ����
	private static int b; //�ʵ�, Ŭ���� ����, ������ ����
	
	static {
		System.out.println("�ʱ�ȭ ����"); //static�� �ʱ�ȭ
		b = 3;
	}
	
	public StaticTest() {
		System.out.println("�⺻ ������");
		this.a = 3; 
		//�ʱ�ȭ(static�� �����ڿ��� �ʱ�ȭ ���� ����), static�� �̹� main�޼ҵ� ������ �������
		
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a=" + this.a + "\t b=" + StaticTest.b); 
		//this.a�� this�� ��������
		//StaticTest.b�� StaticTest�� ��������
	}
	
	public static void output() { //�ν��Ͻ� ������, super()�� ����� �� ����
		//System.out.println("a=" + a + "\t b=" + StaticTest.b); 
		//- error : static�޼ҵ忡�� static������ ���� ����
		System.out.println("static method...");
	}
	
	public static void main(String[] args) {
		StaticTest st = new StaticTest();
		st.calc();
		st.disp();
		System.out.println();
		
		StaticTest st2 = new StaticTest();
		st2.calc();
		st2.disp();
		System.out.println();
		
		StaticTest st3 = new StaticTest();
		st3.calc();
		st3.disp();
		System.out.println();
		
		System.out.println("static �޼ҵ� ȣ��");
		StaticTest.output();//Ŭ������ ���� ����
		output();
		st.output();
		st2.output();
		st3.output();
	}
}//class StaticTest
