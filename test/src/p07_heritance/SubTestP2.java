package p07_heritance;


public class SubTestP2 extends SuperTestP2 {
	protected String name; //�ڽ�Ŭ����
	protected int age; //�ڽ�Ŭ����
	
	public SubTestP2() {
		System.out.println("SubTestP2 �⺻ ������");
	}
	
	public SubTestP2(double weight, double height, String name, int age) {
		System.out.println("SubTestP2 ������");
		super.weight = weight;
		super.height = height;
		this.name = name;
		this.age = age;
	}
	
	public void outPut() {
		System.out.println("������ = " + weight);//super���� �������� �ʾƵ� �θ�Ŭ������ �����ϱ� ������ �����۵�
		System.out.println("Ű = " + height);//super���� �������� �ʾƵ� �θ�Ŭ������ �����ϱ� ������ �����۵�
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
	}
	
	public static void main(String[] args) {
		SubTestP2 sub = new SubTestP2();
		System.out.println();
		
		SubTestP2 sub2 = new SubTestP2(75.3, 185.5, "ȫ�浿", 25);
		sub2.outPut();
		System.out.println();
		
		sub2.disp(); //�θ�Ŭ���� �޼ҵ�
		System.out.println("----------------------------------");
		
		SuperTestP2 bb = new SubTestP2(35.8, 156.3, "�ڳ�", 13);
		//bb.outPut(); //-error : �ڽ�Ŭ���� �޼ҵ�� �θ�Ŭ�������� ȣ���� �� ����
		bb.disp();
	}
}


